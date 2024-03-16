import React from "react";
import "./Customer.scss";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { Link } from "react-router-dom";

function Customer(props) {
  const { fullName, longitude, latitude } = props;

  return (
    <div className="customer">
      <Row>
        <Col sm={4}>
          <Card>
            <Card.Body>Müşteri Adı:{fullName}</Card.Body>
          </Card>
        </Col>

        <Col sm={3}>
          <Card>
            <Card.Body>Longitude:{longitude}</Card.Body>
          </Card>
        </Col>

        <Col sm={3}>
          <Card>
            <Card.Body>Latitude:{latitude}</Card.Body>
          </Card>
        </Col>

        <Col sm={1}>
          <Card>
            <Card.Body>
              <i class="fa-regular fa-pen-to-square"></i>
            </Card.Body>
          </Card>
        </Col>

        <Col sm={1}>
          <Card>
            <Link>
              <Card.Body>
                <i class="fa-regular fa-trash-can button"></i>
              </Card.Body>
            </Link>
          </Card>
        </Col>
      </Row>
    </div>
  );
}

export default Customer;
