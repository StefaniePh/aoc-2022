import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;

public class solutionJava {
    static int maxCalorieSum = 0;
    static int currentCalorieSum = 0;
    public static void main(String[] args){
        try {
            Files.lines(Paths.get("day-1/input/input.txt"))
                    .map(e -> e.equals("") ? null : Integer.parseInt(e))
                    .collect(Collectors.toList())
                    .forEach(solutionJava::processNextLine);
            System.out.println(maxCalorieSum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processNextLine(Integer e) {
        if(Objects.isNull(e)){
            maxCalorieSum = Integer.max(maxCalorieSum, currentCalorieSum);
            currentCalorieSum = 0;
        } else {
            currentCalorieSum += e;
        }
    }
}
