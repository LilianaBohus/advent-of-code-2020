import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws IOException {
        System.out.println(findSolution(readData()));
    }

    private static int findSolution(List<Integer> numbers) {
        int result = -1;
        for (int i = 0; i < numbers.size(); i++){
            for (int j = 0; j < numbers.size(); j++){
                for(int k = 0; k < numbers.size(); k++){
                    if (numbers.get(i) + numbers.get(j) + numbers.get(k) == 2020){
                        result = numbers.get(i) * numbers.get(j) * numbers.get(k);
                    }
                }
            }
        }
        return result;
    }

    private static List<Integer> readData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/day1.txt")));
        String line;
        ArrayList<Integer> numbers = new ArrayList<>();
        while (( line = br.readLine()) != null){
            numbers.add(Integer.parseInt(line));
        }
        return numbers;
    }
}
