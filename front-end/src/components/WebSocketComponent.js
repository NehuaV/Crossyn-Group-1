import React, { useState } from "react";
import SockJsClient from "react-stomp";

import { Card, Form, Button } from "react-bootstrap";

import Trip1 from "../testing set/trip1.json";

const SOCKET_URL = "http://localhost:8080/websocket";
const GENERAL_TOPIC = "/topic/general";

const WebSocketComponent = () => {
  let generalClientRef;
  const onConnected = () => {
    console.log("Connected.");
  };
  const onDisconnected = () => {
    console.log("Disconnected.");
  };

  const sendMessage = async () => {
    Trip1.map((obj) => {
      generalClientRef.sendMessage("/app/general", JSON.stringify(obj));
    });
  };

  const onMessageReceived = async (msg) => {
      // No need to log messages
  };

  const submitHandler = (event) => {
    event.preventDefault();
    sendMessage();
  };

  return (
    <Card>
      <SockJsClient
        url={SOCKET_URL}
        topics={[GENERAL_TOPIC]}
        heartbeatIncoming={100}
        onConnect={onConnected}
        onMessage={(msg) => onMessageReceived(msg)}
        onDisconnect={onDisconnected}
        debug={false}
        ref={(client) => {
          generalClientRef = client;
        }}
      />
      <Card.Header>
        <Form>
          <Form.Group>
            <Form.Label>Send Data Packets!</Form.Label>
            <br />
            <div className="d-flex">
              <Button className="w-100" type="submit" onClick={submitHandler}>
                Send
              </Button>
            </div>
          </Form.Group>
        </Form>
      </Card.Header>
    </Card>
  );
};

export default WebSocketComponent;
