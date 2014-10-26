public class ChipTournamentDriver
{
  public static ChipsPlayer[] lineup = {new DivisionPlayer(), new OneFourth(), new OneFifthPlayer(), new OnebyOnePlayer(), new NimPlayer(), new LogarithmicPlayer(), new RandomPlayer()}; // declares and initializes an array of players
  
  
  public static void main(String[] args)
  {
    for (int i = 0; i < lineup.length; i ++) // Automatically sets names to Player 1, Player 2, etc. if no custom name is given in the class
      lineup[i].setName("Player "+(i+1));
    
    System.out.println("Ladies and gentlemen: let's get ready to rumbllllllllle!\nWelcome to the AP Comp Sci Chips Tournament!\n");
    
    int contender = -1; // memorizes one player class index
    int t = 0;
    while (!winner()) // cycles through the lineup until only one winner left (see winner method)
    {
      if (lineup[t%lineup.length].playing()) // skips ones that have already lost
      {
        if (contender > -1) // if an index is saved in contender, then that class battles whoever is next in line
        {
          battle(contender, t%lineup.length); // see battle method
          contender = -1; // tells next while loop that it needs to get two more contenders for the next battle
        }
        else
          contender = t%lineup.length; // if contender is -1, there is no contender waiting, so the net guy fills that slot
      }
      t ++;
    }
    
    for (int i = 0; i < lineup.length; i ++) // runs through lineup to see who winner is
      if (lineup[i].playing())
        System.out.println("And the victor is "+lineup[i].name()+"!"); // Congratulates them
  }
  
  
  public static boolean winner()
  {
    int x = 0;
    for (int i = 0; i < lineup.length; i ++) // count number of players still playing
      if (lineup[i].playing())
        x ++;
    return x == 1; // and return whether there is only one left
  }


  public static void battle(int index1, int index2)
  {
    int index1wins = 0;
    
    for (int round = 0; round < 100; round ++) // run 200 games
    {
      int pile = (round/2)+2; // each one will start with 2 - ??? pieces (use int math to make it go 2, 2, 3, 3, 4, 4, etc.
      boolean turn = round%2 > 0; // who goes first will alternate
      double move1 = pile/2-.5; // the last moves will be initialized such that the starting max is one less than the pile
      double move2 = pile/2-.5;
      
      while (pile > 0)
      {
        if (turn) // if player 1's turn
        {
          move1 = lineup[index1].play(pile, (int)(move2*2)); // take player 1's move
          if (move1 < 1 || move1 > move2*2) // check for legality
          {
            pile = 0; // if illegal move, make player 2 automatically win
            turn = !turn;
            System.out.println(lineup[index1].name+" has forfeit the game!");
          }
          pile -= move1; // otherwise, take according number out of the pile
        }
        
        else // if player 2's turn, same thing but opposite
        {
          move2 = lineup[index2].play(pile, (int)(move1*2));
          if (move2 < 1 || move2 > move1*2)
          {
            pile = 0;
            turn = !turn;
            System.out.println(lineup[index2].name+" has forfeit a game!");
          }
          pile -= move2;
        }
        
        turn = !turn; // switch turn
      }
      
      if (!turn) // change score based on who won
        index1wins ++;
    }
    
    System.out.print(lineup[index1].name()+" won "+index1wins+" time");
    if (index1wins != 1) // state score
      System.out.print("s");
    System.out.print(", and "+lineup[index2].name()+" won "+(100-index1wins)+" time");
    if (index1wins != 99)
      System.out.print("s"); // be grammatically correct
    System.out.print(".  ");
    if (index1wins > 50)
    {
      System.out.println(lineup[index1].name()+" wins!\n"); // state who won
      lineup[index2].loss(); // take loser out of running
    }
    else if (index1wins < 50)
    {
      System.out.println(lineup[index2].name()+" wins!\n");
      lineup[index1].loss();
    }
    else
    {
      System.out.print("It's a perfect tie!  "); // if tie
      if (Math.random()<.5)                      // flip a coin
      {
        System.out.println("I'm giving it to "+lineup[index1].name()+".");
        lineup[index2].loss();
      }
      else
      {
        System.out.println("I'm giving it to "+lineup[index2].name()+".");
        lineup[index1].loss();
      }
    }
  }
}