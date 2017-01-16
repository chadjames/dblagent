package doubleAgent.web;

import doubleAgent.util.DoubleAgentFileParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


/**
 * Created by chad on 1/15/17.
 */
@Controller
public class MessageController {
    private final Logger logger = LoggerFactory.getLogger(DoubleAgentFileParser.class);
    @MessageMapping("/message/{agentId}")
    @SendTo("/topic/{agentId}")
    public String sendMessage(String message){
        logger.info("MSGRECEIVED " + message);
        return message;
    }
}

