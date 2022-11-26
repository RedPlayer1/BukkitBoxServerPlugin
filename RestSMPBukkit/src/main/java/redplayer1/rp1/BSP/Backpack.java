package redplayer1.rp1.BSP;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Backpack {
    Map<Integer,ItemStack> materials = new HashMap<>();

    public Backpack(){
        ItemStack target = new ItemStack(Material.OAK_LOG);
        target.getItemMeta().setDisplayName("Oak Log Example");
        materials.put(1,target);
    }
    public Backpack(ItemStack[] contents){
        for(ItemStack i: contents){
            materials.put(i.getAmount(),i);
        }
    }
    public Map<Integer, ItemStack> getContents(){
        return this.materials;
    }
    public ItemStack[] getContentsAsItem(){
        List<ItemStack> list = new ArrayList<>();
        for (Map.Entry<Integer,ItemStack> entry : materials.entrySet() ){
            ItemStack item = entry.getValue();
            List<String> lore = new ArrayList<>();
            lore.add("You have: "+ ChatColor.GOLD+entry.getKey().toString());
            ItemMeta meta = item.getItemMeta();
            meta.setLore(lore);
            item.setItemMeta(meta);
            list.add(item);
        }
        return list.toArray(new ItemStack[list.size()]);
    }
    public void setContents(Map<Integer,ItemStack> input){
        this.materials = input;
    }
    public void addItem(ItemStack itemStack){
        materials.put(itemStack.getAmount(),itemStack);
    }
    public void addItem(String name, int count, ItemStack itemStack){
        itemStack.setAmount(count);
        materials.put(itemStack.getAmount(), itemStack);
    }
    public void addItem(String name, ItemStack itemStack){
        materials.put(itemStack.getAmount(), itemStack);
    }
    public void addItem(String name, int count, Material material){
        ItemStack itemStack = new ItemStack(material,count);
        addItem(itemStack);
    }

}
