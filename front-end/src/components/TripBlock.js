import React from "react";
import { Link } from "react-router-dom";

const TripBlock = ({
  tripId,
  avgSpeed,
  distance,
  startPoint,
  endPoint,
  weatherInfo,
}) => {
  return (
    <Link to={"/map/" + tripId} className="trip-link-container">
      <div className="trip-block">
        <a>
          <u>Trip Number: {tripId}</u>
        </a>
        <a>
          <b>Start:</b> <i>{startPoint}</i>
        </a>
        <a>
          <b>End:</b> <i>{endPoint} </i>
        </a>
        <a>
          <b>Average Speed:</b> {avgSpeed} km/h <b>Distance:</b> {distance}
        </a>
        <a>
          <b>Weather Information:</b> {weatherInfo}
        </a>
      </div>
    </Link>
  );
};

export default TripBlock;
