import React, { useState, useEffect } from "react";
import "./Customer.scss";
import Customer from "./Customer";
import CustomerForm from "./CustomerForm";
import Container from "react-bootstrap/Container";
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
            {customerList.map((customer) => (
              <div key={customer.id}>
                <Customer
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
