package daniel.zielinski.websocketclient;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import daniel.zielinski.websocketclient.config.WebSocketClientSessionManager;
import daniel.zielinski.websocketclient.game.GameEntityFactory;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;

import static com.almasb.fxgl.dsl.FXGL.getGameWorld;

public class GameClientApplication extends GameApplication {

    private ConfigurableApplicationContext springContext;

    @Autowired
    WebSocketClientSessionManager webSocketClientSessionManager;

    @Autowired
    GameEntityFactory gameEntityFactory;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(200);
        settings.setHeight(150);
        settings.setTitle("Game App");

        springContext = new SpringApplicationBuilder(WebsocketClientApplication.class)
                        .web(WebApplicationType.NONE)
                        .run();
        springContext
                .getAutowireCapableBeanFactory()
                .autowireBeanProperties(this, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(gameEntityFactory);
        Button button = new Button();
        button.setOnAction(actionEvent -> {
            try {
                webSocketClientSessionManager.getSession().sendMessage(new TextMessage("login"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        FXGL.entityBuilder()
                .at(50, 50)
                .view(button)
                .buildAndAttach();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

