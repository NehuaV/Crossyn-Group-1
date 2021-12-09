import React from "react";

const TripBlock = ({tripId, avgSpeed, distance, startPoint, endPoint}) => {

    return (
        <div className="trip-block">
            <a><u>Trip Number: {tripId}</u> </a>
            <a> <b>Start:</b> <i>{startPoint}</i></a>
            <a> <b>End:</b> <i>{endPoint} </i></a>
            <a><b>Average Speed:</b> {avgSpeed} km/h <b>Distance:</b> {distance}</a>
        </div>
    )
}

export default TripBlock;