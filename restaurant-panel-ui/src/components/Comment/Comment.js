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
  const { score, text, customerName, restaurantId, commentId } = props;
  const [isSent, setIsSent] = useState(false);
  const [updateFormVisible, setUpdateFormVisible] = useState(false);

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

      <Card>
        <Card.Body>
          <Container>
            <Row>
              <Col sm={2}>{score}</Col>
              <Col sm={3}>{text}</Col>
              <Col sm={3}>Customer:{customerName}</Col>

              <Col sm={2}>
                <Button
                  variant="outline-primary"
                  onClick={handleUpdateFormToggle}
                >
                  Güncelle
                </Button>
              </Col>
              <Col sm={2}>
                <Button variant="outline-secondary" onClick={handleDelete}>
                  Sil
                </Button>
              </Col>
            </Row>
            <Row>
                {updateFormVisible && (
                    <CommentUpdateForm commentId={commentId} text={text} score={score} />
                )}
            </Row>
          </Container>
        </Card.Body>
      </Card>
    </div>
  );
}

export default Comment;
