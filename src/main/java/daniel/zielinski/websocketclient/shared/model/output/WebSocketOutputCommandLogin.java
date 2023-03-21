package daniel.zielinski.websocketclient.shared.model.output;

import lombok.Data;

@Data
public class WebSocketOutputCommandLogin implements WebSocketOutputCommand {
    private String actionName = WebSocketOutputCommandType.LOGIN.name();

}