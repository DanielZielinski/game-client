package daniel.zielinski.websocketclient.game.player;

import com.almasb.fxgl.entity.Entity;
import daniel.zielinski.websocketclient.websocket.model.input.WebSocketInputCommandPlayerSpawn;

public interface PlayerSpawn {

    Entity playerSpawn(WebSocketInputCommandPlayerSpawn command);
}
