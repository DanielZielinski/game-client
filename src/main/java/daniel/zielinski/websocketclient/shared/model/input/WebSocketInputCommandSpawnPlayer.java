package daniel.zielinski.websocketclient.shared.model.input;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WebSocketInputCommandSpawnPlayer implements WebSocketInputCommand<InputCommandSpawnPLayer> {
    private String actionName;
    private InputCommandSpawnPLayer data;
}