package comp1721.cwk1;

import java.io.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


public class Game {
  // instance variable in field
  private static int gameNumber = 0;
  private String target;
  private static LocalDate previous_date = null;
  private LocalDate current_date;

  private int counter = 1;
  private ArrayList<Guess> guesses;
  private PrintWriter pw = null;
//  private BufferedReader br = null;

  // TODO: Implement constructor with String parameter
  public Game(String filename) throws IOException {

    current_date = LocalDate.now();

    Period period = Period.between(current_date, previous_date);

    if(period.getDays() >= 1  || gameNumber==0){
      this.gameNumber++;
      WordList wObject = new WordList(filename);
      this.target = wObject.getWord(gameNumber);

    }

    previous_date = current_date;



  }
  // TODO: Implement constructor with int and String parameters
  public Game(int num, String filename) throws IOException {

  }
  // TODO: Implement play() method
  // 1.create and store Guess objects representing each guess
  // 2.check each guess, printing the string returned by the compareWith method
  public void play(){

    for(int i=0; i<6; i++) {
      Guess guess = new Guess(i);
      guesses.add(guess);
      counter++;
      guess.compareWith(this.target);

      if (counter == 1 && guess.getChosenWord() == this.target){
        System.out.println("Superb - Got it in one!");
      } else if (counter >2 && counter <5 && guess.getChosenWord() == this.target){
        System.out.println("Well done!");
      } else if (counter == 6 && guess.getChosenWord() == this.target){
        System.out.println("That was a close call!");
      } else {
        System.out.println("Nope - Better luck next time!");
      }
    }
  }
  // TODO: Implement save() method, with a String parameter
  // 1. save a summary of the game to the specified file
  //  summary of the game -> one line for each guess made
  public void save(String filename) {
//     Path path = Paths.get(filename);
//     br = Files.newBufferedReader(path);
    try {
      pw = new PrintWriter(filename);

      for(int i =0; i< 6; i++) {
        pw.println(guesses.get(i).compareWith(target));
      }
    } catch (FileNotFoundException e) {
      System.out.println("file doesn't exist");
      e.printStackTrace();
    } finally {
      if (pw != null) {
        pw.close();
      }
    }
  }
}
