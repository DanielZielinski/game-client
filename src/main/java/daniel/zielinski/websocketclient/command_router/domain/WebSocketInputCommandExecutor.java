package daniel.zielinski.websocketclient.command_router.domain;


import daniel.zielinski.websocketclient.shared.model.input.WebSocketInputCommand;
import org.springframework.web.socket.WebSocketSession;


public interface WebSocketInputCommandExecutor<T extends WebSocketInputCommand> {
    void execute(T command, WebSocketSession session);
    boolean find(String webSocketInputCommandType);
}

