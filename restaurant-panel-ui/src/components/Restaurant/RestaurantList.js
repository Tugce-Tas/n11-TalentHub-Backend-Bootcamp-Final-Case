import React, { useState, useEffect } from "react";
import "./Restaurant.scss";
import Restaurant from "./Restaurant";
import RestaurantForm from "./RestaurantForm";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import RestaurantDetail from "./RestaurantDetail";

function ResturantList() {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [restaurantList, setRestaurantList] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8089/api/v1/restaurants")
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
      );
  }, []);

  if (error) {
    return <div>Error!!!</div>;
  } else if (!isLoaded) {
    return <div>Loading...</div>;
  } else {
    console.log(restaurantList);

    return (
      <div className="container">
        <Row>
          <Col xs={12} md={3}>
            <RestaurantForm />
          </Col>
          {restaurantList.map((restaurant) => (
            <Col xs={12} md={3} key={restaurant.id}>
              <Restaurant 
              restaurantId = {restaurant.id}
              name = {restaurant.name}
              longitude = {restaurant.longitude}
              latitude = {restaurant.latitude}
              averageScore = {restaurant.averageScore}
              commentList = {restaurant.commentList}
            />
            </Col>
          ))}
        </Row>
      </div>
    );
  }
}

export default ResturantList;
