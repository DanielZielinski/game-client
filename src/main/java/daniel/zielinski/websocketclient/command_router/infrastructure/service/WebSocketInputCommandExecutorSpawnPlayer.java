package daniel.zielinski.websocketclient.command_router.infrastructure.service;


import daniel.zielinski.websocketclient.command_router.domain.WebSocketInputCommandExecutor;
import daniel.zielinski.websocketclient.game.model.Player;
import daniel.zielinski.websocketclient.game.player.PlayerCache;
import daniel.zielinski.websocketclient.game.spawn.domain.SpawnFacade;
import daniel.zielinski.websocketclient.shared.model.input.WebSocketInputCommandSpawnPlayer;
import daniel.zielinski.websocketclient.shared.model.input.WebSocketInputCommandType;
import javafx.application.Platform;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebSocketInputCommandExecutorSpawnPlayer implements WebSocketInputCommandExecutor<WebSocketInputCommandSpawnPlayer> {

    private final PlayerCache playerCache;

    private final SpawnFacade spawnFacade;

    @Override
    public void execute(WebSocketInputCommandSpawnPlayer command, WebSocketSession session) {


        Platform.runLater(() -> {

            Player player = Player.builder()
                    .playerEntity(spawnFacade.spawnPlayer())
                    .sessionId(command.getData().getSessionId())
                    .build();

            playerCache.addPlayer(player);

        });
    }

    @Override
    public boolean find(String webSocketInputCommandType) {
        return webSocketInputCommandType.equals(WebSocketInputCommandType.SPAWN_PLAYER.name());
    }
}
