public class ChipsPlayer
{
  public String name;
  private boolean lost = false;
  
  
  
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
}