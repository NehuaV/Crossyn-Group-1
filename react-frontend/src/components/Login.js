<<<<<<< HEAD

import {useState} from 'react'
import {useHistory} from 'react-router-dom'
import axios from "axios";


import { Button, Form, FormGroup, Label, Input } from 'reactstrap'
import '../styles/Login.css';


=======
import {useState} from 'react'
import {useHistory} from 'react-router-dom'
import axios from "axios";
import { Button, Form, FormGroup, Label, Input } from 'reactstrap'
import '../styles/Login.css';

>>>>>>> Login-function

const Login = () => {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [loginErrorMessage, setLoginErrorMessage] = useState('');

    const history = useHistory();

    const login = (username, password) => {
        axios.post('http://localhost:8080/users/login',
            {username, password}).then(res => {
            if (res.data.error) {
                console.log(res.data);
                alert('Invalid credentials');
            } else {
                console.log(res.data)
                history.push("/");

                // TO DO:
                // implement authentication -- loggedIn state/accessToken
                // auto redirect to home page via authentication setup
            }
        })
    }


    const handleUsernameChange = (e) => {
        e.preventDefault();

        setUsername(e.target.value);
    }
    const handlePasswordChange = (e) => {
        e.preventDefault();

        setPassword(e.target.value);
    }

    const handleFormSubmit = (e) => {
        e.preventDefault();

        if (!username || !password) {
            setLoginErrorMessage('Please fill in all the required fields.')
            return;
        } else {
            setLoginErrorMessage('')
        }
        login(username, password)
    }

    return (
        <div>
            <h1 className="text-center">
                Login Page
            </h1>
            <p className='error-msg'>{loginErrorMessage}</p>
            <div className="spacer">
                <div className="login-container">
<<<<<<< HEAD
                    <Form className='login-form' onSubmit={handleFormSubmit}>
                        <FormGroup>
                            <Label>Username</Label>
                            <Input type='username' onChange={handleUsernameChange} placeholder='Username' value={username} />
                            <Label>Password</Label>
                            <Input type='password' onChange={handlePasswordChange} placeholder='Password' value={password} />
=======
                    <Form onSubmit={handleFormSubmit} className='login-form'>
                        <FormGroup>
                            <Label>Username</Label>
                            <Input className="login-input" onChange={handleUsernameChange} placeholder='Username' value={username} type='username' />
                            <Label>Password</Label>
                            <Input className="login-input" onChange={handlePasswordChange} placeholder='Password' value={password} type='password' />
>>>>>>> Login-function
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
        </div>
    )
}

export default Login;
<<<<<<< HEAD

=======
>>>>>>> Login-function
