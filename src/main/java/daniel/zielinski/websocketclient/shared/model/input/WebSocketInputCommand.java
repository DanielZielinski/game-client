package daniel.zielinski.websocketclient.shared.model.input;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "actionName",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = WebSocketInputCommandSpawnPlayer.class, name = "SPAWN_PLAYER")
})
public interface WebSocketInputCommand<T> {
    String getActionName();
    T getData();
}

