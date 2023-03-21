package daniel.zielinski.websocketclient;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;


@Service
public class WebSocketClientSessionManager {

    @Getter
    @Setter
    private WebSocketSession session = null;

}
