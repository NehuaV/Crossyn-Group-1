import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from "axios";
import {AuthContext} from './AuthContext';

import {BrowserRouter as Router, Switch, Route, useHistory} from "react-router-dom";

import HeaderCom from "./components/HeaderCom";
import Home from "./pages/Home";
import Login from "./components/Login";
import Register from "./components/Register";
import Trips from "./components/Trips"
import {useState, useEffect} from "react";
import {createBrowserHistory} from "history";

function App() {

    const history = createBrowserHistory();

    const logout = () => {
        localStorage.removeItem('accessToken')
        history.push("/");
        window.location.reload();

    }

    const login = (username, password) => {
        axios
            .post("http://localhost:8080/users/login", {username, password})
            .then((res) => {
                if (res.data.error) {
                    console.log(res.data);
                    alert("Invalid credentials");
                } else {
                    console.log(res.data);
                    localStorage.setItem('accessToken', 'loggedIn')
                    history.push("/");
                    window.location.reload();
                    // TO DO:
                    // implement authentication -- loggedIn state/accessToken
                    // auto redirect to home page via authentication setup
                }
            });
    };

    const register = (username, password, email) => {
        axios
            .post("http://localhost:8080/users/register", {
                username,
                email,
                password,
            })
            .then((response) => {
                if (response.status === 201) {
                    //console.log(response.data);
                    alert(response.data);
                    localStorage.setItem('accessToken', 'loggedIn')
                    history.push("/");
                    window.location.reload();

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

    return (
        <div className="App">
            <HeaderCom logout={logout}/>
            <div className="c1-home">
                <Router>
                    <Switch>
                        {
                            localStorage.getItem('accessToken') ?
                                <>
                                    <Route exact path="/"> <Home/> </Route>
                                    <Route path="/trips"> <Trips/> </Route>
                                </>
                                :
                                <>
                                    <Route path="/register"> <Register register={register}/> </Route>
                                    <Route path="/"> <Login login={login}/> </Route>
                                </>
                        }
                    </Switch>
                </Router>
            </div>
        </div>
    )

}

export default App;