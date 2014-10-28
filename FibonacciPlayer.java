public class FibonacciPlayer extends ChipsPlayer // uses a fibonacci algorithm to play chips and almost always wins
{
  public FibonacciPlayer()
  {
    name = "Mrs. Fibonacci";
  }
  
  
  
  public int play(int total, int max)
  {
    if (total <= max) // if possible,
      return total;     // take the whole thing
    
    if (max == total - 1) // if first move, put the other player on a fibonacci number
      return total - lastFibonacci(total-1);
    
    int nextmove = total; // initialize a variable to the pile
    
    while (nextmove != lastFibonacci(nextmove)) // subtract out the greatest fibonacci number less than or equal to the variable
      nextmove -= lastFibonacci(nextmove); // until this is no longer possible without making it 0
    
    if (nextmove > 0 && nextmove <= max) // if legal,
      return nextmove;                     // play that number
    return 1; // if not, just return 1 to delay the inevitable (and also give your opponent more time to screw up)
  }
  
  
  private int lastFibonacci(int input) // this just helps me find the greatest fibonacci number less than or equal to a given input
  {
    int x1 = 1, x2 = 1; // make two numbers
    boolean a = true;   // and a boolean for alternation
    while (x1 <= input && x2 <= input) // as long as both numbers are less than or equal to the input...
    {
      if (a) // alternate between both
        x1 += x2; // and overwrite one by adding it to the other (fibonacci sequence)
      else        // this stops when the fibonacci numbers surpass the input
        x2 += x1;
      a = !a;
    }
    
    if (a) // at that point, return the smaller of the two (can be determined by whoes turn it was)
      return x1;
    else
      return x2;
  }
}