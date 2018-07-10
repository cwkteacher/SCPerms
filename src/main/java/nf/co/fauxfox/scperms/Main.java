package nf.co.fauxfox.scperms;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    @Override
    public void onDisable() {
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if(!p.hasPermission("scriptcraft.evaluate") || !p.hasPermission("scriptcraft.*")) {
            p.addAttachment(getServer().getPluginManager().getPlugin("scriptcraft")).setPermission("scriptcraft.*",true);
        }
    }

}