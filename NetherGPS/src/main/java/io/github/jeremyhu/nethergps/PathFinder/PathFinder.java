package io.github.jeremyhu.nethergps.PathFinder;

import java.util.*;

public class PathFinder {
    private static int inf = Integer.MAX_VALUE;
    private int[][] path;
    private int[][] matrix;

    public PathFinder(int[][] matrix) {
        this.matrix = matrix;
    }

    public void floyd(){  //Floyd算法
        int[][] path = new int[matrix.length][matrix.length];  //创建前驱表
        for(int i = 0;i < matrix.length;i++){  //初始化前驱表
            for (int j = 0; j < matrix.length; j++) {
                path[i][j] = j;
            }
        }
        for (int k = 0; k < matrix.length; k++) {
            for (int m = 0; m < matrix.length; m++) {
                for (int n = 0; n < matrix.length; n++) {
                    int mn = matrix[m][n];
                    int mk = matrix[m][k];
                    int kn = matrix[k][n];
                    int addedPath = (mk == inf || kn == inf)? inf : mk + kn;
                    if (mn > addedPath) {
                        //如果经过k顶点路径比原两点路径更短，将两点间权值设为更小的一个
                        matrix[m][n] = addedPath;
                        //前驱设置为经过下标为k的顶点
                        path[m][n] = path[m][k];
                    }
                }
            }
        }
        this.path = path;
    }

    public int[][] getPreTable(){
        return path;
    }

    public List<Integer> getPath(int src,int dst){  //输入起点索引与终点索引
        List<Integer> path = new ArrayList<Integer>();
        int k = this.path[src][dst];
        while(k != dst){
            path.add(k);
            k = this.path[k][dst];
        }
        path.add(dst);
        return path;
    }
}
