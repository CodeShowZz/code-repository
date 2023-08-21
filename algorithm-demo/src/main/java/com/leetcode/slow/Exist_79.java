package com.leetcode.slow;

/**
 * @description:
 * @author: Linhuang
 * @date: 2023-06-30 16:30
 */
public class Exist_79 {

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        char [] chars = word.toCharArray();
        boolean [][] visited = new boolean[row][column];
        for(int i = 0;i<row;i++) {
            for(int j = 0;j< column;j++) {
                if(dfs(row,column,i,j,board,chars,visited,0)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(int row,int column ,int x, int y, char[][] board, char[] chars, boolean[][] visited, int begin) {
        //如果到末尾,且末尾单词一致,则返回true
        if (chars.length - 1 == begin) {
            return board[x][y] == chars[begin];
        }
        if(board[x][y] == chars[begin]) {
            visited[x][y] = true;
            for(int i = 0;i<directions.length;i++) {
                int newX = x + directions[i][0];
                int newY = y + directions[i][1];
                if(inArea(newX,newY,row,column) && !visited[newX][newY]) {
                    if(dfs(row,column,newX,newY,board,chars,visited,begin+1)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    public boolean inArea(int x,int y,int row,int column) {
        return x >= 0 && x < row && y>=0 && y <column;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean res = new Exist_79().exist2(board, "SEE");
        System.out.println("res:" + res);
    }


    public boolean exist2(char[][] board, String word) {
         if(board == null) {
             return false;
         }
         int row = board.length;
         int col = board[0].length;
         boolean [][]visited = new boolean[row][col];
         for(int i = 0;i<row;i++) {
             for(int j = 0 ;j <col;j++) {
                 if(dfs2(i,j,board,word,0,visited,row,col)) {
                     return true;
                 }
             }
         }
         return false;
    }

    public boolean dfs2(int x,int y,char [][] board,String word,int begin,boolean [][]visited,int row,int col){
        if(word.length() -1 == begin) {
            return word.charAt(word.length()-1) == board[x][y];
        }
        if(board[x][y] == word.charAt(begin)) {
            visited[x][y] = true;
            for(int i = 0; i < directions.length;i++) {
                int newX = x + directions[i][0];
                int newY = y + directions[i][1];
                if(isInArea(newX,newY,row,col)
                        && !visited[newX][newY]
                        && dfs2(newX,newY,board,word,begin+1,visited,row,col)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    public boolean isInArea(int x,int y,int row,int col) {
        return x >= 0 && x < row && y >=0 && y < col;
    }

















}