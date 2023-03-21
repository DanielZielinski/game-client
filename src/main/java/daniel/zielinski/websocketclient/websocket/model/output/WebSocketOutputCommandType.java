package daniel.zielinski.websocketclient.websocket.model.output;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WebSocketOutputCommandType {

    PLAYER_LOGIN("player_login"),
    PLAYER_MOVE("player_move");
    private final String type;

    public static WebSocketOutputCommandType fromType(String type) {
        for (WebSocketOutputCommandType actionType : WebSocketOutputCommandType.values()) {
            if (actionType.type.equals(type)) {
                return actionType;
            }
        }
        throw new IllegalArgumentException("Type code not recognized: " + type);
    }
}