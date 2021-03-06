import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import { Button, Form } from "react-bootstrap";
import FrontAxios from "../../apis/FrontAxios";

import styles from "./NewProjection.module.css";

const NewProjection = (props) => {
  const [filmovi, setFilmovi] = useState([]);
  const [sale, setSale] = useState([]);
  const [tipovi, setTipovi] = useState([]);
  const [film, setFilm] = useState({});
  const [sala, setSala] = useState({});
  const [tip, setTip] = useState({});
  const [datumIVreme, setDatumIVreme] = useState("");
  const [cena, setCena] = useState("");
  const [isDataValid, setIsDataValid] = useState(true);

  useEffect(() => {
    getFilmovi();
    getSale();
    getTipovi();
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

    if (e.target.value.trim().length > 0) {
      setIsDataValid(true);
    }

    let movieId = e.target.value;
    let movie = filmovi.find((movie) => movie.id == movieId);

    setFilm(movie);
  };

  const tipSelectionChange = (e) => {
    // console.log(e);

    if (e.target.value.trim().length > 0) {
      setIsDataValid(true);
    }

    let tipId = e.target.value;
    let tip = tipovi.find((tip) => tip.id == tipId);

    setTip(tip);
  };

  const salaSelectionChange = (e) => {
    // console.log(e);

    if (e.target.value.trim().length > 0) {
      setIsDataValid(true);
    }

    let salaId = e.target.value;
    let sala = sale.find((sala) => sala.id == salaId);

    setSala(sala);
  };

  const cenaChangeHandler = (event) => {
    if (event.target.value.trim().length > 0) {
      setIsDataValid(true);
    }
    setCena(event.target.value);
  };

  const dateTimeChangeHaldner = (event) => {
    if (event.target.value.trim().length > 0) {
      setIsDataValid(true);
    }
    setDatumIVreme(event.target.value);
  };

  const submitHandler = (e) => {
    e.preventDefault();

    // if (film === null) {
    //   setIsDataValid(false);
    //   alert ('Niste odabrali film!');
    //   return;
    // }
    // if (tip === null) {
    //   setIsDataValid(false);
    //   alert ('Niste odabrali tip!');
    //   return;
    // }
    // if (sala === null) {
    //   setIsDataValid(false);
    //   alert ('Niste odabrali salu!');
    //   return;
    // }
    // if (datumIVreme.trim().length === 0) {
    //   setIsDataValid(false);
    //   alert('Niste uneli datum i vreme!')
    //   return;
    // }
    // if (cena < 1) {
    //   setIsDataValid(false);
    //   alert('Cena mora biti veca od 0!')
    //   return;
    // }

    if (
      film === null ||
      tip === null ||
      sala === null ||
      datumIVreme.trim().length === 0 ||
      cena < 1
    ) {
      setIsDataValid(false);
      alert("Podaci nisu validni!");
      return;
    }

    const projekcija = {
      params: {
        film: film,
        tip: tip,
        sala: sala,
        datumIVreme: datumIVreme,
        cena: cena,
      },
    };
    FrontAxios.post("/projekcije", projekcija.params)
      .then((res) => {
        console.log(res);
        alert("Projection added succesffully");
        props.history.push('/projekcije');
      })
      .catch((err) => {
        console.log(err);
        alert("Couldn't add projection");
      });
  };

  return (
    <Form onSubmit={submitHandler}>
      <div
        className={`${styles["form-control"]} ${
          !isDataValid && styles.invalid
        }`}
      >
        <Form.Group>
          <Form.Label htmlFor="pMovie">Film</Form.Label>
          <Form.Control
            as="select"
            id="pMovie"
            onChange={movieSelectionChanged}
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
          <Form.Control as="select" id="pSala" onChange={salaSelectionChange}>
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
          <Form.Control as="select" id="pTip" onChange={tipSelectionChange}>
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
            step="0.1"
            value={cena}
            onChange={cenaChangeHandler}
          />
        </Form.Group>
        <Form.Group>
          <Form.Label htmlFor="pDatumIVreme">
            Datum i vreme projekcije
          </Form.Label>
          <Form.Control
            id="pDateTime"
            name="pDateTime"
            value={datumIVreme}
            onChange={dateTimeChangeHaldner}
          />
        </Form.Group>
      </div>
      <Button type="submit" varriant="info">
        Dodaj
      </Button>
    </Form>
  );
};

export default NewProjection;
