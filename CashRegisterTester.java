/**
   A class to test the CashRegister class.
*/
public class CashRegisterTester
{
   public static void main(String[] args)
   {
      final Coin DOLLAR = new Coin(1.0, "Dollar");
      final Coin QUARTER = new Coin(0.25, "Quarter");
      final Coin DIME = new Coin(0.10, "Dime");
      final Coin NICKEL= new Coin(0.05, "Nickel");

      CashRegister register = new CashRegister();

      register.recordPurchase(1.95);
      register.recordPurchase(1.40);
      register.receivePayment(3, DOLLAR);
      register.receivePayment(2, QUARTER);

      int dimes = register.giveChange(DIME);
      System.out.println(dimes);      
      System.out.println("Expected: 1");
      int nickels = register.giveChange(NICKEL);
      System.out.println(nickels);      
      System.out.println("Expected: 1");          
   }
}
