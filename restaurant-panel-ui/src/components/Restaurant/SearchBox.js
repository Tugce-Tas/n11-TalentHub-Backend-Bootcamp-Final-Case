import React, { useState,  } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import "./Restaurant.scss";

import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

function SearchBox({onDataChange}) {
  const [custom, setCustom] = useState(null);
  const [restaurantList, setRestaurantList] = useState([]);
  const [isLoaded, setIsLoaded] = useState([]);  
  const [error, setError] = useState([]);

  const filterRestaurants = () => {
    fetch(`http://localhost:8089/api/v1/restaurants/containing/` + custom, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setRestaurantList(result);
        },
        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      )
      .catch((err) => console.log(err));
  };

  const handleCustom = (value) => {
    setCustom(value);
  };

  const sendListToParent = () => {
    onDataChange(restaurantList);
    
    console.log("burası" + restaurantList +"sd");
  };

  const handleFilter = () => {
    filterRestaurants();
    sendListToParent();
  };

  return (
    <div className="suggest">
      <Row>
        <Col sm={11}>
          <Form.Control
            style={{ padding: "10px ", margin: "10px" }}
            onChange={(i) => handleCustom(i.target.value)}
          />
        </Col>

        <Col sm={1}>
          <Button
            style={{ margin: "10px 0px" }}
            variant="primary"
            size="lg"
            onClick={handleFilter}
          >
            <i class="fa-solid fa-magnifying-glass"></i>
          </Button>
        </Col>
      </Row>
    </div>
  );
}

export default SearchBox;
