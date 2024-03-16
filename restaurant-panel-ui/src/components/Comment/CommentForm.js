import React, { useState, useEffect } from "react";
import "./Comment.scss";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import Alert from "react-bootstrap/Alert";

import InputGroup from "react-bootstrap/InputGroup";

function CommentForm(props) {
  const {restaurantId} = props;
  const [score, setScore] = useState("");
  const [text, setText] = useState("");
  const [customerId, setCustomerId] = useState("");
  const [isSent, setIsSent] = useState(false);

  const saveComment = () => {
    fetch("http://localhost:8080/api/v1/comments", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        text: text,
        score: score,
        customerId: customerId,
        restaurantId: restaurantId,
      }), 
    })
      .then((res) => res.json)
      .catch((err) => console.log(err));
  };


  const handleSubmit = () => {
    saveComment();
    setIsSent(true);
    setScore("");
    setText("");
    setCustomerId("");
  };

  const handleScore = (value) => {
    setScore(value);
    setIsSent(false);
  };
  const handleText = (value) => {
    setText(value);
    setIsSent(false);
  };
  const handleCustomerId = (value) => {
    setCustomerId(value);
    setIsSent(false);
  };
  

  const handleClose = () => {
    setIsSent(false);
  };

  return (
    <div className="comment-form">
      <>
        <Alert
          variant="success"
          show={isSent}
          onClose={handleClose}
          dismissible
        >
          <Alert.Heading>Comment successfully registered!</Alert.Heading>
        </Alert>

        <InputGroup className="mb-3">
          <InputGroup.Text id="basic-addon1">Text</InputGroup.Text>
          <Form.Control
            placeholder="text..."
            aria-label="text"
            onChange={(i) => handleText(i.target.value)}
            value={text}
          />
        </InputGroup>
        <InputGroup className="mb-3">
          <InputGroup.Text id="basic-addon1">Score</InputGroup.Text>
          <Form.Select
          aria-label="score"
          onChange={(i) => handleScore(i.target.value)}
          value={score}>
            <option>select...</option>
            <option value="1">ONE</option>
            <option value="2">TWO</option>
            <option value="3">THREE</option>
            <option value="4">FOUR</option>
            <option value="5">FIVE</option>
          </Form.Select>
        </InputGroup>
        <InputGroup className="mb-3">
          <InputGroup.Text id="basic-addon1">CustomerId</InputGroup.Text>
          <Form.Control
            placeholder="customerId..."
            aria-label="customerId"
            onChange={(i) => handleCustomerId(i.target.value)}
            value={customerId}
          />
        </InputGroup>

        <Row className="g-2">
          <Col sm={2}>
            <Button variant="primary" onClick={handleSubmit}>
              Kaydet
            </Button>
          </Col>
        </Row>
      </>
    </div>
  );
}

export default CommentForm;
