package nukkit.jose.track;

import cn.nukkit.Player;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerItemHeldEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.utils.TextFormat;

public class TrackEvent implements Listener {

    public TrackEvent() {
        Loader.instance.getServer().getPluginManager().registerEvents(this,Loader.instance);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onDestroySession(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        if (Loader.cache.containsKey(player.getName())) {
            if (event.getItem().getCustomName().equals(TextFormat.RED+"Remove Session") && player.getGamemode() == Player.SPECTATOR) {
                Loader.remove(player);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onDestroySessionWithQuit(PlayerQuitEvent event) {
        Loader.remove(event.getPlayer());
    }
}
