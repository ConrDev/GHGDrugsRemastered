package nl.skelic.drugs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Util {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	Util(Main pluginInstance) {
		plugin = pluginInstance;
	}
	
	public void saveYML(File file, YamlConfiguration config) {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveFile(FileConfiguration config, File file) {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
