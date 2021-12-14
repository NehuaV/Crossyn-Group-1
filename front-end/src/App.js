import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import HeaderCom from "./components/HeaderCom";
import Home from "./pages/Home";
import Login from "./components/Login";
import Register from "./components/Register";

import Trips from "./components/Trips";
import { createBrowserHistory } from "history";
import VehicleForm from "./components/VehicleForm";
import VehicleTable from "./components/vehicleTable";
import VechileTrips from "./components/VechileTrips";
import MapComponent from "./components/MapComponent";

function App() {
  const history = createBrowserHistory();

  const logout = () => {
    localStorage.clear();
    history.push("/");
    window.location.reload();
  };

  const login = (username, password) => {
    axios
      .post("http://localhost:8080/users/login", { username, password })
      .then((response) => {
        if (response.status === 200) {
          if (response.data.message) {
            console.log(response.data);
            alert(response.data.message);
          } else {
            console.log(response.data);
            localStorage.setItem("accessToken", username);
            localStorage.setItem("uid", response.data.userId);
            if (response.data.roleId == 1) {
              localStorage.setItem("loggedInAsFleetOwner", "true");    
            } else {
              localStorage.setItem("loggedInAsDriver", "true");
              if(response.data.assigned == false){
                localStorage.setItem("assigned", "false");
              }
            }
            history.push("/");
            window.location.reload();

            //TO DO: Authentication via JWT token
          }
        } else {
          alert("Something went wrong");
        }
      });
  };

  const register = (username, password, email, roleId) => {
    axios
      .post("http://localhost:8080/users/register", {
        username,
        email,
        password,
        roleId,
      })
      .then((response) => {
        if (response.status === 200) {
          alert(response.data.message);
          localStorage.setItem("accessToken", username);
          localStorage.setItem("uid", response.data.userId);
          if (roleId == 1) {
            localStorage.setItem("loggedInAsFleetOwner", "true");
          } else {
            localStorage.setItem("loggedInAsDriver", "true");
            localStorage.setItem("assigned", "false");
          }
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
      <HeaderCom logout={logout} /*getTrips={getTrips}*/ />
      <div className="c1-home">
        <Router>
          <Switch>
            <Route exact path="/">
              <Home />
            </Route>
            {localStorage.getItem("accessToken") ? (
              <>
                {localStorage.getItem("loggedInAsFleetOwner") ? (
                  <>
                    <Route exact path="/vehicles">
                      <VehicleTable />
                    </Route>
                    <Route exact path="/addVehicle">
                      <VehicleForm />
                    </Route>
                    <Route exact path="/VehicleTrips/:vehicleId">
                      <VechileTrips />
                    </Route>
                  </>
                ) : (
                  <>
                    <Route exact path="/trips">
                      <Trips />
                    </Route>
                  </>
                )}
                <Route exact path="/map">
                  <MapComponent />
                </Route>
              </>
            ) : (
              <>
                <Route exact path="/register">
                  <Register register={register} />
                </Route>
                <Route exact path="/login">
                  <Login login={login} />
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
