import React, { useState } from "react";
import { Table } from "react-bootstrap";

const Projections = (props) => {
  return (
    <div>
      <h1>Projekcije</h1>

      <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          <tr>
            <th>Film</th>
            <th>Tip projekcije</th>
            <th>Sala</th>
            <th>Datum i vreme</th>
            <th>Cena karte</th>
          </tr>
        </thead>
        <tbody>
          {props.projections.map((projection) => (
            <tr key={props.id}>
              <td>{projection.film.naziv}</td>
              <td>{projection.tip.naziv}</td>
              <td>{projection.sala.naziv}</td>
              <td>{projection.datumIVreme}</td>
              <td>{projection.cena}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default Projections;
