import axios from "axios";
import { Link } from "react-router-dom";

const Vehicle = ({ brand, licensePlate, model, vin, vehicleId }) => {

    const assignDriver = () => {

        axios
            .post("http://localhost:8080/vehicles/assignDriver", {
                vehicleId,
                driverId: localStorage.getItem("uid")
            })
            .then((response) => {
                if (response.status === 200) {
                    alert(response.data.message);
                    localStorage.removeItem("assigned");
                    console.log(response.data);
                    window.location.reload();
                }
            })
            .catch((error) => {
                if (error.response.status === 400) {
                    console.log(error.response);
                    alert(error.response.data.message);
                    window.location.reload();
                } else {
                    alert("Something went wrong");
                }
            });
    }

    const selectVehicle = (e) => {
        e.preventDefault();

        assignDriver();
    }

    return (
        <div class="vehicle-container">
            <div class="licensePlate-container">License Plate: {licensePlate}</div>
            <div class="vin-container">VIN: {vin}</div>
            <div class="brand-container">BRAND: {brand}</div>
            <div class="model-container">MODEL: {model}</div>
            <Link onClick={e => window.confirm('Are you sure you want to select this vehicle?') && selectVehicle(e)} className="btn btn-success select-vehicle-button">Select</Link>
        </div>
    )
}

export default Vehicle;