package io.github.jeremyhu.nethergps.PathFinder;

import org.bukkit.Location;

public class Node {
    int x;
    int y;
    int index;
    public void Node(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setIndex(int index){
        this.index = index;
    }
}
