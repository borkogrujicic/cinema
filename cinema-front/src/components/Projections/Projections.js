import React, { useState, useEffect } from "react";
import ProjectionList from "./ProjectionList";
import FrontAxios from "../../apis/FrontAxios";
import { Button, Form, Collapse } from "react-bootstrap";

const Projections = () => {
  const [projekcije, setProjekcije] = useState([]);
  const [pageNo, setPageNo] = useState("");
  const [totalPages, setTotalPages] = useState("");
  const [showSearchForm, setShowSearchForm] = useState(false);

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
      <Form.Group style={{ marginTop: 35 }}>
        <Form.Check
          type="checkbox"
          label="Show search form"
          onClick={(event) => setShowSearchForm(event.target.checked)}
        />
      </Form.Group>
      <Collapse in={showSearchForm}>
              <Form style={{ marginTop: 10 }}>
          <Form.Group>
            <Form.Label>Naziv filma</Form.Label>
            <Form.Control
              name="naziv"
              as="input"
            ></Form.Control>
          </Form.Group>
          <Form.Label htmlFor="pTip">Tip projekcije</Form.Label>
              <Form.Control
                name="tip"
                as="select"
                id="tip"
                // onChange={(e) => ValueInputChange(e)}
              >
                <option></option>
                <option value="2D">2D</option>
                <option value="3D">3D</option>
                <option value="4D">4D</option>
              </Form.Control>
          </Form>

      </Collapse> 
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
