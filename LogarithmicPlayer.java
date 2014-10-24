public class LogarithmicPlayer extends ChipsPlayer
{
  public LogarithmicPlayer()
  {
    name = "Smarty Pants";
  }
  
  
  
  public int play(int total, int max)
  {
    if (total <= max)
      return total;
    else if (total - (int)Math.pow(3, (Math.log(total)/Math.log(3))) < total/3 && total - (int)Math.pow(3, (Math.log(total)/Math.log(3))) <= max && total - (int)Math.pow(3, (Math.log(total)/Math.log(3))) >= 1)
      return total - (int)Math.pow(3, (Math.log(total)/Math.log(3)));
    return 1;
  }
}