package artdev.nengine;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class App extends JavaPlugin
{
    public static JavaPlugin instance;
    @Override
    public void onEnable(){
        instance = this;
        this.getCommand("nanjo").setExecutor(new CommandNanjo());
        getServer().getPluginManager().registerEvents(new TListener(), this);
        getLogger().info("NEngine enable.");
    }

    @Override
    public void onDisable(){
        getLogger().info("NEngine disable.");
    }
}

class CommandNanjo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage("Hello.");
        return false;
    }
}
