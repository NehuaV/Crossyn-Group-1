import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import jwt_decode from 'jwt-decode';

import {BrowserRouter as Router, Switch, Route} from "react-router-dom";

import HeaderCom from "./components/HeaderCom";
import Home from "./pages/Home";
import Login from "./components/Login";
import Register from "./components/Register";

import Trips from "./components/Trips";
import {createBrowserHistory} from "history";
import VehicleForm from "./components/VehicleForm";
import VehicleTable from "./components/vehicleTable";
import VechileTrips from "./components/VechileTrips";
import MapComponent from "./components/MapComponent";
import HomeDefault from "./components/HomeDefault";
import WebSocketComponent from "./components/WebSocketComponent";

function App() {
    const history = createBrowserHistory();

    const logout = () => {
        localStorage.clear();
        history.push("/");
        window.location.reload();
    };

    const login = (username, password) => {
        axios
            .post("login", {username, password})
            .then((response) => {

                const token = response.data.toString();
                const userCredentials = jwt_decode(token);

                localStorage.setItem("accessToken", token);
                localStorage.setItem("role", userCredentials.role);

                history.push("/");
                window.location.reload();
            })
            .catch((error) => {
                if (error.response.status === 403) {
                    alert("Invalid Credentials!");
                } else {
                    alert("Something went wrong");
                }
            });
    };

    const register = (username, password, email, role) => {

        const instance = axios.create();
        delete instance.defaults.headers.common['Authorization'];

        instance
            .post("users/register", {
                username,
                email,
                password,
                role,
            })
            .then((response) => {
                alert(response.data.message);
                console.log(response.data);
                history.push("/login");
                window.location.reload();
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
            <HeaderCom logout={logout} /*getTrips={getTrips}*/ />
            <div className="c1-home">
                <Router>
                    <Switch>
                        {localStorage.getItem("accessToken") ? (
                            <>
                                <Route exact path="/">
                                    <Home/>
                                </Route>
                                <Route exact path="/websocket">
                                    <WebSocketComponent/>
                                </Route>
                                {localStorage.getItem("role") === "fleetOwner" ? (
                                    <>
                                        <Route exact path="/vehicles">
                                            <VehicleTable/>
                                        </Route>
                                        <Route exact path="/addVehicle">
                                            <VehicleForm/>
                                        </Route>
                                        <Route exact path="/VehicleTrips/:vehicleId">
                                            <VechileTrips/>
                                        </Route>
                                    </>
                                ) : (
                                    <>
                                        <Route exact path="/trips">
                                            <Trips/>
                                        </Route>
                                    </>
                                )}
                                <Route exact path="/map/:tripId">
                                    <MapComponent/>
                                </Route>
                            </>
                        ) : (
                            <>
                                <Route exact path="/register">
                                    <Register register={register}/>
                                </Route>
                                <Route exact path="/login">
                                    <Login login={login}/>
                                </Route>
                                <Route exact path="/">
                                    <HomeDefault/>
                                </Route>
                            </>
                        )}
                    </Switch>
                </Router>
            </div>
        </div>
    );
}

export default App;
