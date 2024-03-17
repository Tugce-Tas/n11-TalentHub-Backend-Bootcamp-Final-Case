import React, { useState } from "react";
import "./Comment.scss";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import Alert from "react-bootstrap/Alert";
import FloatingLabel from "react-bootstrap/FloatingLabel";
import InputGroup from "react-bootstrap/InputGroup";

function CommentForm(props) {
  const { restaurantId } = props;
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
    console.log(text,score,customerId, restaurantId)
    
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

        <Row>
          <Col sm={8}>
            <FloatingLabel controlId="floatingTextarea2" label="Comments">
              <Form.Control
                as="input"
                placeholder="Leave a comment here"
                style={{ height: "110px" }}
                onChange={(i) => handleText(i.target.value)}
              />
            </FloatingLabel>
          </Col>

          <Col sm={4}>
            <Col sm={12}>
              <FloatingLabel controlId="floatingTextarea2" label="CustomerId">
                <Form.Control
                  as="input"
                  style={{ height: "15px", marginBottom: "12px" }}
                  onChange={(i) => handleCustomerId(i.target.value)}
                />
              </FloatingLabel>
            </Col>
            <Col sm={12}>
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
          </Col>
        </Row>

        <Row className="g-2">
          <Col sm={2} className="comment-save-button">
            <Button
              className="comment-save-button"
              variant="primary"
              onClick={handleSubmit}
            >
              Save
            </Button>
          </Col>
        </Row>
      </>
    </div>
  );
}

export default CommentForm;
