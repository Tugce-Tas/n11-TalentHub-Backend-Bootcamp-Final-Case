import React from "react";
import InputGroup from "react-bootstrap/InputGroup";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import "./suggest.scss"


function SuggestRestaurants() {

  return (
    <div className="suggest" >
      <InputGroup className="mb-3">
          <InputGroup.Text id="basic-addon1">Customer Id</InputGroup.Text>
          <Form.Control
            placeholder="CustomerId..."
            aria-label="CustomerId"
          />
        </InputGroup>
        <Button variant="primary" >
              Suggest
        </Button>
    </div>
  );
}

export default SuggestRestaurants;
