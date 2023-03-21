package daniel.zielinski.websocketclient.game.player;

import com.almasb.fxgl.entity.Entity;
import daniel.zielinski.websocketclient.websocket.model.input.WebSocketInputCommandPlayerSpawn;
import org.springframework.stereotype.Service;

import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

@Service
class PlayerSpawnImpl implements PlayerSpawn {

    @Override
    public Entity playerSpawn(WebSocketInputCommandPlayerSpawn command) {
        return spawn("player", command.getData().getPositionX(), command.getData().getPositionY());
    }
}
