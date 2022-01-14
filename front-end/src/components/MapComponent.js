import {
  MapContainer,
  TileLayer,
  Marker,
  Popup,
  Polyline,
} from "react-leaflet";
import React, { useEffect, useState } from "react";
import "../styles/MapComponent.css";
import { useParams } from "react-router-dom/cjs/react-router-dom.min";
import axios from "axios";


function MapComponent() {
  const { tripId } = useParams();
  const [result, setResult] = useState(null);

  useEffect(() => {
    const loadTrip = async () => {
      const response = await axios.get(`trips/${tripId}`);
      setResult(response.data.datalines.map((a) => [a.lat, a.lon]));
    };
    loadTrip();
  }, []);

  // // Converts JSON Object Array To Nested Coordinate Array
  // var result = DataSet.map((a) => [a.lat, a.lon]);

  // Color of the path
  const colorOptions = { color: "red", width: "3" };

  return !result ? null : (
    <>
      <h1>Trip #{tripId}</h1>
      <MapContainer
        center={result[Math.floor(result.length / 2)]}
        zoom={9}
        scrollWheelZoom={true}
        animate={true}
      >
        <TileLayer
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        <Marker position={result[0]}>
          <Popup>START OF THE TRIP</Popup>
        </Marker>
        <Marker position={result[result.length - 1]}>
          <Popup>END OF THE TRIP</Popup>
        </Marker>
        <Polyline pathOptions={colorOptions} positions={result} />
      </MapContainer>
    </>
  );
}

export default MapComponent;
