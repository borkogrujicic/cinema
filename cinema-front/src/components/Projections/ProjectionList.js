import { useHistory } from "react-router-dom";
import React from "react";
import { Table, Button } from "react-bootstrap";
import FrontAxios from "../../apis/FrontAxios";

import './ProjectionList.css';

const Projections = (props) => {
  let history = useHistory();

  const goToReservation = (id) => {
    history.push("/projekcije/rezervisi/" + id);
  };

  const goToAdd = () => {
    history.push("projekcije/dodavanje");
  };

  const goToMovie = id => {
    history.push("filmovi/" + id)
  }

  const remove = (id) => {
    FrontAxios.delete("/projekcije/" + id)
      .then((res) => {
        // handle success
        console.log(res);
        alert("Projection was deleted successfully!");
        window.location.reload();
      })
      .catch((error) => {
        // handle error
        console.log(error);
        alert("Error occured please try again!");
      });
  };


  return (
    <div>
      <h1>Projekcije</h1>
      {window.localStorage["role"] === "ROLE_ADMIN"
        ? [
            <Button variant="success" onClick={() => goToAdd()}>
              Dodaj projekciju
            </Button>,
          ]
        : null}
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
              <th>Detalji filma</th>
          </tr>
        </thead>
        <tbody>
          {props.projections.map((projection) => (
            <tr key={props.id}>
              <td className="goTo" onClick={() => goToMovie(projection.film.id)}>
                {projection.film.naziv}
              </td>
              <td>{projection.tip.naziv}</td>
              <td>{projection.sala.naziv}</td>
              <td>{projection.datumIVreme}</td>
              <td>{projection.cena}</td>
              {window.localStorage["role"] === "ROLE_KORISNIK"
                ? [
                    <td>
                      <Button
                        variant="success"
                        onClick={() => goToReservation(projection.id)}
                      >
                        Rezervisi
                      </Button>
                    </td>,
                  ]
                : null}
              {window.localStorage["role"] === "ROLE_ADMIN"
                ? [
                    <td>
                      <Button
                        variant="danger"
                        onClick={() => remove(projection.id)}
                      >
                        Delete
                      </Button>
                    </td>,
                  ]
                : null}
                <td><Button variant="info" onClick={() => goToMovie(projection.film.id)}>Detalji filma</Button></td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default Projections;
