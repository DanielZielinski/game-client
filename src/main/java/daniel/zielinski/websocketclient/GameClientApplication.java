package daniel.zielinski.websocketclient;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import daniel.zielinski.websocketclient.game.control.GameConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class GameClientApplication extends GameApplication {

    private ConfigurableApplicationContext springContext;

    @Autowired
    GameConfig gameConfig;

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
        gameConfig.game();
    }

    @Override
    protected void initInput() {
        gameConfig.initControllerSettings();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

