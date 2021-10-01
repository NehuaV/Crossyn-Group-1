
import { Button, Form, FormGroup, Label, Input } from 'reactstrap'
import '../styles/Login.css';


const Login = () => {
    return (
        <div>
            <h1 className="text-center">
                Login Page
            </h1>
            <div className="spacer">
                <div className="login-container">
                    <Form className='login-form'>
                        <FormGroup>
                            <Label>Username</Label>
                            <Input type='username' placeholder='Username' />
                            <Label>Password</Label>
                            <Input type='password' placeholder='Password' />
                        </FormGroup>
                        <Button>Login</Button>
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