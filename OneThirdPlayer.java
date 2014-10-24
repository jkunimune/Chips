public class OneThirdPlayer extends ChipsPlayer
{
  String name = "One out of Three";
  
  
  
  public OneThirdPlayer(String newName)
  {
    if (name.equals("Unnamed player"))
      name = newName;
  }
  
  
  
  public int play(int total, int max)
  {
    if (total <= max)
      return total;
    else if (total - total*2/3 - 1 <= max)
      return total - total*2/3 - 1;
    else
      return max;
  }
}