package net.cubespace.geSuitPortals.tasks;

import net.cubespace.geSuitPortals.geSuitPortals;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.ByteArrayOutputStream;
import java.util.Collection;

public class PluginMessageTask extends BukkitRunnable {
    private final ByteArrayOutputStream bytes;

    public PluginMessageTask(ByteArrayOutputStream bytes) {
        this.bytes = bytes;
    }

    public void run() {
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        if (onlinePlayers.isEmpty()) {
            geSuitPortals.INSTANCE.getLogger().info("Tried to send a pluginMessage with an empty server. Cancelling.");
        } else {
            onlinePlayers.iterator().next().sendPluginMessage(geSuitPortals.INSTANCE, "geSuitBans", bytes.toByteArray());
        }
    }
}
