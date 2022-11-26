package redplayer1.rp1.Commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;

public class TestCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            Location startLoc = player.getLocation();

            FallingBlock block1 = startLoc.getWorld().spawnFallingBlock(startLoc, Material.COBBLESTONE.createBlockData());
            block1.setGravity(false);
            block1.setHurtEntities(true);
            block1.setGlowing(true);
            block1.setGlowing(true);
            block1.setRotation(50, 90);
            block1.setPersistent(true);
            block1.setDropItem(false);

            ArmorStand stand = startLoc.getWorld().spawn(startLoc,ArmorStand.class);

            return true;
        }
        return false;
    }
}
