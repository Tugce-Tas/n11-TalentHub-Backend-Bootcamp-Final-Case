import React, { useState, useEffect } from "react";
import "./Customer.scss";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import FloatingLabel from "react-bootstrap/FloatingLabel";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import Alert from "react-bootstrap/Alert";

function CustomerUpdateForm(props) {
  const {customerId} = props;
  const [newName, setName] = useState("");
  const [newSurname, setSurname] = useState("");
  const [newLongitude, setLongitude] = useState("");
  const [newLatitude, setLatitude] = useState("");
  const [isSent, setIsSent] = useState(false);

  const updateCustomer = () => {
    fetch(`http://localhost:8080/api/v1/customers/` + customerId, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: newName,
        surname: newSurname,
        longitude: newLongitude,
        latitude: newLatitude,
      }),
    })
      .then((res) => res.json())
      .catch((err) => console.log(err));
  };

  const handleUpdate = () => {
    updateCustomer();
    setIsSent(true);
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
    <div className="restauran-update">
      <>
        <Alert
          variant="success"
          show={isSent}
          onClose={handleClose}
          dismissible
        >
          <Alert.Heading>Customer successfully updated!</Alert.Heading>
        </Alert>

            <Row style={{backgroundColor:"CaptionText", padding:"10px"}}>
          <Col sm={4}>
            <FloatingLabel
              controlId="name"
              label="Name"
              onChange={(i) => handleName(i.target.value)}
            >
              <Form.Control placeholder="name..." />
            </FloatingLabel>
          </Col>

          <Col sm={3}>
            <FloatingLabel
              controlId="surname"
              label="Surname"
              onChange={(i) => handleSurname(i.target.value)}
            >
              <Form.Control placeholder="surname..." />
            </FloatingLabel>
          </Col>

          <Col sm={2}>
            <FloatingLabel
              controlId="latitude"
              label="Latitude"
              onChange={(i) => handleLatitude(i.target.value)}
            >
              <Form.Control placeholder="latitude..." />
            </FloatingLabel>
          </Col>

          <Col sm={2}>
            <FloatingLabel
              controlId="longitude"
              label="Longitude"
              onChange={(i) => handleLongitude(i.target.value)}
            >
              <Form.Control placeholder="longitude..." />
            </FloatingLabel>
          </Col>

          <Col sm={1}>
            <Button style={{height:"55px", width:"100%"}} variant="primary" onClick={handleUpdate} >
            <i class="fa-solid fa-check" ></i>
            </Button>
          </Col>
        </Row>
      </>
    </div>
  );
}

export default CustomerUpdateForm;
