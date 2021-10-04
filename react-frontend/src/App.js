import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

<<<<<<< HEAD
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";

=======
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
>>>>>>> Login-function

import HeaderCom from "./components/HeaderCom";
import Home from "./pages/Home";
import Login from "./components/Login";
import Register from "./components/Register";


function App() {

    return (
<<<<<<< HEAD
        <div className="App">
=======
        <div>
>>>>>>> Login-function
            <HeaderCom />
            <div className="c1-home">
                <Router>                   
                    <Switch>
                        <Route exact path="/"> <Home /> </Route>
                        <Route path="/register"> <Register /> </Route>
                        <Route path="/login"> <Login /> </Route>
                    </Switch>
                </Router>
            </div>
        </div>
    )

}

export default App;