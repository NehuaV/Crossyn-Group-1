import React, { useEffect, useState } from "react";
import "../styles/Trips.css";
import TripBlock from "./TripBlock";
import axios from "axios";

const Trips = () => {
  const [trips, setTrips] = useState([]);

  useEffect(() => {
    axios.get(`trips/driver`).then((res) => {
      setTrips(res.data);
      console.log(res.data);
    });
  }, []);

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

export default Trips;
