package daniel.zielinski.websocketclient.shared.model.output;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public interface WebSocketOutputCommand {
    String getActionName();
}

