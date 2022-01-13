import { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import Vehicle from "./Vehicle";

const DriverAssignment = () => {
  const [vehicles, setVehicles] = useState([]);

  useEffect(() => {
    axios.get(`vehicles`).then((res) => {
      setVehicles(res.data);
      console.log(res.data);
    });
  }, []);

  return (
    <div className="home-vehicle-container">
      <div className="driver-instruction-container">
        Please select the vehicle, you are going to drive!
      </div>

      {vehicles.map((vehicle) => (
        <Vehicle key={vehicle.vehicleId} {...vehicle} />
      ))}
    </div>
  );
};

export default DriverAssignment;
