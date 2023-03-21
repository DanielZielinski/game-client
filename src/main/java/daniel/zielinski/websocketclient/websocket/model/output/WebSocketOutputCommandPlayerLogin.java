package daniel.zielinski.websocketclient.websocket.model.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebSocketOutputCommandPlayerLogin implements WebSocketOutputCommand<OutputCommandPlayerLogin> {
    private String actionName;

    private OutputCommandPlayerLogin data;


}