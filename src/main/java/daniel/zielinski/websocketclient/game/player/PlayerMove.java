package daniel.zielinski.websocketclient.game.player;

import daniel.zielinski.websocketclient.websocket.model.input.InputCommandPlayerMove;

public interface PlayerMove {

    void move (InputCommandPlayerMove inputCommandPlayerMove);
}
