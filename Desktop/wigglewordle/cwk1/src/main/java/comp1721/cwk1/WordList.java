package comp1721.cwk1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordList {
  private List<String> words = new ArrayList<>();

  // TODO: Implement constructor with a String parameter
  public WordList(String filename) throws IOException{
    Scanner fileObject = new Scanner(Paths.get(filename));
    // read lines from files, then store input on List
    while (fileObject.hasNextLine()){
      String line = fileObject.nextLine();
      words.add(line);
    }
    fileObject.close();
  }
  // TODO: Implement size() method, returning an int
  // size of the word list
  public int size(){
    return words.size();
  }

  // TODO: Implement getWord() with an int parameter, returning a String
  // A word is shosen from the list using this method, passing in an integer representing the game number
  public String getWord(int n) {
    if (n < 0 || n > words.size()) {
      throw new comp1721.cwk1.GameException("incorrect digit protocol :" + n);
    }
    return words.get(n); 
  }
}
