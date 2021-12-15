import {
  MapContainer,
  TileLayer,
  Marker,
  Popup,
  Polyline,
} from "react-leaflet";
import React from "react";
import "../styles/MapComponent.css";
import { useParams } from "react-router-dom/cjs/react-router-dom.min";
// Hardcoded dataset
import Trip1 from "../testing set/trip1.json";
import Trip2 from "../testing set/trip2.json";
import Trip3 from "../testing set/trip3.json";

function MapComponent() {

  const { tripId } = useParams();

  var result = null;

  if (tripId == 1 || tripId == 4) {
    result = Trip1.map((a) => [a.lat, a.lon]);
  } else if (tripId == 2 || tripId == 5) {
    result = Trip2.map((a) => [a.lat, a.lon]);
  } else {
    result = Trip3.map((a) => [a.lat, a.lon]);
  }


  // // Converts JSON Object Array To Nested Coordinate Array
  // var result = DataSet.map((a) => [a.lat, a.lon]);

  // Color of the path
  const colorOptions = { color: "red", width: "3" };
  // Use Math to decide  the middle point of a trip
  var middle = result[Math.floor(result.length / 2)];

  return (
    <>
      <h1>Trip #{tripId}</h1>
      <MapContainer
        center={result[0]}
        zoom={13}
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
