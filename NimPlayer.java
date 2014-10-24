public class NimPlayer extends ChipsPlayer
{
  public NimPlayer()
  {
    name = "Old Timer";
  }
  
  
  
  public int play(int total, int max)
  {
    if (total <= max)
      return total;
    
    switch (total%3)
    {
      case 1:   return 1;
      case 2:   return 2;
      default:  return 1;
    }
  }
}