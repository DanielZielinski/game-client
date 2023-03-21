package daniel.zielinski.websocketclient.shared.model.output;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WebSocketOutputCommandType {

    LOGIN("login");
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