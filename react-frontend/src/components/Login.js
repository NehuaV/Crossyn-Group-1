import { useState } from "react";
import { useHistory } from "react-router-dom";
import axios from "axios";
import { Button, Form, FormGroup, Label, Input } from "reactstrap";
import "../styles/Login.css";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loginErrorMessage, setLoginErrorMessage] = useState("");

  const history = useHistory();

  const login = (username, password) => {
    axios
      .post("http://localhost:8080/users/login", { username, password })
      .then((res) => {
        if (res.data.error) {
          console.log(res.data);
          alert("Invalid credentials");
        } else {
          console.log(res.data);
          history.push("/");

          // TO DO:
          // implement authentication -- loggedIn state/accessToken
          // auto redirect to home page via authentication setup
        }
      });
  };

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
