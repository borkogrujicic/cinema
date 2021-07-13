import React, { useState, useEffect } from "react";
import { Row, Col, Button, Form } from "react-bootstrap";
import FrontAxios from "../../apis/FrontAxios";

const NewProjection = (props) => {
  const [filmovi, setFilmovi] = useState([]);
  const [sale, setSale] = useState([]);
  const [tipovi, setTipovi] = useState([]);
  const [film, setFilm] = useState({});
  const [sala, setSala] = useState({});
  const [tip, setTip] = useState({});
  const [datumIVreme, setDatumIVreme] = useState("");
  const [cena, setCena] = useState("");

  useEffect(() => {
    getFilmovi();
    getSale();
    getTipovi()
  }, []);

  function getFilmovi() {
    FrontAxios.get("/filmovi")
      .then((res) => {
        console.log(res);
        setFilmovi(res.data);
      })
      .catch((err) => {
        console.log(err);
        alert("Couldn't fetch movies");
      });
  }

  function getSale() {
    FrontAxios.get("/sale")
      .then((res) => {
        console.log(res);
        setSale(res.data);
      })
      .catch((err) => {
        console.log(err);
        alert("Couldn't fetch sale");
      });
  }

  function getTipovi() {
    FrontAxios.get("/tipovi")
      .then((res) => {
        console.log(res);
        setTipovi(res.data);
      })
      .catch((err) => {
        console.log(err);
        alert("Couldn't fetch types");
      });
  }

  const movieSelectionChanged = (e) => {
    // console.log(e);

    let movieId = e.target.value;
    let movie = filmovi.find((movie) => movie.id == movieId);

    setFilm(movie);
  };

  const tipSelectionChange = (e) => {
    // console.log(e);

    let tipId = e.target.value;
    let tip = tipovi.find((tip) => tip.id == tipId);

    setTip(tip);
  };

  const salaSelectionChange = (e) => {
    // console.log(e);

    let salaId = e.target.value;
    let sala = sale.find((sala) => sala.id == salaId);

    setSala(sala);
  };

  const cenaChangeHandler = (event) => {
    setCena(event.target.value);
  };

  const dateTimeChangeHaldner = (event) => {
    setDatumIVreme(event.target.value);
  };

  const submitHandler = (e) => {
      e.preventDefault();

      const projekcija = {
          params: {
              film: film,
              tip: tip,
              sala: sala,
              datumIVreme: datumIVreme,
              cena: cena
          }
        }
          FrontAxios.post("/projekcije", projekcija)
          .then((res) => {
            console.log(res);
            alert ("Projection added succesffully")
          })
          .catch((err) => {
            console.log(err);
            alert("Couldn't add projection");
          });
      }

  return (
    <div>
      <Form>
        <Form.Group>
          <Form.Label htmlFor="pMovie">Film</Form.Label>
          <Form.Control
            as="select"
            id="pMovie"
            onChange={(event) => movieSelectionChanged(event)}
          >
            <option></option>
            {filmovi.map((film) => {
              return (
                <option key={film.id} value={film.id}>
                  {film.naziv}
                </option>
              );
            })}
          </Form.Control>
          <br />
        </Form.Group>
        <Form.Group>
          <Form.Label htmlFor="pSala">Sala</Form.Label>
          <Form.Control
            as="select"
            id="pSala"
            onChange={(event) => salaSelectionChange(event)}
          >
            <option></option>
            {sale.map((sala) => {
              return (
                <option key={sala.id} value={sala.id}>
                  {sala.naziv}
                </option>
              );
            })}
          </Form.Control>
          <br />
        </Form.Group>
        <Form.Group>
          <Form.Label htmlFor="pTip">Tip projekcije</Form.Label>
          <Form.Control
            as="select"
            id="pTip"
            onChange={(event) => tipSelectionChange(event)}
          >
            <option></option>
            {tipovi.map((tip) => {
              return (
                <option key={tip.id} value={tip.id}>
                  {tip.naziv}
                </option>
              );
            })}
          </Form.Control>
          <br />
        </Form.Group>
        <Form.Group>
          <Form.Label htmlFor="pCena">Cena</Form.Label>
          <Form.Control
            id="pCena"
            name="cena"
            type="number"
            step='0.1'
            value={cena}
            onChange={cenaChangeHandler}
          />
        </Form.Group>
        <Form.Group>
          <Form.Label htmlFor="pDatumIVreme">Datum i vreme projekcije</Form.Label>
          <Form.Control
            id="pDateTime"
            name="pDateTime"
            value={datumIVreme}
            onChange={dateTimeChangeHaldner}
          />
        </Form.Group>
        <Button onClick={submitHandler}>Add</Button>
      </Form>
    </div>
  );
};

export default NewProjection;
