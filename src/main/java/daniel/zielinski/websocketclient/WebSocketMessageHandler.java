package daniel.zielinski.websocketclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import daniel.zielinski.websocketclient.command_router.domain.WebSocketInputCommandRouter;
import daniel.zielinski.websocketclient.shared.model.input.WebSocketInputCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Slf4j
@RequiredArgsConstructor
public class WebSocketMessageHandler implements WebSocketHandler {

    private final WebSocketClientSessionManager webSocketClientSessionManager;

    private final WebSocketInputCommandRouter webSocketInputCommandRouter;

    private final ObjectMapper objectMapper;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Session {} added to manager", session.getId());
        webSocketClientSessionManager.setSession(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.info(message.getPayload().toString());
        WebSocketInputCommand webSocketInputCommand = objectMapper.readValue(message.getPayload().toString(), WebSocketInputCommand.class);
        webSocketInputCommandRouter.execute(webSocketInputCommand, session);

    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("Session {} removed to manager", session.getId());
        webSocketClientSessionManager.setSession(null);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}