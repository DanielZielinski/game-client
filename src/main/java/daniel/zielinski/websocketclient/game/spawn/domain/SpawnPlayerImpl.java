package daniel.zielinski.websocketclient.game.spawn.domain;

import com.almasb.fxgl.entity.Entity;
import org.springframework.stereotype.Service;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppHeight;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppWidth;
import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

@Service
class SpawnPlayerImpl implements SpawnPlayer {

    @Override
    public Entity spawnPlayer() {
        return spawn("player", getAppWidth() / 2 - 15, getAppHeight() / 2 - 15);
    }
}
