import React, { useState, useEffect } from "react";
import { Form, Button, Collapse } from "react-bootstrap";
import MoviesList from "./MoviesList";
import FrontAxios from "../../apis/FrontAxios";
import NewMovie from "./NewMovie";

const Movies = () => {
  const [filmovi, setFilmovi] = useState([]);
  const [naziv, setNazivSearch] = useState("");
  const [zanrovi, setZanroviSearch] = useState("");
  const [showSearchForm, setSearchForm] = useState(false);

  useEffect(() => {
    getMovies();
  }, []);

  const searchNazivValueInputChange = (event) => {
    setNazivSearch(event.target.value);
    getMovies();
  };

  const searchZanroviValueInputChange = (event) => {
    setZanroviSearch(event.target.value);
    getMovies();
  };

  const addMovieHandler = (movie) => {
    FrontAxios.post("/filmovi", movie)
      .then((res) => {
        console.log(res);

        alert("Uspesno ste dodali film!");
        window.location.reload();
      })
      .catch((error) => {
        console.log(error);

        alert("Greska! Neuspesno dodavanje filma");
      });
  };

  function getMovies() {
    let config = {
      params: {
        naziv: naziv,
        zanrovi: zanrovi,
      },
    };
    FrontAxios.get("/filmovi", config)
      .then((res) => {
        console.log(res);
        setFilmovi(res.data);
      })
      .catch((err) => {
        console.log(err);
        alert("Couldn't fetch movies");
      });
  }

  return (
    <div>
      {window.localStorage["role"] == "ROLE_ADMIN"
        ? [<NewMovie onAddMovie={addMovieHandler} />]
        : null}
      <Form.Group style={{ marginTop: 35 }}>
        <Form.Check
          type="checkbox"
          label="Show search form"
          onClick={(event) =>
            setSearchForm(event.target.checked)
          }
        />
      </Form.Group>
      <Collapse in={showSearchForm}>
        <Form style={{ marginTop: 10 }}>
          <Form.Group>
            <Form.Label>Naziv filma</Form.Label>
            <Form.Control
              onChange={(event) => searchNazivValueInputChange(event)}
              name="naziv"
              value={naziv}
              as="input"
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Zanrovi</Form.Label>
            <Form.Control
              onChange={(event) => searchZanroviValueInputChange(event)}
              name="zanrovi"
              value={zanrovi}
              as="input"
            ></Form.Control>
          </Form.Group>
          <br></br>
          <Button onClick={getMovies}>Search</Button>
        </Form>
      </Collapse>
      <MoviesList movies={filmovi} />
    </div>
  );
};

export default Movies;
