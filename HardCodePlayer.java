public class HardCodePlayer extends ChipsPlayer
{
  public HardCodePlayer()
  {
    name = "Planner";
  }
  
  
  
  public int play(int total, int max)
  {
    if (total <= max)
      return total;
    
    switch(total)
    {
      case 1:
        return 1;
      case 2:
        return 2;
      case 3:
        return 1;
      case 4:
        return 1;
      case 5:
        return 1;
      case 6:
        return 1;
      case 7:
        return 2;
      case 8:
        return 1;
      case 9:
        return 1;
      case 10:
        return 2;
      default:
        if (total - total*2/3 - 1 <= max && total - total*2/3 - 1 >= 1)
          return total - total*2/3 - 1;
        else
          return max;
    }
  }
}