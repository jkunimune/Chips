public class OneFifthPlayer extends ChipsPlayer
{
  public OneFifthPlayer()
  {
    name = "Mr. Fifth";
  }
  
  
  
  public int play(int total, int max)
  {
    if (total <= max)
      return total;
    else if (total - total*4/5 - 1 <= max && total - total*4/5 - 1 >= 1)
      return total - total*4/5 - 1;
    else
      return max;
  }
}