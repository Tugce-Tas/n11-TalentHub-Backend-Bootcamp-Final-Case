import React, { useState, useEffect } from "react";
import "./Restaurant.scss";
import Alert from "react-bootstrap/Alert";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import { Link } from "react-router-dom";

function Restaurant(props) {
  const { name, longitude, latitude, averageScore, restaurantId } = props;
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [commentList, setCommentList] = useState([]);
  const [isSent, setIsSent] = useState(false);
  const [commentsVisible, setCommentsVisible] = useState(true);

  useEffect(() => {
    fetch(
      "http://localhost:8080/api/v1/comments/with-restaurant-id/" + restaurantId
    )
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setCommentList(result.data);
        },
        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      );
  }, []);

  const handleClose = () => {
    setIsSent(false);
  };

  return (
    <div className="restaurant">
      <Alert variant="success" show={isSent} onClose={handleClose} dismissible>
        <Alert.Heading>Restaurant successfully registered!</Alert.Heading>
      </Alert>

      {/* // <Container> */}

      <Card style={{ width: "100%" }}>
        <Card.Img
          variant="top"
          src="https://images.pexels.com/photos/1126359/pexels-photo-1126359.jpeg?auto=compress&cs=tinysrgb&w=300"
        />
        <Card.Body>
          <Card.Title>{name}</Card.Title>
          <Card.Text>
            <p>
              Longitude: {longitude} Latitude: {latitude}
            </p>
            <p>Average Score: {averageScore}</p>
          </Card.Text>
          <Link to={"/restaurants/" + restaurantId}>
            <Button className="btn-grad">Details</Button>
          </Link>
        </Card.Body>
      </Card>
    </div>
  );
}

export default Restaurant;
