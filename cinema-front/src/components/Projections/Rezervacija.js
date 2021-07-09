import React from "react";
import { Form, Row, Col, Button } from "react-bootstrap";
import FrontAxios from "./../../apis/FrontAxios";

class Reservation extends React.Component {
  constructor(props) {
    super(props);

    let projekcija = {
      id: 0,
      film: {},
      tip: {},
      sala: {},
      datumIVreme: "",
      cena: 0,
    };

    this.state = {
      projekcija: projekcija,
      sedista: [],
    };
  }

  componentDidMount() {
    this.getProjection(1);
    this.getSedista(1);
  }

  getProjection(id) {
    FrontAxios.get("/projekcije/" + id)
      .then((res) => {
        // handle success
        console.log(res);
        this.setState({
          projekcija: res.data,
        });
      })
      .catch((error) => {
        // handle error
        console.log(error);
        alert("Error occured please try again!");
      });
  }

  getSedista(salaId) {
    FrontAxios.get("/sale/" + salaId)
      .then((res) => {
        // handle success
        console.log(res);
        this.setState({
          sedista: res.data,
        });
      })
      .catch((error) => {
        // handle error
        console.log(error);
        alert("Error occured please try again!");
      });
  }

  async getSedista(salaId) {
    try {
      let result = await FrontAxios.get("/sale/" + salaId);
      let sedista = result.data;
      this.setState({ sedista: sedista });
      console.log("test1");
    } catch (error) {
      console.log(error);
      alert("Couldn't fetch seats");
    }
  }

  rezervacija() {
    var params = {
      projekcijaId: this.state.projekcijaId,
      sedisteId: this.state.sedisteId,
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

    this.setState((state, props) => ({
      sedisteId: value,
    }));
  };

  klubSelectionChanged(e) {
    // console.log(e);

    let klubId = e.target.value;
    this.setState((klubId = klubId));
  }

  render() {
    return (
      <>
        <Row>
          <Col></Col>
          <Col xs="12" sm="10" md="8">
            <h3>
              Izvrsi rezervaciju za
              <small class="text-muted">
                {this.state.projekcija.film.naziv} za datum{" "}
                {this.state.projekcija.datumIVreme}
              </small>
            </h3>
            {/* <h1>
              Izvrsi rezervaciju za {this.state.projekcija.film.naziv} za datum{this.state.projekcija.datumIVreme}
              {this.state.projekcijaDatum}
            </h1> */}
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
                  {this.state.sedista.map((sediste) => {
                    return (
                      <option key={sediste.sedisteId} value={sediste.sedisteId}>
                        {sediste.sedisteId}
                      </option>
                    );
                  })}
                </Form.Control>
                <br />
              </Form.Group>

              <Button
                onClick={(event) => {
                  this.transfer(event);
                }}
              >
                Add
              </Button>
            </Form>
          </Col>
          <Col></Col>
        </Row>
      </>
    );
  }
}

export default Reservation;
