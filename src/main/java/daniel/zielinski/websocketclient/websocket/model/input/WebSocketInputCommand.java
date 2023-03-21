package daniel.zielinski.websocketclient.websocket.model.input;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "actionName",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = WebSocketInputCommandPlayerSpawn.class, name = "PLAYER_SPAWN"),
        @JsonSubTypes.Type(value = WebSocketInputCommandPlayerMove.class, name = "PLAYER_MOVE")
})
public interface WebSocketInputCommand<T> {
    String getActionName();
    T getData();
}

