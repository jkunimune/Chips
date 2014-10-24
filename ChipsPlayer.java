public class ChipsPlayer
{
  private String name = "Unnamed player";
  private boolean lost = false;
  
  
  
  public ChipsPlayer()
  {
  }
  
  
  public ChipsPlayer(String newName)
  {
    if (name.equals("Unnamed player"))
      name = newName;
  }
  
  
  
  public int play(int total, int max)
  {
    return 1;
  }
  
  
  public void loss()
  {
    lost = true;
  }
    
    
  public boolean playing()
  {
    return !lost;
  }
  
  
  public String name()
  {
    return name;
  }
}