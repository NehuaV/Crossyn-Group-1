import {useState} from "react";

import {Button, Form, FormGroup, Input} from "reactstrap";
import "../styles/Login.css";

const Login = ({login}) => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loginErrorMessage, setLoginErrorMessage] = useState("");


    const handleUsernameChange = (e) => {
        e.preventDefault();

        setUsername(e.target.value);
    };
    const handlePasswordChange = (e) => {
        e.preventDefault();

        setPassword(e.target.value);
    };

    const handleFormSubmit = (e) => {
        e.preventDefault();

        if (!username || !password) {
            setLoginErrorMessage("Please fill in all the required fields.");
            return;
        } else {
            setLoginErrorMessage("");
        }
        login(username, password);
    };

    return (
        <div>
            <p className="error-msg">{loginErrorMessage}</p>
            <div className="spacer-login">
                <div className="login-container">
                    <Form onSubmit={handleFormSubmit} className="login-form">
                        <FormGroup>
                            <h2 className="title login">Login</h2>
                            <Input
                                className="login-input"
                                onChange={handleUsernameChange}
                                placeholder="Username"
                                value={username}
                                type="username"
                                required
                            />
                            <Input
                                className="login-input"
                                onChange={handlePasswordChange}
                                placeholder="Password"
                                value={password}
                                type="password"
                                required
                            />
                        </FormGroup>
                        <Button className="login-button" type="submit" value="Sign In">
                            Login
                        </Button>
                        <div className="extra-links">
                            <a className="link" href="/register">Signup Now!</a>
                            <a> | </a>
                            <a className="link" href="/">Forgotten Password?</a>
                        </div>
                    </Form>
                </div>
            </div>
        </div>
    );
};

export default Login;
