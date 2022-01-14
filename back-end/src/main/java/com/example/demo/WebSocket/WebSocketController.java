package com.example.demo.WebSocket;

import com.example.demo.models.POJO.DataLinePOJO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebSocketController {

    @MessageMapping("/general")
    @SendTo("/topic/general")
    public DataLinePOJO greeting(@RequestBody DataLinePOJO dataLinePOJO) {
        System.out.println(dataLinePOJO);

        return dataLinePOJO;
    }
}
