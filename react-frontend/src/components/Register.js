import { useState } from "react";
import axios from "axios";
import { useHistory } from "react-router-dom";
import { Button, Form, FormGroup, Label, Input } from "reactstrap";
import "../styles/Register.css";

const Register = () => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const [errorMessage, setErrorMessage] = useState("");
  const history = useHistory();

  const register = (username, password, email) => {
    axios
      .post("http://localhost:8080/users/register", {
        username,
        email,
        password,
      })
      .then((response) => {
        if (response.status === 201) {
          console.log(response.data);
          history.push("/");
          alert(response.data);

          // TO DO:
          // implement authentication -- loggedIn state/accessToken
          // auto redirect to home page via authentication setup
        }
      })
      .catch((error) => {
        if (error.response.status === 409) {
          console.log(error.response);
          alert(error.response.data);
        } else {
          alert("Something went wrong");
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

  const handleConfirmPasswordChange = (e) => {
    e.preventDefault();

    setConfirmPassword(e.target.value);
  };

  const handleEmailChange = (e) => {
    e.preventDefault();

    setEmail(e.target.value);
  };
  const handleSubmit = (e) => {
    e.preventDefault();

    if (!password || !email || !username) {
      setErrorMessage("Please fill in all the required fields.");
      return;
    }
    if (password === confirmPassword) {
      if (password.length < 6) {
        setErrorMessage("Password must be at least 6 characters long");
      }
      setErrorMessage("");
      register(username, password, email);
    } else {
      setErrorMessage("Passwords do not match.");
    }
  };

  return (
    <div>
      <div className="spacer-register">
        <div className="register-container">
          <Form className="register-form">
            <FormGroup>
              <h2 className="title register">Register</h2>
              <Input
                onChange={handleEmailChange}
                className="register-input"
                placeholder="Email"
                type="email"
                required
              />
              <Input
                onChange={handleUsernameChange}
                className="register-input"
                placeholder="Username"
                type="username"
                required
              />
              <Input
                onChange={handlePasswordChange}
                className="register-input"
                placeholder="Password"
                type="new-password"
                required
              />
              <Input
                onChange={handleConfirmPasswordChange}
                className="register-input"
                placeholder="Confirm Password"
                type="new-password"
                required
              />
            </FormGroup>
            <Button className="register-button" type="submit" value="Sign In">
              Register
            </Button>
          </Form>
        </div>
      </div>
    </div>
  );
};

export default Register;
