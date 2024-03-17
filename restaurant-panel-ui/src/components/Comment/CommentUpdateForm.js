import React, { useState, useEffect } from "react";
import "./Comment.scss";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import FloatingLabel from "react-bootstrap/FloatingLabel";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import Alert from "react-bootstrap/Alert";

import InputGroup from "react-bootstrap/InputGroup";

function CommentUpdateForm(props) {
  const { commentId, score, text } = props;
  const [newScore, setScore] = useState("");
  const [newText, setText] = useState("");
  const [isSent, setIsSent] = useState(false);

  const updateComment = () => {
    fetch(`http://localhost:8080/api/v1/comments/` + commentId, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        text: newText,
        score: newScore,
      }),
    })
      .then((res) => res.json())
      .catch((err) => console.log(err));
  };

  const handleUpdate = () => {
    updateComment();
    setIsSent(true);
  };

  const handleScore = (value) => {
    setScore(value);
    setIsSent(false);
  };
  const handleText = (value) => {
    setText(value);
    setIsSent(false);
  };

  const handleClose = () => {
    setIsSent(false);
  };

  return (
    <div className="comment-update">
      <>
        <Alert
          variant="success"
          show={isSent}
          onClose={handleClose}
          dismissible
        >
          <Alert.Heading>Comment successfully updated!</Alert.Heading>
        </Alert>

        <Row>
          <Col sm={9}>
            <FloatingLabel controlId="floatingTextarea2" label="Comments">
              <Form.Control
                as="input"
                placeholder="Leave a comment here"
                style={{ height: "100px" }}
                onChange={(i) => handleText(i.target.value)}
              />
            </FloatingLabel>
          </Col>
          <Col sm={3}>
            <InputGroup className="mb-3">
              <InputGroup.Text id="basic-addon1">Score</InputGroup.Text>
              <Form.Select
                aria-label="score"
                onChange={(i) => handleScore(i.target.value)}
              >
                <option>Select score...</option>
                <option value="ONE">ONE</option>
                <option value="TWO">TWO</option>
                <option value="THREE">THREE</option>
                <option value="FOUR">FOUR</option>
                <option value="FIVE">FIVE</option>
              </Form.Select>
            </InputGroup>
          </Col>

          <Col sm={2}>
            <Button variant="primary" onClick={handleUpdate}>
              Güncelle
            </Button>
          </Col>
        </Row>
      </>
    </div>
  );
}

export default CommentUpdateForm;
