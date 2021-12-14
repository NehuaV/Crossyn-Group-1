import React from "react";
import * as ReactBootStrap from "react-bootstrap";
import axios from "axios";
import {Button, Card} from "react-bootstrap";
import "../styles/VehicleTable.css";


class VehicleTable extends React.Component {

    // First Initialize an empty array called vehicles
    constructor(props) {
        super(props);
        this.state = {
            vehicles: [],
        }
    }

    // Call method when the component mounts
    componentDidMount() {
        this.getAllVehicles();
    }

    // Waits for data to come then executes the rest of the code :)
    async getAllVehicles() {
        await axios.get("http://localhost:8080/vehicles/owner/" + localStorage.getItem('uid'))
            .then(response => {
                console.log(response.data);
                this.setState({vehicles: response.data});
            })
    }

    render() {
        return (
            <>
                <Card>
                    <Card.Header className="table-header">
                       Your Vehicles
                    </Card.Header>
                    <Card.Body>
                        <ReactBootStrap.Table striped bordered hover>
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Brand</th>
                                <th>License Plate</th>
                                <th>Model</th>
                                <th>Vin</th>
                                <th>Mileage</th>
                                <th>Trips</th>
                            </tr>
                            </thead>
                            <tbody>
                            {this.state.vehicles.map((vehicle) => (
                                <tr key={vehicle.vehicleId}>
                                    <td>{vehicle.vehicleId}</td>
                                    <td>{vehicle.brand}</td>
                                    <td>{vehicle.licensePlate}</td>
                                    <td>{vehicle.model}</td>
                                    <td>{vehicle.vin}</td>
                                    <td>{vehicle.mileage.toFixed(2)} km</td>
                                    <td>
                                    <Button href={"/VehicleTrips/" + vehicle.vehicleId} className="ShowTripButton">
                        
                        
                            Show trips
                        </Button>
                                    </td>
                                </tr>
                            ))}
                            </tbody>
                        </ReactBootStrap.Table>
                        <Button variant="success" href="/addVehicle" className="addVehicleButton">
                            Add vehicle
                        </Button>
                    </Card.Body>
                </Card>
            </>
        );
    }
}

export default VehicleTable;
