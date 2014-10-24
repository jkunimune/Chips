public class OnebyOnePlayer extends ChipsPlayer
{
  public OnebyOnePlayer()
  {
    name = "Safe player";
  }
  
  
  
  public int play(int total, int max)
  {
    if (total <= max)
      return total;
    return 1;
  }
}