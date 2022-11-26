package redplayer1.rp1;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import redplayer1.rp1.BSP.BoxPlayer;
import redplayer1.rp1.Commands.TestCmd;
import redplayer1.rp1.Commands.backpack_cmd;
import redplayer1.rp1.Commands.datatest;
import redplayer1.rp1.Configz.ConfMain;
import redplayer1.rp1.Events.JoinLeave;

public final class Rp1 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        if(!(this.getServer().getOnlinePlayers().isEmpty())){
            for (Player player : this.getServer().getOnlinePlayers()) {
                BoxPlayer.registerPlayer(player);
                if(player.isOp()){
                    player.sendMessage(ChatColor.GREEN+"Plugin Reload Detected.");
                }
            }
        }


        //Register commands
        this.getCommand("test").setExecutor(new TestCmd());
        this.getCommand("datatest").setExecutor(new datatest());
        this.getCommand("backpack").setExecutor(new backpack_cmd());

        //Register event listeners
        getServer().getPluginManager().registerEvents(new JoinLeave(),this);

        //Config folder & file creation
        this.saveDefaultConfig();
        ConfMain.setFile(this.getDataFolder());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
