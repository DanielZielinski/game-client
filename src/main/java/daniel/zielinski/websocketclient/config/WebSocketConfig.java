package daniel.zielinski.websocketclient.config;


import daniel.zielinski.websocketclient.game.GameEntityFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@RequiredArgsConstructor
@Configuration
public class WebSocketConfig {

    private final WebSocketClientSessionManager webSocketClientSessionManager;
    @Bean
    public WebSocketConnectionManager wsConnectionManager() {

        WebSocketConnectionManager manager = new WebSocketConnectionManager(
                new StandardWebSocketClient(),
                new SimpleWsHandler(webSocketClientSessionManager),
                "ws://127.0.0.1:8080/ws");
        manager.setAutoStartup(true);
        return manager;
    }

    @Bean
    public GameEntityFactory GameEntityFactory() {
        return new GameEntityFactory();
    }

}

