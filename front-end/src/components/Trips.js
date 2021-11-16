import React, {useEffect, useState} from 'react'
import '../styles/Trips.css'
import TripBlock from './TripBlock'
import axios from "axios";



const Trips = () => {

    const [trips, setTrips] = useState([]);

    useEffect(() =>{
        axios.get(`http://localhost:8080/trips`)
                .then(res => {
                    setTrips(res.data);
                    console.log(res.data);
                });
        },[]
    )
    //console.log(initialTrips + " TEST")

    return (

        <div>
            <div className="wrapper">
                <div className="trip-list">
                    {trips.map(trip=>(
                        <TripBlock key={trip.id} {...trip}/>
                    ))}
                </div>
            </div>
        </div>
    )
};

export default Trips


