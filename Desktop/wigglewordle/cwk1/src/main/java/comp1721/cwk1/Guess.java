package comp1721.cwk1;

import java.util.Scanner;

// for representing a single guess in a game of wordle
public class Guess {
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);
  // rest variables in field
  private int guessNumber;
  private String chosenWord;

  // TODO: Implement constructor with int parameter
  // num => guess number
  public Guess(int num){
    if (num<1 || num > 6) {
      throw new comp1721.cwk1.GameException("Invalid number");
    }
    this.guessNumber = num;
  }

  // TODO: Implement constructor with int and String parameters
  public Guess(int num, String word){
    this.guessNumber = num;
    this.chosenWord = word.toUpperCase();
    // checking consist of 5 alphabetic chars
    boolean result = chosenWord.matches("[A-Z]+");
    if (chosenWord.length() > 5 && result == false ){
      throw new comp1721.cwk1.GameException("Invaild way");
    }

  }

  // TODO: Implement getGuessNumber(), returning an int
  public int getGuessNumber(){
    return guessNumber;
  }

  // TODO: Implement getChosenWord(), returning a String
  public String getChosenWord() {
    return chosenWord;
  }

  // TODO: Implement readFromPlayer()
  public void readFromPlayer(){

    this.chosenWord = INPUT.toString();
  }

  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String target){
    // green or yellow or white
    for (int i=0; i< target.length(); i++){
      if (target.charAt(i) == chosenWord.charAt(i)){
        System.out.format("\033[30;102m" + chosenWord.charAt(i) + "\033[0m");
      } else if (chosenWord.charAt(i) != target.charAt(i)
          && chosenWord.indexOf(target.charAt(i)) != -1){
        System.out.format("\033[30;103m" + chosenWord.charAt(i) + "\033[0m");
      } else {
        System.out.format("\033[30;107m" + chosenWord.charAt(i) + "\033[0m");
      }
    }
    return chosenWord;
  }
  // TODO: Implement matches(), giving it a String parameter and boolean return type
  // returns true if the player's chosen word matches the target, false if it doesn't match
  public boolean matches(String target){
    if (this.chosenWord == target){
      return true;
    }
    else
      return false;
  }
}
