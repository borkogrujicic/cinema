import React, { useState, useEffect } from "react";
import MoviesList from "./MoviesList";
import FrontAxios from "../../apis/FrontAxios";
import NewMovie from "./NewMovie";

const Movies = () => {
  const [filmovi, setFilmovi] = useState([]);

  useEffect(() => {
    getMovies();
  }, []);

  const addMovieHandler = (movie) => {
    FrontAxios.post("/filmovi", movie)
      .then((res) => {
        console.log(res);

        alert("Uspesno dodat film");
        this.props.history.push("/projekcije");
      })

      .catch((error) => {
        console.log(error);

        alert("Error! Neuspesno dodavanje filma");
      });
  };

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
      <NewMovie onAddMovie={addMovieHandler}/>
    </div>
  );
};

export default Movies;
