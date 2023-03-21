package daniel.zielinski.websocketclient.websocket.model.input;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WebSocketInputCommandPlayerMove implements WebSocketInputCommand<InputCommandPlayerMove> {
    private String actionName;
    private InputCommandPlayerMove data;
}