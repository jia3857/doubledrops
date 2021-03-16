package me.royalenoob.doubledrops;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

import java.util.Random;

public class EggsThrownListener implements Listener {
	ListenersRegisterMain plugin;
	public static boolean isHatching = true;

	public EggsThrownListener(ListenersRegisterMain instance) {
		plugin = instance;
	}

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onEggThrow(final PlayerEggThrowEvent event) {
		final Player player = event.getPlayer();
	}

	@EventHandler
	public void teleport(PlayerEggThrowEvent e) {
		Player player = e.getPlayer();

		Random randomNum = new Random();
		String entity;

		int chance = randomNum.nextInt(9) + 1;

		//player.sendMessage("You shouldn't waste food " + player.getName() + "!");

		boolean answer = e.isHatching();

		if(chance == 1) {
			e.setHatchingType(EntityType.COW);
			entity = "cow!";
		}
		else if(chance == 2) {
			e.setHatchingType(EntityType.BAT);
			entity = "bat!";
		}
		else if(chance == 3) {
			e.setHatchingType(EntityType.GIANT);
			entity = "giant!";
		}
		else if(chance == 4) {
			e.setHatchingType(EntityType.ENDER_CRYSTAL);
			entity = "ender crystal?";
		}
		else if(chance == 5) {
			e.setHatchingType(EntityType.PRIMED_TNT);
			entity = "primed tnt?";
		}
		else if(chance == 6) {
			e.setHatchingType(EntityType.SHEEP);
			entity = "sheep!";
		}
		else if(chance == 7) {
			e.setHatchingType(EntityType.OCELOT);
			entity = "ocelot!";
		}
		else if(chance == 8) {
			e.setHatchingType(EntityType.ZOMBIE);
			entity = "zombie...";
		}
		else {
			e.setHatchingType(EntityType.WOLF);
			entity = "wolf!";
		}

		if(answer == true) {
			player.sendMessage("Congratulations! You spawned a " + entity);
		}

	}
}
