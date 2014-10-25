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
        return 1; // 1, win
      case 2:
        return 2; // 2, win
      case 3:
        return 1; // lose
      case 4:
        return 1; // 1, win
      case 5:
        return 1; // lose
      case 6:
        return 1; // 1, win
      case 7:
        return 2; // 2, win
      case 8:
        return 1; // lose
      case 9:
        return 1; // 1, win
      case 10:
        return 2; // 2, win
      case 11:
        if (max >= 3)
          return 3; // 3 if possible (if not, lose)
        else
          return 1;
      case 12:
        return 1; // 1, win
      case 13:
        return 1; // lose
      case 14:
        return 1; // 1, win
      case 15:
        return 2; // 2, win
      case 16:
        if (max >= 3)
          return 3; // 3 if possible (if not, lose)
        else
          return 1;
      case 17:
        return 1; // 1, win
      case 18:
        if (max >= 5)
          return 5; // 5 if possible (if not, lose)
        else
          return 1;
      case 19:
        return 1; // 1, win
      case 20:
        return 2; // 2, win
      default:
        if (total - total*2/3 - 1 <= max && total - total*2/3 - 1 >= 1)
          return total - total*2/3 - 1;
        else
          return max;
    }
  }
}