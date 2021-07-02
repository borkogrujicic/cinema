import React from "react";
import { Table } from "react-bootstrap";

const MoviesList = (props) => {
  return (
    <div>
      <h1>Filmovi</h1>

      <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          <tr>
            <th>Naziv</th>
            <th>Trajanje</th>
            <th>Reziser</th>           
            <th>Glumci</th>
            <th>Zanr</th>
            <th>Distributer</th>
            <th>Zemlja porekla</th>
            
          </tr>
        </thead>
        <tbody>
          {props.movies.map((movie) => (
            <tr key={props.id}>
              <td>{movie.naziv}</td>
              <td>{movie.trajanje}</td>
              <td>{movie.reziser}</td>
              <td>{movie.glumci}</td>
              <td>{movie.zanrovi}</td>
              <td>{movie.distributer}</td>
              <td>{movie.zemljaPorekla}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default MoviesList;
