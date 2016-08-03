package com.practice.codevita;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BishopMoves {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char[][] chessBoard = new char[8][8];
        String line = in.nextLine();
        String s[] = line.split(" ");
        String row[] = s[0].split("/");
        for(int i=0; i<row.length; i++) {
            int k=0;
            for(int j=0; j<row[i].length(); j++){
                if(Character.isDigit(row[i].charAt(j))) {
                    int limit = k+Integer.parseInt(String.valueOf(row[i].charAt(j)));
                    for(int l=k; l<limit; l++, k++){
                        chessBoard[i][k] = ' ';
                    }
                }
                else {
                    chessBoard[i][k] = row[i].charAt(j);
                    k++;
                }
            }
        }
        findPossibleMoves(chessBoard, s[1].toCharArray()[0]);
    }

    static void findPossibleMoves(char[][] chessBoard, char move) {
        List<Position> bishopPosition = new ArrayList<Position>();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if ((move == 'w' && chessBoard[i][j] == 'B') || (move == 'b' && chessBoard[i][j] == 'b')){
                    bishopPosition.add(new Position(i, j));
                }
            }
        }
        if(bishopPosition.size() == 0) {
            System.out.print("[]");
            return;
        }
        List<String> possibleMoveString = new ArrayList<String>();
        for(int position=0; position<bishopPosition.size(); position++) {
            Position p = bishopPosition.get(position);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(p.getI() - i != 0 && p.getJ()-j !=0 && Math.abs(p.getI()-i) == Math.abs(p.getJ()-j)){
                        boolean pathBreaker = false;
                        if(p.getI() > i && p.getJ() > j) {
                            int tempI = p.getI();
                            int tempJ = p.getJ();
                            while(tempI != i){
                                tempI = tempI - 1;
                                tempJ = tempJ - 1;
                                if(chessBoard[tempI][tempJ] != ' '){
                                    pathBreaker = true;
                                }
                            }
                        }
                        if(p.getI() > i && p.getJ() < j) {
                            int tempI = p.getI();
                            int tempJ = p.getJ();
                            while(tempI != i){
                                tempI = tempI - 1;
                                tempJ = tempJ + 1;
                                if(chessBoard[tempI][tempJ] != ' '){
                                    pathBreaker = true;
                                }
                            }
                        }
                        if(p.getI() < i && p.getJ() > j) {
                            int tempI = p.getI();
                            int tempJ = p.getJ();
                            while(tempI != i){
                                tempI = tempI + 1;
                                tempJ = tempJ - 1;
                                if(chessBoard[tempI][tempJ] != ' '){
                                    pathBreaker = true;
                                }
                            }
                        }
                        if(p.getI() < i && p.getJ() < j) {
                            int tempI = p.getI();
                            int tempJ = p.getJ();
                            while(tempI != i){
                                tempI = tempI + 1;
                                tempJ = tempJ + 1;
                                if(chessBoard[tempI][tempJ] != ' '){
                                    pathBreaker = true;
                                }
                            }
                        }
                        if(pathBreaker){
                            continue;
                        }
                        possibleMoveString.add(Character.toString((char)(p.getJ()+97)) + String.valueOf(8-p.getI())
                                    + Character.toString((char) (j+97)) + String.valueOf(8-i));
                    }
                }
            }
        }
        System.out.print(possibleMoveString.toString());
    }
}

class Position{
    private int i;

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    private int j;
    public Position(int i, int j){
        this.i = i;
        this.j = j;
    }
}