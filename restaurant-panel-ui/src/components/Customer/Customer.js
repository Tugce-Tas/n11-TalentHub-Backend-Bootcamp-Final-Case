import React, { useState } from "react";
import "./Customer.scss";
import Card from "react-bootstrap/Card";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Alert from "react-bootstrap/Alert";
import { Link } from "react-router-dom";
import CustomerUpdateForm from "./CustomerUpdateForm";

function Customer(props) {
  const { fullName, longitude, latitude, customerId } = props;
  const [updateFormVisible, setUpdateFormVisible] = useState(false);
  const [isSent, setIsSent] = useState(false);

  const deleteCustomer = () => {
    fetch("http://localhost:8080/api/v1/customers/" + customerId, {
      method: "DELETE",
    })
      .then((res) => res.json)
      .catch((err) => console.log(err));
  };
  const handleClose = () => {
    setIsSent(false);
  };

  const handleUpdateFormToggle = () => {
    setUpdateFormVisible(!updateFormVisible);
  };

  return (
    <div className="customer">
      <Alert variant="success" show={isSent} onClose={handleClose} dismissible>
        <Alert.Heading>Restaurant successfully registered!</Alert.Heading>
      </Alert>
      <Row>
        <Col sm={6}>
          <Card>
            <Card.Body>{fullName}</Card.Body>
          </Card>
        </Col>

        <Col sm={2}>
          <Card>
            <Card.Body>{longitude}</Card.Body>
          </Card>
        </Col>

        <Col sm={2}>
          <Card>
            <Card.Body>{latitude}</Card.Body>
          </Card>
        </Col>

        <Col sm={1}>
          <Card>
            <Card.Body onClick={handleUpdateFormToggle}>
              <i class="fa-regular fa-pen-to-square"></i>
            </Card.Body>
          </Card>
        </Col>

        <Col sm={1}>
          <Card>
            <Link>
              <Card.Body onClick={deleteCustomer}>
                <i class="fa-regular fa-trash-can button"></i>
              </Card.Body>
            </Link>
          </Card>
        </Col>

        <Col sm={12} style={{ marginTop: "30px" }}>
          {updateFormVisible && <CustomerUpdateForm customerId={customerId} />}
        </Col>
      </Row>
    </div>
  );
}

export default Customer;
