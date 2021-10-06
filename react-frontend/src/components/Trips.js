import React, {useState} from 'react'
import '../styles/Trips.css'
import TripBlock from './TripBlock'



const Trips = ({initialTrips}) => {

    //console.log(initialTrips + " TEST")

    return (

        <div>
            <div className="wrapper">
                <div className="trip-list">
                    <TripBlock id={1} avgSpeed={74} distance={2.02}/>
                    <TripBlock id={2} avgSpeed={74} distance={11.89}/>
                    <TripBlock id={3} avgSpeed={29} distance={33.55}/>
                    {/*{initialTrips.map(trip=>(*/}
                    {/*    <TripBlock key={trip.id} {...trip}/>*/}
                    {/*))}*/}

                </div>
            </div>
        </div>
    )
};

export default Trips


