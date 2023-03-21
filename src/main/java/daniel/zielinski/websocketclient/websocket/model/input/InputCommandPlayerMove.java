package daniel.zielinski.websocketclient.websocket.model.input;

import lombok.Data;

@Data
public class InputCommandPlayerMove {
    private String sessionId;
    private String direction;
    private double distance;
}
