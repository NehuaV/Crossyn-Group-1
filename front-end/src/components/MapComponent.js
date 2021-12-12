import {
  MapContainer,
  TileLayer,
  Marker,
  Popup,
  Polyline,
} from "react-leaflet";
import React from "react";
import "../styles/MapComponent.css";
// Hardcoded dataset
import DataSet from "../testing set/dataset1.json";

function MapComponent() {
  // Converts JSON Object Array To Nested Coordinate Array
  var result = DataSet.map((a) => [a.lat, a.lon]);
  // Color of the path
  const colorOptions = { color: "red", width: "3" };
  // Use Math to decide  the middle point of a trip
  var middle = result[Math.floor(result.length / 2)];

  return (
    <>
      <h1>Map of our trips</h1>
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
