package daniel.zielinski.websocketclient.websocket.model.input;

import lombok.Data;

@Data
public class InputCommandPlayerSpawn {
    private String sessionId;
    private double positionX;
    private double positionY;
}
