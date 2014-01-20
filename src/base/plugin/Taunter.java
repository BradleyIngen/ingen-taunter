package base.plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

/**
 * @author 2mac
 */
public class Taunter extends JavaPlugin
{
    private ArrayList<String> taunts;

    Taunter()
    {
        // todo: read YML config for taunt list
    }

    private void sendLoginTaunt(Player x)
    {
        //stuff
    }

    private class PlayerLoginListener implements Listener
    {
        private Taunter plugin;
        PlayerLoginListener(Taunter t)
        {
            plugin = t;
        }

        @EventHandler
        public void onPlayerLogin(PlayerLoginEvent event)
        {

        }
    }
}
