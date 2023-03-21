package daniel.zielinski.websocketclient.game.spawn.domain;

import com.almasb.fxgl.entity.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpawnFacade {

    private final SpawnPlayer spawnPlayer;

    public Entity spawnPlayer() {
        return spawnPlayer.spawnPlayer();
    }
}
