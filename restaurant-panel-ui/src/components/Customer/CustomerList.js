import React, { useState, useEffect } from "react";
import "./Customer.scss";
import Customer from "./Customer";
import CustomerForm from "./CustomerForm";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

function CustomerList() {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [customerList, setCustomerList] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/v1/customers")
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setCustomerList(result.data);
        },
        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      );
  }, []);

  if (error) {
    return <div>Error!!!</div>;
  } else if (!isLoaded) {
    return <div>Loading...</div>;
  } else {
    console.log(customerList);
    return (
      <div className="container">
        <Row>
          <Col xs={12} md={3}>
            <CustomerForm />
          </Col>

          <Col xs={12} md={9}>
            <Row style={{ fontSize: "16pt", fontWeight:"bold", padding:"20px auto "}}>
              <Col sm={6}>Kullanıcı Adı</Col>

              <Col sm={2}>Longitude</Col>

              <Col sm={2}>Latitude</Col>

              <Col sm={1}>Update</Col>

              <Col sm={1}>Delete</Col>
            </Row>

            {customerList.map((customer) => (
              <div key={customer.id}>
                <Customer
                  customerId={customer.id}
                  fullName={customer.fullName}
                  longitude={customer.longitude}
                  latitude={customer.latitude}
                />
              </div>
            ))}
          </Col>
        </Row>
      </div>
    );
  }
}

export default CustomerList;
