package daniel.zielinski.websocketclient.websocket.command_executor;


import daniel.zielinski.websocketclient.game.player.PlayerFacade;
import daniel.zielinski.websocketclient.websocket.model.input.WebSocketInputCommandPlayerMove;
import daniel.zielinski.websocketclient.websocket.model.input.WebSocketInputCommandType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebSocketInputCommandExecutorPlayerMove implements WebSocketInputCommandExecutor<WebSocketInputCommandPlayerMove> {

    private final PlayerFacade playerFacade;

    @Override
    public void execute(WebSocketInputCommandPlayerMove command, WebSocketSession session) {
        playerFacade.move(command.getData());
    }

    @Override
    public boolean find(String webSocketInputCommandType) {
        return webSocketInputCommandType.equals(WebSocketInputCommandType.PLAYER_MOVE.name());
    }
}
