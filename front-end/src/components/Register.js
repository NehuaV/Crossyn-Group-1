import { useState } from "react";

import { Button, Form, FormGroup, Label, Input } from "reactstrap";
import "../styles/Register.css";
import { ToggleButtonGroup, ToggleButton } from "react-bootstrap";

const Register = ({ register }) => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const [errorMessage, setErrorMessage] = useState("");

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
        return;
      }
      setErrorMessage("");
      
      register(username, password, email, role);
    } else {
      setErrorMessage("Passwords do not match.");
    }
  };

  const [role, setRole] = useState(1);
  const handleChange = (val) => setRole(val);

  return (
    <div>
      <div className="spacer-register">
        <div className="register-container">
          <Form className="register-form" onSubmit={handleSubmit}>
            <p>{errorMessage}</p>
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
                type="password"
                required
              />
              <Input
                onChange={handleConfirmPasswordChange}
                className="register-input"
                placeholder="Confirm Password"
                type="password"
                required
              />
            </FormGroup>

            <ToggleButtonGroup className="selector" type="radio" name="options" value={role} onChange={handleChange} defaultValue={2}>
              <ToggleButton id="tbg-radio-1" value={1}>
                Fleet Owner
              </ToggleButton>
              <ToggleButton id="tbg-radio-2" value={2}>
                Driver
              </ToggleButton>
            </ToggleButtonGroup>

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
