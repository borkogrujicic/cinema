import React, { useState, useEffect } from "react";
import ProjectionList from "./ProjectionList";
import FrontAxios from "../../apis/FrontAxios";

const Projections = () => {
  const [projekcije, setProjekcije] = useState([]);

  useEffect(() => {
    getProjections();
  }, []);

  function getProjections() {
    FrontAxios.get("/projekcije")
      .then((res) => {
        console.log(res);
        setProjekcije(res.data);
      })
      .catch((err) => {
        console.log(err);
        alert("Couldn't fetch projections");
      });
  }

  return (
    <div>
      <ProjectionList projections={projekcije} />
    </div>
  );
};

export default Projections;
