import React from "react";

const TripBlock = ({id,avgSpeed, distance, startpoint, endpoint}) =>{

    return(
        <div className="trip-block">
            <a><u>Trip Number: {id}</u> </a>
            <a> <b>Start:</b> <i>{startpoint}</i></a>
            <a> <b>End:</b> <i>{endpoint} </i></a>
            <a><b>Average Speed:</b> {avgSpeed} km/h   <b>Distance:</b> {distance}</a>
        </div>
    )
}

export default TripBlock;