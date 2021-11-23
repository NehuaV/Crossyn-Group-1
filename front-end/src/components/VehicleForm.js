import React, {useState} from "react";

import {Form, Row, Button} from "react-bootstrap";
import axios from "axios";
import "../styles/VehicleForm.css";
import {Link} from "react-router-dom";

const VehicleForm = () => {
    const initialState = {
        ownerId: localStorage.getItem('uid'),
        vin: "",
        model: "",
        brand: "",
        licensePlate: "",
    }

    const [vehicle, setVehicle] = useState(initialState);

    const credentialChange = (event) => {
        const {name, value} = event.target;
        setVehicle({...vehicle, [name]: value});
    };

    const addVehicle = () => {
        console.log(vehicle.ownerId);
        axios
            .post("http://localhost:8080/vehicles/add", {
                ownerId: vehicle.ownerId,
                vin: vehicle.vin,
                model: vehicle.model,
                brand: vehicle.brand,
                licensePlate: vehicle.licensePlate
            })
            .then((response) => {
                if (response.status === 200) {
                    alert(response.data.message);
                    console.log(response.data);
                    console.log(vehicle);
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

    const handleSubmit = (e) => {
        e.preventDefault();
        addVehicle();
    }

    return (
        <div className="carbox">
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formGridVin">
                    <Form.Label>Vin</Form.Label>
                    <Form.Control type="text" placeholder="Enter vin" required value={vehicle.vin}
                                  onChange={credentialChange} name="vin" id="vin"/>
                </Form.Group>

                <Row className="mb-3">
                    <Form.Group controlId="formGridMake">
                        <Form.Label>Brand</Form.Label>
                        <Form.Control required value={vehicle.brand} onChange={credentialChange} name="brand" id="brand"
                                      type="text" placeholder="Enter Brand"/>
                    </Form.Group>

                    <Form.Group controlId="formGridModel">
                        <Form.Label>Model</Form.Label>
                        <Form.Control required value={vehicle.model} onChange={credentialChange} name="model" id="model"
                                      type="text" placeholder="Enter Model"/>
                    </Form.Group>
                </Row>

                <Form.Group className="mb-3" controlId="formGridLicensePlate">
                    <Form.Label>License Plate</Form.Label>
                    <Form.Control required value={vehicle.licensePlate} onChange={credentialChange} name="licensePlate"
                                  id="licensePlate" placeholder="Enter License Plate Number"/>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
                <div className="back-button-container">
                    <Link to={'/'} className="btn-link"><Button variant="secondary"> Back </Button></Link>
                </div>
            </Form>
        </div>
    );
}

export default VehicleForm;
