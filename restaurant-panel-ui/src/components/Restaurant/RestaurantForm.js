import React, { useState } from "react";
import "./Restaurant.scss";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import Alert from "react-bootstrap/Alert";

import InputGroup from "react-bootstrap/InputGroup";

function RestaurantForm(props) {
  const [name, setName] = useState("");
  const [longitude, setLongitude] = useState("");
  const [latitude, setLatitude] = useState("");
  const [isSent, setIsSent] = useState(false);

  const saveRestaurant = () => {
    fetch("http://localhost:8089/api/v1/restaurants", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: name,
        longitude: longitude,
        latitude: latitude,
      }),
    })
      .then((res) => res.json)
      .catch((err) => console.log(err));
  };

  const handleSubmit = () => {
    saveRestaurant();
    setIsSent(true);
    setName("");
    setLongitude("");
    setLatitude("");
  };

  const handleName = (value) => {
    setName(value);
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
    <div className="restaurant-form">
      <>

        <Alert variant="success" show={isSent} onClose={handleClose} dismissible>
        <Alert.Heading>Restaurant successfully saved!</Alert.Heading>
        <p>
        </p>
      </Alert>


        <InputGroup className="mb-3">
          <InputGroup.Text id="basic-addon1">Name</InputGroup.Text>
          <Form.Control
            placeholder="name..."
            aria-label="name"
            onChange={(i) => handleName(i.target.value)}
            value={name}
          />
        </InputGroup>
        <InputGroup className="mb-3">
          <InputGroup.Text id="basic-addon1">Longitude</InputGroup.Text>
          <Form.Control
            placeholder="longitude..."
            aria-label="longitude"
            onChange={(i) => handleLongitude(i.target.value)}
            value={longitude}
          />
        </InputGroup>
        <InputGroup className="mb-3">
          <InputGroup.Text id="basic-addon1">Latitude</InputGroup.Text>
          <Form.Control
            placeholder="latitude..."
            aria-label="latitude"
            onChange={(i) => handleLatitude(i.target.value)}
            value={latitude}
          />
        </InputGroup>

        <Row className="g-2">
          <Col sm={2}>
            <Button variant="primary" onClick={handleSubmit}>
              Kaydet
            </Button>
          </Col>
        </Row>
      </>
    </div>
  );
}

export default RestaurantForm;
