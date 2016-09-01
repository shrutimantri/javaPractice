package com.practice.codevita;

import java.io.BufferedReader;
import java.util.*;

public class ContinentsAndOceans {
    static int sum=0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String filePath = in.nextLine();
        String contents = readFile(filePath);
        String[] lines = contents.split("\n");
        char[][] grid = new char[15][60];
        for (int i = 0; i < 15; i++) {
            String line = lines[i];
            for (int j = 0; j < 60; j++) {
                if(line.length() < j+1){
                    grid[i][j] = ' ';
                    continue;
                }
                grid[i][j] = line.charAt(j);
            }
        }
        numIslands(grid);
    }

    static void numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return;
        }
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<Integer> list = new ArrayList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum=0;
                if (!visited[i][j] && grid[i][j] == '#') {
                    dfs(grid, visited, i, j);
                    list.add(sum);
                    result++;
                }
            }
        }
        System.out.print("Number of continents: " + list.size());
    }

    static void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == ' ') {
            return;
        }
        grid[i][j] = grid[i][j] == 'Y' ? '1' : '0' ;
        sum = sum + Integer.parseInt(String.valueOf(grid[i][j]));
        visited[i][j] = true;
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);
        /*dfs(grid, visited, i - 1, j - 1);
        dfs(grid, visited, i + 1, j + 1);
        dfs(grid, visited, i - 1, j + 1);
        dfs(grid, visited, i + 1, j - 1);*/
    }

    static String readFile(String path) {
        String everything = null;
        try {
            java.io.FileReader fr = new java.io.FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            everything = sb.toString();
        } catch (Exception ex) {

        }
        return everything;
    }
}
