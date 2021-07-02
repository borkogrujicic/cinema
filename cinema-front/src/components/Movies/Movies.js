import React, { useState, useEffect } from "react";
import MoviesList from "./MoviesList";
import FrontAxios from "../../apis/FrontAxios";

const Movies = () => {
  const [filmovi, setFilmovi] = useState([]);

  useEffect(() => {
    getMovies();
  }, []);

  function getMovies() {
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

  return (
    <div>
      <MoviesList movies={filmovi} />
    </div>
  );
};

export default Movies;
