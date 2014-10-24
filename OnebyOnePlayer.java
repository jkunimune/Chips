public class OnebyOnePlayer extends ChipsPlayer
{
  String name = "Safe Player";
  
  
  
  public OnebyOnePlayer(String newName)
  {
    if (name.equals("Unnamed player"))
      name = newName;
  }
  
  
  
  public int play(int total, int max)
  {
    return 1;
  }
}