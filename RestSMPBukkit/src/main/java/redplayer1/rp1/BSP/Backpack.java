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
    Map<ItemStack,Integer> materials = new HashMap<>();

    public Backpack(){
        for(Material m : BoxPlayer.getMinableBlocks()){
            addItem(m.name(),0,m);
        }
    }
    public Backpack(ItemStack[] contents){
        for(ItemStack i: contents){
            materials.put(i,i.getAmount());
        }
    }
    public Map<ItemStack, Integer> getContents(){
        return this.materials;
    }
    public ItemStack[] getContentsAsItem(){
        List<ItemStack> list = new ArrayList<>();
        for (Map.Entry<ItemStack,Integer> entry : materials.entrySet() ){
            ItemStack item = entry.getKey();
            List<String> lore = new ArrayList<>();
            lore.add("You have: "+ ChatColor.GOLD+entry.getValue());
            ItemMeta meta = item.getItemMeta();
            meta.setLore(lore);
            item.setItemMeta(meta);
            list.add(item);
        }
        return list.toArray(new ItemStack[list.size()]);
    }
    public void setContents(Map<ItemStack,Integer> input){
        this.materials = input;
    }
    public void addItem(String name, int count, ItemStack itemStack){
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        addIfExists(count,itemStack);
    }
    public void addItem(String name, int count, Material material){
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        addIfExists(count,itemStack);
    }
    public void addItem(int count, ItemStack itemStack){
        //search material list for same material and add amount to it (ignores name)
        //will add amount to first occurrence of specified material
        Material material = itemStack.getType();
        for(Map.Entry<ItemStack,Integer> i : materials.entrySet()){
            if(i.getKey().getType()==material){
                i.setValue(i.getValue()+count);
                return;
            }
        }
    }
    //same as method above except takes material instead of itemstack
    public void addItem(int count, Material material){
        for(Map.Entry<ItemStack,Integer> i : materials.entrySet()) {
            if (i.getKey().getType() == material) {
                i.setValue(i.getValue() + count);
                return;
            }
        }
    }
    private void addIfExists(int addAmount, ItemStack itemStack){
        try {
            int itemCount = materials.get(itemStack);
            materials.remove(itemStack);
            materials.put(itemStack, itemCount + addAmount);
        }catch (NullPointerException e){
            materials.put(itemStack,addAmount);
        }
    }

}
