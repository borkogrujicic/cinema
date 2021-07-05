import React, { useState, useEffect } from "react";
import FrontAxios from "../../apis/FrontAxios";
import { Form, Row, Col, Button } from "react-bootstrap";

const Rezervacija = (props) => {
  const [projekcijaId, setProjekcijaId] = useState("");
  const [projekcijaDatum, setProjekcijaDatum] = useState("");
  const [projekcijaFilm, setProjekcijaFilm] = useState("");
  const [sedisteId, setSedisteId] = useState("");
  const [sedista, setSedista] = [{}]

//   useEffect(() => {
//     getProjection(),
//       getSedista(props.projekcija.sala.id);
//   }, []);

  
  const fetchData = (projekcijaId, salaId) => {
    FrontAxios.get("/projekcije/" + projekcijaId)
    .then((res) => {
      console.log(res);
      setProjekcijaId(res.data.id);
      setProjekcijaDatum(res.data.datumIVreme)
      setProjekcijaFilm(res.data.film.naziv)
    })
    .catch((err) => {
      console.log(err);
      alert("Couldn't fetch projection");
    });

        FrontAxios.get("/sale/" + salaId)
          .then((res) => {
            console.log(res);
            setSedista(res.data);
          })
          .catch((err) => {
            console.log(err);
            alert("Couldn't fetch seats");
          });
    
}


  function getProjection(projekcijaId) {
    FrontAxios.get("/projekcije/" + projekcijaId)
      .then((res) => {
        console.log(res);
        setProjekcijaId(res.data.id);
        setProjekcijaDatum(res.data.datumIVreme)
        setProjekcijaFilm(res.data.film.naziv)
      })
      .catch((err) => {
        console.log(err);
        alert("Couldn't fetch projection");
      });
  }

  function getSedista(salaId) {
    FrontAxios.get("/sale/" + salaId)
      .then((res) => {
        console.log(res);
        setSedista(res.data);
      })
      .catch((err) => {
        console.log(err);
        alert("Couldn't fetch seats");
      });
  }

  function rezervisi () {
    var params = {
        projekcijaId: projekcijaId,
        sedisteId: sedisteId,
      };
  
      FrontAxios.post("/karte/", params)
        .then((res) => {
          // handle success
          console.log(res);
          alert("Reservation was made successfully!");
          this.props.history.push("/projekcije");
        })
        .catch((error) => {
          // handle error
          console.log(error);
          alert("Error occured please try again!");
        });
  }

  sedisteId = (event) => {
    console.log(event.target.value);

    const { name, value } = event.target;
    console.log(name + ", " + value);

    setSedisteId(value);
  };

  
  return (
    <div>
      <Row>
        <Col></Col>
        <Col xs="12" sm="10" md="8">
          <h1>Izvrsi rezervaciju za {projekcijaFilm} za datum {projekcijaDatum} </h1>

          <Form>

            <Form.Group>
              <Form.Label htmlFor="pSediste">Sediste</Form.Label>
              <Form.Control
                name="sediste"
                as="select"
                id="pSediste"
                onChange={(event) => this.sedisteId(event)}
              >
                <option></option>
                {sedista.map((sediste) => {
                  return (
                    <option key={sediste.redniBroj} value={sediste.redniBroj}>
                      {sediste.redniBroj}
                    </option>
                  );
                })}
              </Form.Control>
              <br />
            </Form.Group>

            <Button
              onClick={(event) => {
                this.rezervisi(event);
              }}
            >
              Rezervisi
            </Button>
          </Form>
        </Col>
        <Col></Col>
      </Row>
    </div>
  ); 
}

    


export default Rezervacija;
