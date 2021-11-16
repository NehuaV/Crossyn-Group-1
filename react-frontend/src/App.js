import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from "axios";

import {BrowserRouter as Router, Switch, Route, useHistory} from "react-router-dom";

import HeaderCom from "./components/HeaderCom";
import Home from "./pages/Home";
import Login from "./components/Login";
import Register from "./components/Register";
import Trips from "./components/Trips"
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
            .then((response) => {
                if (response.status === 200) {
                    if (response.data.message) {
                        console.log(response.data);
                        alert(response.data.message);
                    } else {
                        console.log(response.data);
                        localStorage.setItem('accessToken', username)
                        history.push("/");
                        window.location.reload();

                        //TO DO: Authentication via JWT token
                    }
                } else {
                    alert("Something went wrong");
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
                if (response.status === 200) {
                    alert(response.data.message);
                    localStorage.setItem('accessToken', username)
                    history.push("/");
                    window.location.reload();

                    //TO DO: Authentication via JWT token
                }
            })
            .catch((error) => {
                if (error.response.status === 400) {
                    console.log(error.response);
                    alert(error.response.data.message);
                } else {
                    alert("Something went wrong");
                }
            });
    };


    return (
        <div className="App">
            <HeaderCom logout={logout} /*getTrips={getTrips}*//>
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