package artdev.nengine;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Lectern;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

public class TListener implements Listener {
    @EventHandler
    public void OnBlockBreak(BlockBreakEvent event){

    }
    @EventHandler
    public void OnBlockPlace(BlockPlaceEvent event){

    }
    @EventHandler
    public void OnPlayerInteract(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getHand() == EquipmentSlot.HAND){
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            Block block = event.getClickedBlock();
            if(block != null && block.getType() == Material.LECTERN
                    && item != null && item.getType() == Material.GOLDEN_AXE){
                Lectern l = (Lectern)(block.getState());
                BookMeta bookMeta = (BookMeta)l.getInventory().getItem(0).getItemMeta();
                List<String> pages = bookMeta.getPages();
                String[] content = new String[pages.size()];
                pages.toArray(content);
                player.sendMessage(content);
                event.setCancelled(true);
            }
        }
    }
}
