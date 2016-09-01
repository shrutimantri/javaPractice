package com.practice.uber;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by shruti.mantri on 28/08/16.
 */
public class SheepField {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        /* Sample input
        3
        YNNY
        NYNY
        NYNN
         */

        int res;

        int _grid_size = 0;
        _grid_size = Integer.parseInt(in.nextLine());
        String[] _grid = new String[_grid_size];
        String _grid_item;
        for(int _grid_i = 0; _grid_i < _grid_size; _grid_i++) {
            try {
                _grid_item = in.nextLine();
            } catch (Exception e) {
                _grid_item = null;
            }
            _grid[_grid_i] = _grid_item;
        }

        res = Group(_grid);
        System.out.print(res);
    }
    static int sum = 0;
    static Map<String, BigInteger> permutationMap = new HashMap<>();
    static Map<BigInteger, BigInteger> tempMap = new HashMap<>();
    static int Group(String[] grid) {
        int i = grid.length!=0 ? grid[0].length() : 0;
        if(i == 0) {
            return 0;
        }
        char[][] charGrid = new char[grid.length][i];
        for(int j=0; j<grid.length; j++){
            for(int k=0; k<grid[0].length(); k++){
                charGrid[j][k] = grid[j].charAt(k);
            }
        }
        int fields = numIslands(charGrid);
        BigInteger total = BigInteger.ZERO;
        for(int l=0; l<=fields; l = l+2) {
            total = total.add(combination(new BigInteger(String.valueOf(fields)), new BigInteger(String.valueOf(l))));
        }
        return Integer.parseInt(total.mod(new BigInteger("1000000007")).toString());
    }

    static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<Integer> list = new ArrayList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum=0;
                if (!visited[i][j] && grid[i][j] == 'Y') {
                    dfs(grid, visited, i, j);
                    list.add(sum);
                    result++;
                }
            }
        }
        return result;
    }

    static void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 'N') {
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


    public static BigInteger combination(BigInteger n, BigInteger k)
    {
        if(permutationMap.containsKey(n+","+k)) {
            return permutationMap.get(n+","+k);
        }
        if(permutationMap.containsKey(n+","+(n.subtract(k)))) {
            return permutationMap.get(n+","+(n.subtract(k)));
        }
        BigInteger answer =  permutation(n).divide(permutation(k).multiply(permutation(n.subtract(k))));
        permutationMap.put(n+","+k, answer);
        return answer;
    }

    public static BigInteger permutation(BigInteger i)
    {
        if (i.compareTo(BigInteger.ONE) == 0 || i.compareTo(BigInteger.ONE) == -1)
        {
            return BigInteger.ONE;
        }
        if(tempMap.containsKey(i)){
            return tempMap.get(i);
        }
        BigInteger answer = i.multiply(permutation(i.subtract(BigInteger.ONE)));
        tempMap.put(i, answer);
        return answer;
    }

}
