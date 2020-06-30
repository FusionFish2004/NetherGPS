package io.github.jeremyhu.nethergps.PathFinder;

import com.google.gson.JsonObject;
import org.json.simple.JSONObject;


public class Vertex {
    int x;
    int y;
    int type;
    String name;

    public Vertex(int x,int y,int type,String name){
        this.x = x;
        this.y = y;
        this.type = type;
        this.name = name;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        JSONObject object = new JSONObject();
        object.put("x",this.x);
        object.put("y",this.y);
        object.put("type",this.type);
        object.put("name",this.name);
        return object.toString();
    }
}
