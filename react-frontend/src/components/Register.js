
import {useState} from 'react'
import {useHistory} from 'react-router-dom'
import axios from "axios";
import { Button, Form, FormGroup, Label, Input } from 'reactstrap'
import '../styles/Register.css';


const Register = () => {
    return (
        <h1 className="text-center">
            Register Page
            <div className="spacer">
                <div className="login-container">
                    <Form className='register-form'>
                        <FormGroup>
                            <Label>Email</Label>
                            <Input className="email-input" placeholder='Email' type='email' />
                            <Label>Username</Label>
                            <Input className="login-input" placeholder='Username' type='username' />
                            <Label>Password</Label>
                            <Input className="login-input" placeholder='Password' type='new-password' />
                            <Label>Repeat Password</Label>
                            <Input className="login-input" placeholder='Password' type='new-password' />
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