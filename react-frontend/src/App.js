import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";

import BootstrapNavbar from "./components/Navbar";
import Home from "./pages/Home";
import Login from "./components/Login";
import Register from "./components/Register";


function App() {

    return (
        <div className="App">
            <Router>
                <BootstrapNavbar/>
                <br/>
                <Switch>
                    <Route exact path="/"> <Home/> </Route>
                    <Route path="/register"> <Register/> </Route>
                    <Route path="/login"> <Login /> </Route>
                </Switch>
            </Router>
        </div>
    )

}

export default App;