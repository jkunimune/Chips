public class ChipsBattle
{
  public static ChipsPlayer[] lineup = {new OneFourth(), new OnebyOnePlayer(), new OneThirdPlayer()};
      
  
      
  public static void main(String[] args)
  {
    final int index1 = 1;
    final int index2 = 2;
    int index1wins = 0;
    for (int round = 0; round < 100; round ++)
    {
      int pile = (round/2)*5+5;
      boolean turn = round%2 > 0;
      int move1 = (int)(pile/2-.5);
      int move2 = (int)(pile/2-.5);
      
      System.out.print("I am about to run a game with "+pile+" pieces, and ");
      if (turn) System.out.println("player 1 will go first.");
      else System.out.println("player 2 will go first.");
      
      while (pile > 0)
      {
        if (turn)
        {
          move1 = lineup[index1].play(pile, (int)(move1*2));
          if (move1 < 1 || move1 > move2*2)
          {
            pile = 0;
            turn = !turn;
          }
          pile -= move1;
        }
        
        else
        {
          move2 = lineup[index2].play(pile, (int)(move1*2));
          if (move2 < 1 || move2 > move1*2)
          {
            pile = 0;
            turn = !turn;
          }
          pile -= move2;
        }
        
        turn = !turn;
      }
      
      if (turn) System.out.println("Player 2 won, I think.");
      else System.out.println("Player 1 won, maybe.");
      
      if (!turn)
        index1wins ++;
    }
    
    System.out.print(lineup[index1].name()+" won "+index1wins+" times, and "+lineup[index2].name()+" won "+(100-index1wins)+" times.  ");
    if (index1wins > 50)
    {
      System.out.println(lineup[index1].name()+" wins!\n");
      lineup[index2].loss();
    }
    else
    {
      System.out.println(lineup[index2].name()+" wins!\n");
      lineup[index1].loss();
    }
  }
}