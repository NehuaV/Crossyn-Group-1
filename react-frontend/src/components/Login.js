import {useState} from 'react'
import {useHistory} from 'react-router-dom'
import axios from "axios";

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [loginErrorMessage, setLoginErrorMessage] = useState('');

    const history = useHistory();

    const login = (username, password) => {
        axios.post('http://localhost:8080/users',
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
        <form onSubmit={handleFormSubmit} className='login-form'>
            <h2>Login</h2>
            <p className='error-msg'>{loginErrorMessage}</p>
            <input className="login-input" onChange={handleUsernameChange} placeholder='Username' value={username}
                   type='text'/>
            <input className="login-input" onChange={handlePasswordChange} placeholder='Password' value={password}
                   type='password'/>
            <input type='submit' value='Sign In'/>
        </form>
    )
}

export default Login