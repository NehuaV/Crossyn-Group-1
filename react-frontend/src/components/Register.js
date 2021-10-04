import {useState} from 'react';
import axios from "axios";
import {useHistory} from "react-router-dom";

import {useState} from 'react'
import {useHistory} from 'react-router-dom'
import axios from "axios";
import { Button, Form, FormGroup, Label, Input } from 'reactstrap'
import '../styles/Register.css';


const Register = () => {
    const [username, setUsername] = useState('')
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [confirmPassword, setConfirmPassword] = useState('')

    const [errorMessage, setErrorMessage] = useState('');
    const history = useHistory();

    const register = (username, password, email) => {
        axios.post('http://localhost:8080/users/register', {username, email, password})
            .then(response => {
                if (response.status === 201) {
                    console.log(response.data)
                    history.push("/");
                    alert(response.data);

                    // TO DO:
                    // implement authentication -- loggedIn state/accessToken
                    // auto redirect to home page via authentication setup
                }
            })
            .catch(error => {
                if (error.response.status === 409) {
                    console.log(error.response);
                    alert(error.response.data);
                } else {
                    alert('Something went wrong');
                }
            })
    }

    const handleUsernameChange = (e) => {
        e.preventDefault();

        setUsername(e.target.value)
    }

    const handlePasswordChange = (e) => {
        e.preventDefault();

        setPassword(e.target.value)
    }

    const handleConfirmPasswordChange = (e) => {
        e.preventDefault();

        setConfirmPassword(e.target.value)
    }

    const handleEmailChange = (e) => {
        e.preventDefault();

        setEmail(e.target.value)
    }
    const handleSubmit = (e) => {
        e.preventDefault();

        if (!password || !email || !username) {
            setErrorMessage('Please fill in all the required fields.')
            return;
        }
        if (password === confirmPassword) {
            if (password.length < 6) {
                setErrorMessage('Password must be at least 6 characters long')
            }
            setErrorMessage('')
            register(username, password, email);
        } else {
            setErrorMessage('Passwords do not match.')
        }
    }

    return (
        <h1 className="text-center">
            Register Page
            <div className="spacer">
                <div className="login-container">
                    <Form className='register-form'>
                        <FormGroup>
                            <Label>Email</Label>
                            <Input onChange={handleEmailChange} className="email-input" placeholder='Email' type='email' />
                            <Label>Username</Label>
                            <Input onChange={handleUsernameChange} className="login-input" placeholder='Username' type='username' />
                            <Label>Password</Label>
                            <Input onChange={handlePasswordChange} className="login-input" placeholder='Password' type='new-password' />
                            <Label>Repeat Password</Label>
                            <Input onChange={handleConfirmPasswordChange} className="login-input" placeholder='Confirm Password' type='new-password' />
                        </FormGroup>
                        <Button type='submit' value='Sign In'>Login</Button>
                        <div className="extra-links">
                            <a href="/register">Signup Now!</a>
                            <a> | </a>
                            <a href="/">Forgotten Password?</a>
                        </div>
                    </Form>
                </div>
            </div>
        </h1>
    )
}

export default Register;