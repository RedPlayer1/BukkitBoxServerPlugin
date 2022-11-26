package redplayer1.rp1.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import redplayer1.rp1.BSP.BoxPlayer;

public class JoinLeave implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        BoxPlayer.registerPlayer(e.getPlayer().getUniqueId().toString(),new BoxPlayer(e.getPlayer()));
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        BoxPlayer.unregisterPlayer(e.getPlayer().getUniqueId().toString());
    }
}
