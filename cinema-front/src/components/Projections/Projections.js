import React, { useState, useEffect } from "react";
import ProjectionList from "./ProjectionList";
import FrontAxios from "../../apis/FrontAxios";
import { Button } from "react-bootstrap";

const Projections = () => {
  const [projekcije, setProjekcije] = useState([]);
  const [pageNo, setPageNo] = useState("");
  const [totalPages, setTotalPages] = useState("");

  useEffect(() => {
    getProjections(0);
  }, []);

  function getProjections(pageNo) {
    let config = {
      params: {
        pageNo,
      },
    };
    FrontAxios.get("/projekcije", config)
      .then((res) => {
        console.log(res);
        setProjekcije(res.data);
        setTotalPages(res.headers["total-pages"]);
        setPageNo(pageNo);
      })
      .catch((err) => {
        console.log(err);
        alert("Couldn't fetch projections");
      });
  }

  const changePage = (direction) => {
    const page = pageNo + direction;
    getProjections(page);
  };

  return (
    <div>
      <ProjectionList projections={projekcije} />
      <Button disabled={pageNo == 0} onClick={() => changePage(-1)}>
        Previous
      </Button>
      <Button disabled={totalPages == pageNo + 1} onClick={() => changePage(1)}>
        Next
      </Button>
    </div>
  );
};

export default Projections;
