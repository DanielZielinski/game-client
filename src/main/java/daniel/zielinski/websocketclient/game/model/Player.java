package daniel.zielinski.websocketclient.game.model;

import com.almasb.fxgl.entity.Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {

    private String sessionId;
    private Entity playerEntity;
}
