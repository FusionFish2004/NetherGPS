package io.github.jeremyhu.nethergps;


import io.github.jeremyhu.nethergps.PathFinder.Vertex;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.github.jeremyhu.nethergps.Utils.LoadFile.load;


public class Main extends JavaPlugin {
    List<Vertex> vertexes = new ArrayList<Vertex>();

    @Override
    public void onEnable(){
        this.getLogger().info("Initializing the plugin...");
        File file = new File(getDataFolder(),"transportation.yml");
        FileConfiguration vertexesconfig = load(file);
        List<Integer> list = (List<Integer>)vertexesconfig.getList("vertexs");
        int x;
        int y;
        int type;
        String name;
        String index;
        for(int i : list){
            index = "vertex" + String.valueOf(i);
            x = vertexesconfig.getInt(index + ".x");
            y = vertexesconfig.getInt(index + ".y");
            type = vertexesconfig.getInt(index + ".type");
            name = vertexesconfig.getString(index + ".name");
            Vertex v = new Vertex(x,y,type,name);
            vertexes.add(v);
        }
        this.getLogger().info(vertexes.get(1).toString());
    }

}
