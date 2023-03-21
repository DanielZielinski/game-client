package daniel.zielinski.websocketclient.shared.model.input;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WebSocketInputCommandType {

    SPAWN_PLAYER("spawn_player");
    private final String type;

    public static WebSocketInputCommandType fromType(String type) {
        for (WebSocketInputCommandType actionType : WebSocketInputCommandType.values()) {
            if (actionType.type.equals(type)) {
                return actionType;
            }
        }
        throw new IllegalArgumentException("Type code not recognized: " + type);
    }
}