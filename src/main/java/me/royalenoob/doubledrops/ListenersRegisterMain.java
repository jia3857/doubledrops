package me.royalenoob.doubledrops;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public final class ListenersRegisterMain extends JavaPlugin {

	private static Logger LOGGER = Logger.getLogger(ListenersRegisterMain.class.getName());

	@Override
	public void onEnable() {
		// Plugin startup logic

		LOGGER.info("=== WAFFLE is stupid 🐶 ====!");
		getServer().getPluginManager().registerEvents(new BlockBrokenListener(), this);
		//getServer().getPluginManager().registerEvents(new BlockBrokenListener(this), this);
		getServer().getPluginManager().registerEvents(new EggsThrownListener(this), this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
