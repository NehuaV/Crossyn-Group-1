import React from "react";

const TripBlock = ({id,avgSpeed, distance}) =>{

    return(
        <div className="trip-block">
            <a>Trip Number: {id}   Average Speed: {avgSpeed} km/h   Distance: {distance} km</a>
        </div>
    )
}

export default TripBlock;