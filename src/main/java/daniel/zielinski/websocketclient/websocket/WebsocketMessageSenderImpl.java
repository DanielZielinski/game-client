package daniel.zielinski.websocketclient.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
class WebsocketMessageSenderImpl implements WebsocketMessageSender {

    private final ObjectMapper objectMapper;

    private final WebSocketClientSessionManager webSocketClientSessionManager;

    @Override
    public void send(Object message) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(message);
            log.info("Send message {}", jsonMessage);
            webSocketClientSessionManager.getSession().sendMessage(new TextMessage(jsonMessage));
        } catch (IOException e) {
            log.error("Error occurs while sending message", e);
            throw new RuntimeException(e);
        }
    }
}
