import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import "./Restaurant.scss"; 
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Comment from "../Comment/Comment";
import CommentForm from "../Comment/CommentForm";
import CommentUpdateForm from "../Comment/CommentUpdateForm";
import Alert from "react-bootstrap/Alert";
import Card from "react-bootstrap/Card";

function RestaurantDetail(props) {
  const {restaurantId} = props;
  // const {restaurantId, name, longitude, latitude, averageScore} = props;
  // const {restaurantId} = props.restaurantId;
  // const {restaurantId} = useParams() 
  const [name, setName] = useState("");
  const [longitude, setLongitude] = useState("");
  const [latitude, setLatitude] = useState("");
  const [averageScore, setAverageScore] = useState("");

  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [commentList, setCommentList] = useState([]);
  const [isSent, setIsSent] = useState(false);
  const [commentsVisible, setCommentsVisible] = useState(false);
  

  useEffect(() => {
    fetch("http://localhost:8089/api/v1/restaurants/" + restaurantId, {
      method: "GET",
    })
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setName(result.name);
          setLongitude(result.longitude);
          setLatitude(result.latitude);
          setAverageScore(result.averageScore);
          console.log(result)
        },
        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      )
      .catch((err) => console.log(err));
  }, []);

  const deleteRestaurant = () => {
    fetch("http://localhost:8089/api/v1/restaurants/" + restaurantId, {
      method: "DELETE",
    })
      .then((res) => res.json)
      .catch((err) => console.log(err));
  };

  const handleClose = () => {
    setIsSent(false);
  };
  const handleCommentsToggle = () => {
    setCommentsVisible(!commentsVisible);
  };

  return (
    <div className="restaurant">
      <Alert variant="success" show={isSent} onClose={handleClose} dismissible>
        <Alert.Heading>Restaurant successfully registered!</Alert.Heading>
      </Alert>

      <Container>
        {/* <Card className="bg-dark text-white">
      <Card.Img src="https://images.pexels.com/photos/1126359/pexels-photo-1126359.jpeg?auto=compress&cs=tinysrgb&w=300" alt="Card image" />
      <Card.ImgOverlay>
        <Card.Title>Card title</Card.Title>
        <Card.Text>
          This is a wider card with supporting text below as a natural lead-in
          to additional content. This content is a little bit longer.
        </Card.Text>
        <Card.Text>Last updated 3 mins ago</Card.Text>
      </Card.ImgOverlay>
    </Card> */}

        <Row>
          <Col sm={6}>
            <Card.Img
              src="https://images.pexels.com/photos/1126359/pexels-photo-1126359.jpeg?auto=compress&cs=tinysrgb&w=300"
              alt="Card image"
            />
          </Col>

          <Col sm={6}>
            <Col sm={2}>{name}</Col>
            <Col sm={2}>Longitude: {longitude}</Col>
            <Col sm={2}>Latitude: {latitude}</Col>
            <Col sm={2}>Average Score: {averageScore}</Col>
            <Col sm={2}>
              <Button variant="outline-primary">Güncelle</Button>
            </Col>
            <Col sm={1}>
              <Button variant="outline-secondary" onClick={deleteRestaurant}>
                Sil
              </Button>
            </Col>
          </Col>
        </Row>
        <Row>
          <Button variant="outline-secondary" onClick={handleCommentsToggle}>
            {commentsVisible ? "Yorumları Gizle" : "Yorumları Göster"}
          </Button>
          {error ? (
            <div>Error: {error.message}</div>
          ) : commentsVisible && isLoaded ? (
            <>
              {commentList.map((comment) => (
                <div key={comment.id}>
                  <Comment
                    restaurantId={comment.restaurantId}
                    customerName={comment.customerName}
                    commentId={comment.id}
                    text={comment.text}
                    score={comment.score}
                  />
                </div>
              ))}
              <CommentForm restaurantId={restaurantId}></CommentForm>
            </>
          ) : (
            <div></div>
          )}
        </Row>
      </Container>
    </div>
  );
}

export default RestaurantDetail;
