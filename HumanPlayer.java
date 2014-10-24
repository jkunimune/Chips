import java.util.Scanner;



public class HumanPlayer extends ChipsPlayer
{
  Scanner scan = new Scanner(System.in);
  
  
  
  public HumanPlayer()
  {
    System.out.println("Hello.  I will be your computer interface for today.  What is your name?");
    name = scan.nextLine();
  }
  
  
  
  public int play(int total, int max)
  {
    System.out.println("It looks like there are "+total+" pieces left, and you can take from 1 to "+max+".\nHow many will you take?");
    return scan.nextInt();
  }
}