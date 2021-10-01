import '../styles/Navbar.css'
import logo from "../images/companyLogo.png";

import {Navbar, Nav} from 'react-bootstrap'

const HeaderCom = () => {
    return (
        <div className="Navbar">
            <Navbar bg="dark" expand="lg" sticky="top">
                <Navbar.Brand href="/"> <img src={logo} alt="Logo" style={{width: 75, marginTop: -7}}/>
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto" >
                        <Nav.Link href="/" >Home</Nav.Link>
                        <Nav.Link href="/login">Login</Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        </div>
    );
}
export default HeaderCom;