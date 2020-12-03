package day3;

import day3.model.Slope;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {

    public static final char TREE = '#';

    public static void main(String[] args) throws FileNotFoundException {
        List <String> map = initializeMap();
        System.out.println(countTrees(map, new Slope(3)));
        System.out.println(
                countTrees(map, new Slope(1)) *
                countTrees(map, new Slope(3)) *
                countTrees(map, new Slope(5)) *
                countTrees(map, new Slope(7)) *
                countTrees(map, new Slope(1, 2))
        );
    }

    private static int countTrees(List<String> map, Slope slope) {
        int treeCount = 0;
        int mapHeight = map.size();
        int mapWidth = map.get(0).length();

        while(!endOfMap(slope, mapHeight)){
            if (getCurrentField(map, slope, mapWidth) == TREE){
                treeCount++;
            }
            slope.move();
        }

        return treeCount;
    }

    private static boolean endOfMap(Slope slope, int mapHeight) {
        return slope.getPositionY() >= mapHeight;
    }

    private static char getCurrentField(List<String> map, Slope slope, int mapWidth) {
        return map.get(slope.getPositionY()).charAt(slope.getPositionX() % mapWidth);
    }

    private static List<String> initializeMap() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input/day3.txt"));
        ArrayList<String> map = new ArrayList<>();
        while(scanner.hasNext()){
            map.add(scanner.next());
        }
        return map;
    }


}


