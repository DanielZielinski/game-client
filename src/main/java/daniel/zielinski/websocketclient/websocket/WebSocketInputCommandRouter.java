package daniel.zielinski.websocketclient.websocket;

import daniel.zielinski.websocketclient.websocket.model.input.WebSocketInputCommand;
import daniel.zielinski.websocketclient.websocket.command_executor.WebSocketInputCommandExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebSocketInputCommandRouter {
    private final List<WebSocketInputCommandExecutor> webSocketInputCommandExecutors;
    public void execute(WebSocketInputCommand webSocketInputCommand, WebSocketSession session) {
        webSocketInputCommandExecutors.stream()
                .filter(webSocketInputCommandExecutor -> webSocketInputCommandExecutor.find(webSocketInputCommand.getActionName()))
                .findFirst()
                .ifPresentOrElse(
                        webSocketInputCommandExecutor -> webSocketInputCommandExecutor.execute(webSocketInputCommand, session),
                        () -> {
                            throw new IllegalArgumentException();
                        });
    }

}
