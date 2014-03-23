package vamk.java.assignment8;

public class Account implements IAccount {
  
  private float balance;
  private float interestRate;
  
  public Account() {
    this.balance = 0.0f;
    this.interestRate = 0.0f;
  }

  @Override
  public void setBalance(float balance) {
    this.balance = balance;
  }

  @Override
  public float getBalance() {
    return this.balance;
  }

  @Override
  public void setInterestRate(float interestRate) {
    this.interestRate = interestRate;
  }

  @Override
  public float getProfit() {
    return this.balance * this.interestRate;
  }

  @Override
  public String toString() {
    return "Account [balance=" + balance + ", interestRate=" + interestRate
        + "]";
  }

}
