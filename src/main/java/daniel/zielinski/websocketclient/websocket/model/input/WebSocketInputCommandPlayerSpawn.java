package daniel.zielinski.websocketclient.websocket.model.input;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WebSocketInputCommandPlayerSpawn implements WebSocketInputCommand<InputCommandPlayerSpawn> {
    private String actionName;
    private InputCommandPlayerSpawn data;
}