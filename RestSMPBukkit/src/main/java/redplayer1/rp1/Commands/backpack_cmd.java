package redplayer1.rp1.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import redplayer1.rp1.BSP.BoxPlayer;
public class backpack_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            return false;
        }
        Player p = (Player) sender;
        if(command.getName().equalsIgnoreCase("backpack")) {
            Inventory inv = Bukkit.createInventory(p, 54,"Backpack");
            BoxPlayer bp = BoxPlayer.getBoxPlayer(p.getUniqueId().toString());

            inv.setContents(bp.getBackpack().getContentsAsItem());
            p.openInventory(inv);
            p.sendMessage(bp.getBackpack().getContents().toString());
            return true;
        }
        return false;
    }
}
