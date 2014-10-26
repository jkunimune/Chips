public class ChipsPlayer
{
  String name;
  boolean lost = false;
  int score = 0;
  
  
  
  public ChipsPlayer()
  {
    name = "Unnamed player";
  }
  
  
  
  public int play(int total, int max)
  {
    return 1;
  }
  
  
  public void loss()
  {
    lost = true;
  }
  
  
  public void victory()
  {
    score ++;
  }
    
    
  public boolean playing()
  {
    return !lost;
  }
  
  
  public String name()
  {
    return name;
  }
  
  
  public void setName(String newName)
  {
    if (name.equals("Unnamed player"))
      name = newName;
  }
  
  
  public int score()
  {
    return score;
  }
}