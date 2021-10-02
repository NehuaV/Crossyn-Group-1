import {useState} from 'react';
import axios from "axios";
import {useHistory} from "react-router-dom";

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
        <form onSubmit={handleSubmit} className='register-form'>
            <h2>Register</h2>
            <p className='error-msg'>{errorMessage}</p>
            <input onChange={handleUsernameChange} type='text' placeholder='Username'/>
            <input onChange={handleEmailChange} type='email' placeholder='Email'/>
            <input onChange={handlePasswordChange} type='password' placeholder='Password'/>
            <input onChange={handleConfirmPasswordChange} type='password' placeholder='Confirm Password'/>
            <input type='submit' value='Register'/>
        </form>
    )
}

export default Register;