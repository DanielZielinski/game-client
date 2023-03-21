package daniel.zielinski.websocketclient.game.player;

import daniel.zielinski.websocketclient.game.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerCache {
    private List<Player> players = new ArrayList<>();


    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }
}
