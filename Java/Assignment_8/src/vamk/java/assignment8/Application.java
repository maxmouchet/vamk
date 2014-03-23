package vamk.java.assignment8;

public class Application {

  public static void main(String[] args) {
    Account account1 = new Account();
    account1.setBalance(3400.23f);
    account1.setInterestRate(0.034f);
    
    Account account2 = new Account();
    account2.setBalance(15345.12f);
    
    System.out.println(account1.getBalance());
    System.out.println(account1.getProfit());
    System.out.println(account2.toString());
    
    Account[] accounts = { account1, account2 };
    Customer customer = new Customer("Jean Jacques", "Palosaarentie 34, 65200 Vaasa", accounts);
    customer.setTaxRate(0.063f);
    
    System.out.println(customer.toString());
    System.out.println(customer.getTotalTax());
  }

}
