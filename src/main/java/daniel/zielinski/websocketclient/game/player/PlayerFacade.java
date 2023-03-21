package daniel.zielinski.websocketclient.game.player;


import com.almasb.fxgl.entity.Entity;
import daniel.zielinski.websocketclient.websocket.model.input.InputCommandPlayerMove;
import daniel.zielinski.websocketclient.websocket.model.input.WebSocketInputCommandPlayerSpawn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerFacade {

    private final PlayerMove playerMove;

    private final PlayerSpawn playerSpawn;

    public void move(InputCommandPlayerMove inputCommandPlayerMove) {
        playerMove.move(inputCommandPlayerMove);
    }

    public Entity playerSpawn(WebSocketInputCommandPlayerSpawn command) {
        return playerSpawn.playerSpawn(command);
    }
}
