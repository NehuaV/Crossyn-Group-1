import React, {useEffect, useState} from "react";
import * as ReactBootStrap from "react-bootstrap";
import axios from "axios";
import {Button} from "react-bootstrap";

const VehicleTable = () => {
    const [vehicles, setVehicles] = useState();

    useEffect(() => {
        const getVehicles = async () => {
            const {data} = await axios.get("http://localhost:8080/vehicles/owner/" + localStorage.getItem('uid'));
            // .then(res => {
            //     setVehicles(res.data);
            //     console.log(res.data);
            // });
            setVehicles(data);
        };
        getVehicles();
    }, [setVehicles]);

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
                {/*<tbody>*/}
                {/*{vehicles.map(vehicle => (*/}
                {/*    <tr key={vehicle.vehicleId}>*/}
                {/*        <td>{vehicle.vehicleId}</td>*/}
                {/*        <td>{vehicle.brand}</td>*/}
                {/*        <td>{vehicle.licensePlate}</td>*/}
                {/*        <td>{vehicle.model}</td>*/}
                {/*        <td>{vehicle.vin}</td>*/}
                {/*    </tr>*/}
                {/*))}*/}
                {/*</tbody>*/}
            </ReactBootStrap.Table>
            <Button variant="success" href="/addVehicle">Add vehicle</Button>
        </div>
    );
};

export default VehicleTable;