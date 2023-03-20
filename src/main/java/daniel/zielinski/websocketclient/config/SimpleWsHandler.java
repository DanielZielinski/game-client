package daniel.zielinski.websocketclient.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Slf4j
@RequiredArgsConstructor
public class SimpleWsHandler implements WebSocketHandler {

    private final WebSocketClientSessionManager webSocketClientSessionManager;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Session {} added to manager", session.getId());
        webSocketClientSessionManager.setSession(session);

    }


    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println(message);
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