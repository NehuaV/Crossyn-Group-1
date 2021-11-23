import React from "react";
import * as ReactBootStrap from "react-bootstrap";
import axios from "axios";
import { Button } from "react-bootstrap";

class VehicleTable extends React.Component {

    // First Initialize an empty array called vehicles
    constructor(props){
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
    async getAllVehicles(){
        await axios.get("http://localhost:8080/vehicles/owner/" + localStorage.getItem('uid'))
        .then(response => {
            console.log(response.data);
            this.setState({vehicles: response.data});
        })
    }

    // I have no idea how to use UseState so fuck functional components
    
  render() {
    return (
      <div>
        <ReactBootStrap.Table striped bordered hover>
          <thead>
            <tr>
              <th>ID</th>
              <th>Brand</th>
              <th>License Plate</th>
              <th>Model</th>
              <th>Vin</th>
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
              </tr>
            ))}
          </tbody>
        </ReactBootStrap.Table>
        <Button variant="success" href="/addVehicle">
          Add vehicle
        </Button>
      </div>
    );
  }
}

export default VehicleTable;
