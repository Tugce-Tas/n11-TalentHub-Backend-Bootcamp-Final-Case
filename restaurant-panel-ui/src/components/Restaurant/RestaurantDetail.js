import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "./Restaurant.scss";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Comment from "../Comment/Comment";
import CommentForm from "../Comment/CommentForm";
import Alert from "react-bootstrap/Alert";
import Card from "react-bootstrap/Card";
import RestaurantUpdateForm from "./RestaurantUpdateForm";

function RestaurantDetail(props) {
  const { restaurantId } = props;
  // const {restaurantId, name, longitude, latitude, averageScore} = props;
  // const {restaurantId} = props.restaurantId;
  // const {restaurantId} = useParams()
  const [name, setName] = useState("");
  const [longitude, setLongitude] = useState("");
  const [latitude, setLatitude] = useState("");
  const [averageScore, setAverageScore] = useState("");
  const [commentList, setCommentList] = useState([]);
  const [updateFormVisible, setUpdateFormVisible] = useState(false);

  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [isSent, setIsSent] = useState(false);
  const [commentsVisible, setCommentsVisible] = useState(true);

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
          setCommentList(result.commentList);
          console.log(result);
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

  const handleUpdateFormToggle = () => {
    setUpdateFormVisible(!updateFormVisible);
  };


console.log(commentList);

  return (
    <div className="restaurant">
      <Alert variant="success" show={isSent} onClose={handleClose} dismissible>
        <Alert.Heading>Restaurant successfully registered!</Alert.Heading>
      </Alert>

      <Container>
        <Row>
          <Col sm={6}>
            <Card.Img
              src="https://images.pexels.com/photos/1126359/pexels-photo-1126359.jpeg?auto=compress&cs=tinysrgb&w=300"
              alt="Card image"
            />
          </Col>

          <Col sm={6} style={{ backgroundColor: "white" }}>
            <h1>{name}</h1>

            <h5>Longitude: {longitude}</h5>
            <h5>Latitude: {latitude}</h5>
            <h5>Average Score: {averageScore}</h5>

            <Button
              className="restaurant-form-button"
              variant="outline-primary"
              onClick={handleUpdateFormToggle}
            >
              <i class="fa-regular fa-pen-to-square detail-button "></i>
              <span style={{ fontSize: "16pt" }}>Update</span>
            </Button>

            <Button
              className="restaurant-form-button"
              variant="outline-danger"
              onClick={deleteRestaurant}
            >
              <i class="fa-regular fa-trash-can button detail-button"></i>{" "}
              <span style={{ fontSize: "16pt" }}>Delete</span>
            </Button>
          </Col>

          <Col sm={12} style={{ marginTop: "30px" }}>
            {updateFormVisible && (
              <RestaurantUpdateForm
                restaurantId={restaurantId}
                name={name}
                latitude={latitude}
                longitude={longitude}
              />
            )}
          </Col>
        </Row>
        <hr></hr>
        <Row>
          <div className="restaurant-comment-title">
            <h6>
              <Link variant="outline-secondary" onClick={handleCommentsToggle}>
                {commentsVisible ? "Hide Comments" : "Show Comments"}
              </Link>
            </h6>
          </div>
          {error ? (
            <div>Error: {error.message}</div>
          ) : commentsVisible && isLoaded ? (
            commentList !== null ? (
              <>
                {commentList.map((unparsedComment) => (
                  <div key={unparsedComment.id}>
                    <Comment unparsedComment={unparsedComment} />
                  </div>
                ))}
                <CommentForm restaurantId={restaurantId}></CommentForm>
              </>
            ) : (
              <>
                <div style={{ margin: "30px 0px" }}>
                  No comments yet. Be the first to comment...
                </div>
                <br></br>
                <CommentForm restaurantId={restaurantId}></CommentForm>
              </>
            )
          ) : (
            <div></div>
          )}
        </Row>
      </Container>
    </div>
  );
}
export default RestaurantDetail;
