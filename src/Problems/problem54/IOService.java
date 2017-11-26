package Problems.problem54;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOService {
  public List<String> readFile() {
    Path myPath = Paths.get("assets/p054_poker.txt");
    List<String> rawLines = new ArrayList<>();
    try {
      rawLines = Files.readAllLines(myPath);
    } catch (IOException ex) {
      System.out.println("READ ERROR");
    }
    return rawLines;
  }
}
