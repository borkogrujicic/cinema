import React, { useState, useEffect } from "react";
import FrontAxios from "../../apis/FrontAxios";

const Movie = (props) => {
  const [film, setFilm] = useState({});
  const [projekcije, setProjekcije] = [];

  useEffect(() => {
    getMovieById(props.id);
    getProjections()
  }, []);

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
    FrontAxios.get("/filmovi/" + id + '/projekcije')
    .then((res) => {
      // handle success
      console.log(res);
      setProjekcije(res.data);
    })
    .catch((error) => {
      // handle error
      console.log(error);
      alert("Error occured please try again!");
    });
  };

  return (
      <div>
          
      </div>
  )


};

export default Movie;
