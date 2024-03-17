import React, { useState, useEffect } from "react";
import "./Customer.scss";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import Alert from "react-bootstrap/Alert";
import InputGroup from "react-bootstrap/InputGroup";

function CustomerForm(props) {
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [longitude, setLongitude] = useState("");
  const [latitude, setLatitude] = useState("");
  const [isSent, setIsSent] = useState(false);

  const saveCustomer = () => {
    fetch("http://localhost:8080/api/v1/customers", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: name,
        surname: surname,
        longitude: longitude,
        latitude: latitude,
      }),
    })
      .then((res) => res.json)
      .catch((err) => console.log(true));
  };

  const handleSubmit = () => {
    saveCustomer();
    setIsSent(true);
    setName("");
    setLongitude("");
    setLatitude("");
    setSurname("");
  };

  const handleName = (value) => {
    setName(value);
    setIsSent(false);
  };
  const handleSurname = (value) => {
    setSurname(value);
    setIsSent(false);
  };
  const handleLongitude = (value) => {
    setLongitude(value);
    setIsSent(false);
  };
  const handleLatitude = (value) => {
    setLatitude(value);
    setIsSent(false);
  };

  const handleClose = () => {
    setIsSent(false);
  };

  return (
    <div className="customer">
      <>
        <Alert
          variant="success"
          show={isSent}
          onClose={handleClose}
          dismissible
        >
          <Alert.Heading>Customer successfully saved!</Alert.Heading>
        </Alert>

        <InputGroup className="mb-3">
          <InputGroup.Text id="basic-addon1">Name</InputGroup.Text>
          <Form.Control
            placeholder="Name..."
            aria-label="Name"
            onChange={(i) => handleName(i.target.value)}
            value={name}
          />
        </InputGroup>
        <InputGroup className="mb-3">
          <InputGroup.Text id="basic-addon1">Surname</InputGroup.Text>
          <Form.Control
            placeholder="Surname..."
            aria-label="Surname"
            onChange={(i) => handleSurname(i.target.value)}
            value={surname}
          />
        </InputGroup>
        <InputGroup className="mb-3">
          <InputGroup.Text id="basic-addon1">Longitude</InputGroup.Text>
          <Form.Control
            placeholder="Longitude..."
            aria-label="Longitude"
            onChange={(i) => handleLongitude(i.target.value)}
            value={longitude}
          />
        </InputGroup>
        <InputGroup className="mb-3">
          <InputGroup.Text id="basic-addon1">Latitude</InputGroup.Text>
          <Form.Control
            placeholder="Latitude..."
            aria-label="Latitude"
            onChange={(i) => handleLatitude(i.target.value)}
            value={latitude}
          />
        </InputGroup>

        <Row className="g-2">
          <Col sm={2}>
            <Button variant="primary" onClick={handleSubmit}>
              Save
            </Button>
          </Col>
        </Row>
      </>
    </div>
  );
}

export default CustomerForm;
