import '../styles/Header.css'
import logo from "../images/companyLogo.png";

import {Navbar, Nav, NavLink} from 'react-bootstrap'
import {Link} from "react-router-dom";

const HeaderCom = ({logout}) => {
    return (
        <div className="Navbar">
            <Navbar className="color-nav" expand="lg" sticky="top">
                <Navbar.Brand href="/"> <img src={logo} className="img-logo" alt="Logo"/>
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                        {localStorage.getItem('accessToken') ?
                            <>
                                <Nav.Link href='/'>Home</Nav.Link>
                                <Nav.Link href='/trips' /*onClick={getTrips}*/ >Trips</Nav.Link>
                                <Nav.Link href='/' onClick={logout}> Logout</Nav.Link>
                            </>
                            :
                            <>
                                <Nav.Link href='/login'>Login</Nav.Link>
                                <Nav.Link href='/register'>Register</Nav.Link>
                            </>
                        }
                        {/*<Nav.Link hreft='/login' onClick={logout}>Logout</Nav.Link>*/}



                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        </div>
    );
}
export default HeaderCom;