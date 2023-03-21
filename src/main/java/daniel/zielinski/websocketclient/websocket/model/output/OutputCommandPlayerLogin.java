package daniel.zielinski.websocketclient.websocket.model.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutputCommandPlayerLogin {

    private String username;
    private String password;
}
