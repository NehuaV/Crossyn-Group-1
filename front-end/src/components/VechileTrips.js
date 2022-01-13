import React, { useEffect, useState } from "react";
import "../styles/Trips.css";
import TripBlock from "./TripBlock";
import axios from "axios";
import { useParams } from "react-router-dom/cjs/react-router-dom.min";

const VechileTrips = (props) => {
  const [trips, setTrips] = useState([]);
  const { vehicleId } = useParams();

  console.log("Vehicle ID: " + vehicleId);

  useEffect(() => {
    console.log("Vehicle ID: " + vehicleId);
    axios.get(`trips/vehicle?id=${vehicleId}`).then((res) => {
      setTrips(res.data);
      console.log(res.data);
    });
  }, []);
  //console.log(initialTrips + " TEST")

  return (
    <div>
      <div className="wrapper">
        <div className="trip-list">
          {trips.map((trip) => (
            <TripBlock key={trip.id} {...trip} />
          ))}
        </div>
      </div>
    </div>
  );
};

export default VechileTrips;
