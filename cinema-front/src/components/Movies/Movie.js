import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import { Table, Button } from "react-bootstrap";
import FrontAxios from "../../apis/FrontAxios";

const Movie = (props) => {
  const [film, setFilm] = useState({});
  const [projekcije, setProjekcije] = useState([]);

  let history = useHistory();

  useEffect(() => {
    getData();
  }, []);

  function getData() {
    getMovieById(props.match.params.id);
    getProjections(props.match.params.id);
  }

  const getMovieById = (id) => {
    FrontAxios.get("/filmovi/" + id)
      .then((res) => {
        // handle success
        console.log(res);
        setFilm(res.data);
      })
      .catch((error) => {
        // handle error
        console.log(error);
        alert("Error occured please try again!");
      });
  };

  const getProjections = (id) => {
    FrontAxios.get("/filmovi/" + id + "/projekcije")
      .then((res) => {
        // handle success
        console.log(res);
        setProjekcije((result) => [...result, res.data]);
      })
      .catch((error) => {
        // handle error
        console.log(error);
        alert("Error occured please try again!");
      });
  };

  const goToReservation = (id) => {
    history.push("/projekcije/rezervisi/" + id);
  };

  return (
    <div>
      <Table>
        <thead>
          <tr>
            <th>Naziv</th>
            <th>Reziser</th>
            <th>Glumci</th>
            <th>Zanrovi</th>
            <th>Trajanje</th>
            <th>Distributer</th>
            <th>Zemlja porekla</th>
            <th>Godina proizvodnje</th>
            <th>Opis</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{film.naziv}</td>
            <td>{film.reziser}</td>
            <td>{film.glumci}</td>
            <td>{film.zanrovi}</td>
            <td>{film.trajanje}</td>
            <td>{film.distributer}</td>
            <td>{film.zemljaPorekla}</td>
            <td>{film.godinaProizvodnje}</td>
            <td>{film.opis}</td>
          </tr>
        </tbody>
      </Table>
      <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          <tr>
            <th>Film</th>
            <th>Tip projekcije</th>
            <th>Sala</th>
            <th>Datum i vreme</th>
            <th>Cena karte</th>
            {window.localStorage["role"] === "ROLE_KORISNIK"
              ? [<th>Rezervisi</th>]
              : null}
            {window.localStorage["role"] === "ROLE_ADMIN"
              ? [<th>Delete</th>]
              : null}
          </tr>
        </thead>
        <tbody>
          {projekcije.map((projection) => (
            <tr key={projection.id}>
              <td>{film.naziv}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default Movie;
