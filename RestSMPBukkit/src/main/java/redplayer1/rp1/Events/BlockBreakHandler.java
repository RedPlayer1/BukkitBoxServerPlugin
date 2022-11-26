package redplayer1.rp1.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import redplayer1.rp1.BSP.BoxPlayer;

public class BlockBreakHandler implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        BoxPlayer bp = BoxPlayer.getBoxPlayer(e.getPlayer().getUniqueId().toString());
        e.setDropItems(false);
        if(BoxPlayer.getMinableBlocks().contains(e.getBlock().getType())){
            bp.getBackpack().addItem(1,e.getBlock().getType());
        } else if (!bp.getPlayer().isOp()) {
            e.setCancelled(true);
        }
    }
}
