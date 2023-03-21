package daniel.zielinski.websocketclient;


import com.fasterxml.jackson.databind.ObjectMapper;
import daniel.zielinski.websocketclient.command_router.domain.WebSocketInputCommandRouter;
import daniel.zielinski.websocketclient.game.config.GameEntityFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@RequiredArgsConstructor
@Configuration
public class WebSocketConfig {

    private final WebSocketClientSessionManager webSocketClientSessionManager;

    private final WebSocketInputCommandRouter webSocketInputCommandRouter;

    private final ObjectMapper mapper;
    @Bean
    public WebSocketConnectionManager wsConnectionManager() {

        WebSocketConnectionManager manager = new WebSocketConnectionManager(
                new StandardWebSocketClient(),
                new WebSocketMessageHandler(webSocketClientSessionManager, webSocketInputCommandRouter, mapper),
                "ws://127.0.0.1:8080/ws");
        manager.setAutoStartup(true);
        return manager;
    }

    @Bean
    public GameEntityFactory GameEntityFactory() {
        return new GameEntityFactory();
    }

}

