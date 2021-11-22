import React,{useState} from "react";

import { Form, Col, Row, Button } from "react-bootstrap";

import "../styles/VehicleForm.css";

const VechileForm = (props) => {
const initialState = {
vin : "",
make : "",
model : "",
licensePlate : "",

}

const [vehicle, setVehicle] = useState(initialState);

const credentialChange = (event) => {
  const { name, value } = event.target;
  setVehicle({ ...vehicle, [name]: value });
};

  return (
    <div className="carbox">
      <Form>
        <Form.Group controlId="formGridVin">
          <Form.Label>Vin</Form.Label>
          <Form.Control  type="text" placeholder="Enter vin" required value={vehicle.vin} onChange={credentialChange} name="vin" id="vin" />
        </Form.Group>

        <Row className="mb-3">
          <Form.Group controlId="formGridMake">
            <Form.Label>Make</Form.Label>
            <Form.Control required value={vehicle.make} onChange={credentialChange} name="make" id="make" type="text" placeholder="Enter Make" />
          </Form.Group>

          <Form.Group controlId="formGridModel">
            <Form.Label>Model</Form.Label>
            <Form.Control required value={vehicle.model} onChange={credentialChange} name="model" id="model" type="text" placeholder="Enter Model" />
          </Form.Group>
        </Row>

        <Form.Group className="mb-3" controlId="formGridLicensePlate">
          <Form.Label>LicensePlate</Form.Label>
          <Form.Control required value={vehicle.licensePlate} onChange={credentialChange} name="licensePlate" id="licensePlate" placeholder="enter licenseplate number" />
        </Form.Group>
        <Button variant="primary" type="button">
          Submit
        </Button>
      </Form>
    </div>
  );
}

export default VechileForm;
