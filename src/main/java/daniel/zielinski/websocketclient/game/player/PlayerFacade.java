package daniel.zielinski.websocketclient.game.player;


import daniel.zielinski.websocketclient.websocket.model.input.InputCommandPlayerMove;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerFacade {

    private final PlayerMove playerMove;

    public void move(InputCommandPlayerMove inputCommandPlayerMove) {
        playerMove.move(inputCommandPlayerMove);
    }
}
