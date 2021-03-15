package me.royalenoob.doubledrops;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		// Plugin startup logic
		System.out.println("=== WAFFLE is stupid 🐶 ====!");
		System.out.println("=== JOSHUA trash our toilet again 💩 💣 🚽 ====!");
		getServer().getPluginManager().registerEvents(new BreakBlock(), this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
