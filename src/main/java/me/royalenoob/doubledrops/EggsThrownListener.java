package me.royalenoob.doubledrops;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
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

		Random randomNum = new Random();
		String entity;

		int chance = randomNum.nextInt(9) + 1;

		//player.sendMessage("You shouldn't waste food " + player.getName() + "!");

		boolean once = false;
		if (once) {
			EntityType[] entities = EntityType.class.getEnumConstants();
			StringBuilder sb = new StringBuilder();
			for (EntityType e : entities) {
				sb.append("-->" + e.name() + "\n");
			}
			System.out.println("Entities:\n" + sb);
			once = false;
		}
		boolean answer = event.isHatching();

		if(chance == 1) {
			event.setHatchingType(EntityType.ENDER_DRAGON);
			entity = "cow!";
		}
		else if(chance == 2) {
			event.setHatchingType(EntityType.BAT);
			entity = "bat!";
		}
		else if(chance == 3) {
			event.setHatchingType(EntityType.GIANT);
			entity = "giant!";
		}
		else if(chance == 4) {
			event.setHatchingType(EntityType.ENDER_CRYSTAL);
			entity = "ender crystal?";
		}
		else if(chance == 5) {
			event.setHatchingType(EntityType.PRIMED_TNT);
			entity = "primed tnt?";
		}
		else if(chance == 6) {
			event.setHatchingType(EntityType.SHEEP);
			entity = "sheep!";
		}
		else if(chance == 7) {
			event.setHatchingType(EntityType.OCELOT);
			entity = "ocelot!";
		}
		else if(chance == 8) {
			event.setHatchingType(EntityType.ZOMBIE);
			entity = "zombie...";
		}
		else {
			event.setHatchingType(EntityType.WOLF);
			entity = "wolf!";
		}

		if(answer == true) {
			player.sendMessage("Congratulations! You spawned a " + entity);
		}

	}
}
