package daniel.zielinski.websocketclient.websocket.model.output;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public interface WebSocketOutputCommand<T>{
    String getActionName();

    void setData(T data);
}

