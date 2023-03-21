package daniel.zielinski.websocketclient;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import daniel.zielinski.websocketclient.game.config.GameEntityFactory;
import daniel.zielinski.websocketclient.websocket.WebsocketMessageSender;
import daniel.zielinski.websocketclient.websocket.model.output.*;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import static com.almasb.fxgl.dsl.FXGL.getGameWorld;
import static daniel.zielinski.websocketclient.websocket.model.output.WebSocketOutputCommandType.PLAYER_MOVE;

public class GameClientApplication extends GameApplication {

    private ConfigurableApplicationContext springContext;
    @Autowired
    GameEntityFactory gameEntityFactory;

    @Autowired
    WebsocketMessageSender websocketMessageSender;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(500);
        settings.setHeight(500);
        settings.setTitle("Game App");

        springContext = new SpringApplicationBuilder(WebsocketClientApplication.class)
                .web(WebApplicationType.NONE)
                .run();

        springContext.getAutowireCapableBeanFactory()
                .autowireBeanProperties(this, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(gameEntityFactory);
        Button button = new Button();
        button.setDefaultButton(true);
        button.setText("Login");

        WebSocketOutputCommandPlayerLogin webSocketOutputCommandPlayerLogin = WebSocketOutputCommandPlayerLogin.builder()
                .actionName(WebSocketOutputCommandType.PLAYER_LOGIN.name())
                .data(OutputCommandPlayerLogin.builder().username("test").password("test").build())
                .build();

        button.setOnAction(actionEvent -> websocketMessageSender.send(webSocketOutputCommandPlayerLogin));
        FXGL.entityBuilder()
                .at(50, 50)
                .view(button)
                .buildAndAttach();
    }

    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.W, () -> {
            WebSocketOutputCommandPlayerMove playerMove = WebSocketOutputCommandPlayerMove.builder()
                    .actionName(PLAYER_MOVE.name()).data(OutputCommandPlayerMove.builder()
                            .direction("Y")
                            .distance(-5)
                            .build())
                    .build();
            websocketMessageSender.send(playerMove);
        });

        FXGL.onKey(KeyCode.S, () -> {
            WebSocketOutputCommandPlayerMove playerMove = WebSocketOutputCommandPlayerMove.builder()
                    .actionName(PLAYER_MOVE.name()).data(OutputCommandPlayerMove.builder()
                            .direction("Y")
                            .distance(5)
                            .build())
                    .build();
            websocketMessageSender.send(playerMove);
        });

        FXGL.onKey(KeyCode.A, () -> {
            WebSocketOutputCommandPlayerMove playerMove = WebSocketOutputCommandPlayerMove.builder()
                    .actionName(PLAYER_MOVE.name()).data(OutputCommandPlayerMove.builder()
                            .direction("X")
                            .distance(-5)
                            .build())
                    .build();
            websocketMessageSender.send(playerMove);
        });

        FXGL.onKey(KeyCode.D, () -> {
            WebSocketOutputCommandPlayerMove playerMove = WebSocketOutputCommandPlayerMove.builder()
                    .actionName(PLAYER_MOVE.name()).data(OutputCommandPlayerMove.builder()
                            .direction("X")
                            .distance(5)
                            .build())
                    .build();
            websocketMessageSender.send(playerMove);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

