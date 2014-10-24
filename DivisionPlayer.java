public class DivisionPlayer extends ChipsPlayer
{
  public DivisionPlayer()
  {
    name = "Arith Medic";
  }
  
  
  
  public int play(int total, int max)
  {
    if (total <= max)
      return total;
    else if ((total-1)%3+1 < total/3 && (total-1)%3+1 <= max && (total-1)%3+1 >= 1)
      return (total-1)%3+1;
    return 1;
  }
}