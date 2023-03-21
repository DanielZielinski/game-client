package daniel.zielinski.websocketclient.game.player;

import com.almasb.fxgl.entity.Entity;
import daniel.zielinski.websocketclient.game.model.Player;
import daniel.zielinski.websocketclient.websocket.model.input.InputCommandPlayerMove;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerMoveImpl implements PlayerMove {

    private final PlayerCache playerCache;

    @Override
    public void move(InputCommandPlayerMove inputCommandPlayerMove) {

        Player player = playerCache.getPlayer(inputCommandPlayerMove.getSessionId());
        Entity playerEntity = player.getPlayerEntity();

        if(inputCommandPlayerMove.getDirection().equals("Y")){
            playerEntity.translateY(inputCommandPlayerMove.getDistance());
        }
        if(inputCommandPlayerMove.getDirection().equals("X")){
            playerEntity.translateX(inputCommandPlayerMove.getDistance());
        }

    }
}
