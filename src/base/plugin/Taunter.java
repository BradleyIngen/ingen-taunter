package base.plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author 2mac
 */
public class Taunter extends JavaPlugin
{
    private ArrayList<String> taunts;
    private File folder, login, death;
    private boolean[] flags = {false,false};

    Taunter()
    {
        folder = new File("plugins" + File.separator + "Taunter");
        login = new File(folder, "loginmessages.yml");
        death = new File(folder, "deathmessages.yml");
        // todo: read YML config for taunt list
    }

    public int getRandom(int bottom, int top)
    {
        Random dice = new Random();
        int dif = top - bottom;
        return bottom + dice.nextInt(dif+1);
    }

    public void onEnable()
    {
        generateDefaults();
    }

    private void generateDefaults()
    {

        // make working directory
        if (!folder.exists())
        {
            try
            {
                folder.mkdir();
            }
            catch (Exception e)
            {
                getLogger().severe("Could not create working directory for Taunter!");
                getPluginLoader().disablePlugin(this);
            }
        }

        // generate config
        if (!getConfig().get("loginmessages").equals(true) && !getConfig().get("loginmessages").equals(false))
        {
            getConfig().set("loginmessages", true);
        }
        if (!getConfig().get("deathmessages").equals(true) && !getConfig().get("deathmessages").equals(false))
        {
            getConfig().set("deathmessages", true);
        }
        saveConfig();

        // generate login messages file
        // generate death messages file
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
            if (flags[0])
            {
                event.getPlayer().sendMessage(taunts.get(getRandom(0,taunts.size())));
            }
        }
    }
}
