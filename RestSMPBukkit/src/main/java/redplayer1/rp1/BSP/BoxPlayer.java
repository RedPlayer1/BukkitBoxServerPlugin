package redplayer1.rp1.BSP;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class BoxPlayer {
    static Map<String,BoxPlayer> playerMap = new HashMap<>();
    Player player;
    Backpack backpack;

    public BoxPlayer(Player player){
        this.player = player;
        this.backpack = new Backpack();
    }
    public BoxPlayer(Player player, Backpack backpack){
        this.player = player;
        this.backpack = backpack;
    }
    public static void registerPlayer(String uuid,BoxPlayer bp){
        playerMap.put(uuid, bp);
    }
    public static void registerPlayer(Player player){
        registerPlayer(player.getUniqueId().toString(),new BoxPlayer(player));
    }
    public static void unregisterPlayer(String uuid){
        playerMap.remove(uuid);
    }
    public BoxPlayer getBoxPlayer(Player p){
        return playerMap.get(p.getUniqueId().toString());
    }
    public static BoxPlayer getBoxPlayer(String uuid){
        return playerMap.get(uuid);
    }
    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
}
