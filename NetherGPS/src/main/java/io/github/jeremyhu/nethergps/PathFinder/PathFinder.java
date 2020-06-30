package io.github.jeremyhu.nethergps.PathFinder;

import java.util.*;

public class PathFinder {
    public HashMap<Integer,List<Node>> findpath(int[][] matrix, List<Node> nodes, int src){
        for(int i = 0;i < nodes.size();i++){  //设置节点索引
            nodes.get(i).setIndex(i);
        }
        List<Node> unchecked = nodes;  //未访问过的节点list

        return null;
    }

    public static void main(String args[]){
        int[][] matrix = {{0,4,0,0,0,0,3,0,4,0,0}};
        System.out.println(getNearestNode(matrix,0));
    }

    private static int getNearestNode(int[][] matrix, int src){  //寻找最近节点
        List<Integer> distances = new ArrayList<Integer>();
        for(int j = 0;j < matrix[src].length;j++){  //遍历邻接矩阵中的一维数组
            distances.add(matrix[src][j]);  //将一维数组中所有元素存入list中
        }
        List<Integer> sort = new ArrayList<Integer>();
        for(int i : distances){  //去除距离为0的节点并存入新list
            if(i != 0){
                sort.add(i);
            }
        }
        if(sort.size()==0){return -1;}  //该节点没有与其连接的节点
        sort.sort(Comparator.naturalOrder());  //升序排列，获得最短距离
        int shortest = sort.get(0);
        for(int i = 0;i < distances.size();i++){  //遍历list，取出与最短距离对应的节点索引
            if(shortest == distances.get(i)){
                return i;
            }
        }
        return -1;
    }
}
