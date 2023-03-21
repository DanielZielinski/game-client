package daniel.zielinski.websocketclient.game.control;

import daniel.zielinski.websocketclient.websocket.WebsocketMessageSender;
import daniel.zielinski.websocketclient.websocket.model.output.OutputCommandPlayerLogin;
import daniel.zielinski.websocketclient.websocket.model.output.WebSocketOutputCommandPlayerLogin;
import daniel.zielinski.websocketclient.websocket.model.output.WebSocketOutputCommandType;
import javafx.scene.control.Button;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginFormConfig {
    private Button button;

    private final WebsocketMessageSender websocketMessageSender;
    public Button initLoginButton() {
        button = new Button();
        button.setDefaultButton(true);
        button.setText("Login");

        WebSocketOutputCommandPlayerLogin webSocketOutputCommandPlayerLogin = WebSocketOutputCommandPlayerLogin.builder()
                .actionName(WebSocketOutputCommandType.PLAYER_LOGIN.name())
                .data(OutputCommandPlayerLogin.builder().username("test").password("test").build())
                .build();
        button.setOnAction(actionEvent -> websocketMessageSender.send(webSocketOutputCommandPlayerLogin));
        return button;
    }

    public void hideLoginButton() {
        button.setVisible(false);
    }


}
