import React, { useState, useEffect } from "react";
import "./Comment.scss";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Alert from "react-bootstrap/Alert";
import CommentUpdateForm from "./CommentUpdateForm";

function Comment(props) {
  const { unparsedComment } = props;
  const [isSent, setIsSent] = useState(false);
  const [score, setScore] = useState("");
  const [text, setText] = useState("");
  const [customerName, setCustomerName] = useState("");
  const [restaurantId, setRestaurantId] = useState("");
  const [commentId, setCommentId] = useState("");
  const [updateFormVisible, setUpdateFormVisible] = useState(false);
  const [customerId, setCustomerId]  = useState("");

  const parseComment = () => {
    let unparsedCommentStr = JSON.stringify(unparsedComment);
    let startIndex = unparsedComment.indexOf("(") + 2;
    let endIndex = unparsedComment.indexOf(")");
    let commentSliced = unparsedCommentStr.slice(startIndex, endIndex +1);
    let commentArray = commentSliced.split(",");
    let stringComment = "{";
    console.log(commentSliced)
    commentArray.forEach((comment) => {
      let commentObjects = comment.split("=");
      let key = commentObjects[0].trim();
      let value = commentObjects[1].trim();
      if (key === "id" || key === "customerId"  ) {
        stringComment += '"' + key + '":' + value + ",";
      } else {
        stringComment += '"' + key + '":' + '"' + value + '"' + ",";
      }
    });

    stringComment += "}";
    stringComment = stringComment.replace(",}", "}");
    return JSON.parse(stringComment);
  };

  let comment = unparsedComment ? parseComment() : null;

  useEffect(() => {
    setScore(comment.score);
    setCommentId(comment.id);
    setCustomerId(comment.customerId);
    setCustomerName(comment.customerName);
    setRestaurantId(comment.restaurantId);
    setText(comment.text);
  }, []);

  const deleteComment = () => {
    fetch("http://localhost:8080/api/v1/comments/" + commentId, {
      method: "DELETE",
    })
      .then((res) => res.json)
      .catch((err) => console.log(err));
  };

  const handleDelete = () => {
    deleteComment();
    setIsSent(true);
  };

  const handleUpdateFormToggle = () => {
    setUpdateFormVisible(!updateFormVisible);
  };

  const handleClose = () => {
    setIsSent(false);
  };

  return (
    <div className="comment">
      <Alert variant="success" show={isSent} onClose={handleClose} dismissible>
        <Alert.Heading>Comment successfully registered!</Alert.Heading>
      </Alert>

      <Card style={{ width: "100%" }}>
        <Card.Body style={{ textAlign: "start" }}>
          <Card.Title style={{ margin: "20px 0" }}>{customerName}</Card.Title>
          <Card.Subtitle className="mb-2 text-muted">{score}</Card.Subtitle>
          <Card.Text>
            {text} 
          </Card.Text>
          <Card.Link href="#">
            <Button variant="outline-primary" onClick={handleUpdateFormToggle}>
              {" "}
              <i class="fa-regular fa-pen-to-square "></i>
              Update
            </Button>
          </Card.Link>
          <Card.Link href="#">
            <Button variant="outline-secondary" onClick={handleDelete}>
              <i class="fa-regular fa-trash-can button"></i> Delete
            </Button>
          </Card.Link>
        </Card.Body>
        <Container>
          <Row>
            <Col sm={11}>
              {updateFormVisible && (
                <CommentUpdateForm
                  commentId={commentId}
                  text={text}
                  score={score}
                />
              )}
            </Col>
          </Row>
        </Container>
      </Card>
    </div>
  );
}

export default Comment;
