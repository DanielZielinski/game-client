package daniel.zielinski.websocketclient.game.control;

import daniel.zielinski.websocketclient.websocket.WebsocketMessageSender;
import daniel.zielinski.websocketclient.websocket.model.output.OutputCommandPlayerLogin;
import daniel.zielinski.websocketclient.websocket.model.output.WebSocketOutputCommandPlayerLogin;
import daniel.zielinski.websocketclient.websocket.model.output.WebSocketOutputCommandType;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginFormConfig {
    private VBox vbox;
    private final WebsocketMessageSender websocketMessageSender;

    public Node initLoginForm() {

        TextField usernameInput = new TextField();
        usernameInput.setPromptText("username");

        TextField passwordInput = new TextField();
        passwordInput.setPromptText("password");

        Button button = new Button();
        button.setDefaultButton(true);
        button.setText("Login");

        vbox = new VBox();
        vbox.getChildren().addAll(usernameInput, passwordInput, button);
        vbox.setSpacing(10);

        button.setOnAction(actionEvent ->
                websocketMessageSender.send(buildCommandPlayerLogin(usernameInput.getText(), passwordInput.getText())));

        return vbox;
    }

    public void hideLoginButton() {
        vbox.setVisible(false);
    }


    private WebSocketOutputCommandPlayerLogin buildCommandPlayerLogin(String username, String password) {
        return WebSocketOutputCommandPlayerLogin.builder()
                .actionName(WebSocketOutputCommandType.PLAYER_LOGIN.name())
                .data(OutputCommandPlayerLogin.builder()
                        .username(username)
                        .password(password)
                        .build())
                .build();
    }

}
