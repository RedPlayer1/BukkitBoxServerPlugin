package redplayer1.rp1.Commands;

import com.google.gson.Gson;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.bukkit.Bukkit.getServer;

public class datatest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }
        Player p = (Player) sender;
            Gson gson = new Gson();
            dataobject object = new dataobject("myname",14,true);
            String result = gson.toJson(object);
            String filename = "/"+p.getUniqueId().toString()+".json";
            Path path = Paths.get(getServer().getPluginManager().getPlugin("Rp1").getDataFolder().getPath()+filename);

            File file = null;
            try {
                try {
                    file = Files.createFile(path).toFile();
                }catch (FileAlreadyExistsException e){
                    file = path.toFile();
                }
                Files.write(path,result.getBytes());
            } catch (IOException e) {
                //throw new RuntimeException(e);
                p.sendMessage("IOE (invalid path?)");
            }
            if(file!=null){
                try {
                    String test = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8).toString();
                    String jsonString = test.substring(1,test.length()-1);
                    p.sendMessage(ChatColor.BLUE+jsonString);
                    object = gson.fromJson(jsonString, dataobject.class);
                    p.sendMessage(object.toString());
                } catch (IOException e) {
                    p.sendMessage("IOE when loading file content");
                }
            }else {
                p.sendMessage("File var = null");
            }
            return true;

    }
}
