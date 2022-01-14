import React, {useState, useEffect} from "react";
import axios from "axios";
import {Link} from "react-router-dom";
import Vehicle from "./Vehicle";
import {Button, Form} from "react-bootstrap";
import {Input} from "reactstrap";
import {createBrowserHistory} from "history";

const DriverAssignment = () => {

    const history = createBrowserHistory();
    const [vehicles, setVehicles] = useState([]);
    const [licensePlate, setLicensePlate] = useState("");

    useEffect(() => {
        axios.get(`vehicles`).then((res) => {
            setVehicles(res.data);
            console.log(res.data);
        });
    }, []);

    const handleInputChange = (e) => {
        e.preventDefault();

        setLicensePlate(e.target.value);
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        axios
            .post("vehicles/assignDriver", {
                licensePlate: licensePlate,
            })
            .then((response) => {
                alert(response.data.message);
                history.push("/");
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
    }

    return (
        <div className="home-vehicle-container">

            <Form onSubmit={handleSubmit}>
                <div className="driver-instruction-container">Please enter the license plate number of your vehicle!</div>
                <Input onChange={handleInputChange}
                       className="register-input"
                       placeholder="License Plate"
                       type="text"
                       required/>
                <Button variant="primary" type="submit" className="pick-vehicle-button"> Pick A Vehicle </Button>
            </Form>
        </div>
    );
};

export default DriverAssignment;
