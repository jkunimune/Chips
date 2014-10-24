public class ChipTournament
{
  public static ChipsPlayer[] lineup = {new OneThirdPlayer(), new OnebyOnePlayer()}; // declares and initializes an array of players
  
  
  public static void main(String[] args)
  {
    for (int i = 0; i < lineup.length; i ++) // Automatically
      lineup[i].setName("Player "+(i+1));
    
    System.out.println("Ladies and gentlemen: let's get ready to rumbllllllllle!\nWelcome to the AP Comp Sci Chips Tournament!\n");
    
    int index1 = 0;
    int t = 0;
    while (!winner())
    {
      if (index1 > 0)
      {
        battle(index1, t%lineup.length);
        index1 = 0;
      }
      else
        index1 = t%lineup.length;
      t ++;
    }
    
    for (int i = 0; i < lineup.length; i ++)
      if (lineup[i].playing())
        System.out.println("And the victor is "+lineup[i].name()+"!");
  }
  
  
  public static boolean winner()
  {
    int x = 0;
    for (int i = 0; i < lineup.length; i ++)
      if (lineup[i].playing())
        x ++;
    return x <= 1;
  }


  public static void battle(int index1, int index2)
  {
    int index1wins = 0;
    for (int round = 0; round < 100; round ++)
    {
      int pile = (round/2)*5+5;
      boolean turn = round%2 > 0;
      double move1 = pile/2-.5;
      double move2 = pile/2-.5;
      
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