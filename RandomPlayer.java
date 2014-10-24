public class RandomPlayer extends ChipsPlayer
{
  public RandomPlayer()
  {
    name = "Randomax";
  }
  
  
  
  public int play(int total, int max)
  {
    if (total <= max)
      return total;
    else
      return (int)(Math.random()*max+1);
  }
}