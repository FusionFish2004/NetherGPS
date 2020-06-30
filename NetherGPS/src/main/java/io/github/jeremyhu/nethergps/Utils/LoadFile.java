package io.github.jeremyhu.nethergps.Utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LoadFile {
    public static FileConfiguration load(File file){
        if(!(file.exists())){
            try{
                file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return YamlConfiguration.loadConfiguration(file);
    }
}
