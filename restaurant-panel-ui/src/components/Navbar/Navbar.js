import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import {Link} from "react-router-dom";
import Navbar from 'react-bootstrap/Navbar';

function NavbarContent() {
  return (
    <>
      <Navbar bg="light" data-bs-theme="light">
        <Container>
          <Navbar.Brand href="#home">n11 FinalCase </Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/">Home</Nav.Link>
            <Nav.Link as={Link} to={{pathname : "/customers" }}>Customers</Nav.Link>
            <Nav.Link as={Link} to={{pathname : "/comments" }}>Comments</Nav.Link>
            <Nav.Link as={Link} to={{pathname : "/restaurants" }}>Restaurants</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
}

export default NavbarContent;
