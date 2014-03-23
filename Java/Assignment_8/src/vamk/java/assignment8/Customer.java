package vamk.java.assignment8;

import java.util.Arrays;

public class Customer {

  private String name, address;
  private Account[] accounts;
  private float taxRate;
  
  public Customer(String name, String address, Account[] accounts) {
    this.name = name;
    this.address = address;
    this.accounts = accounts;
    this.taxRate = 0.0f;
  }
  
  public void setTaxRate(float taxRate) {
    this.taxRate = taxRate;
  }
  
  public float getTotalTax() {
    float totalTax = 0.0f;
    
    for (Account account : accounts) {
      totalTax += account.getBalance() * this.taxRate;
    }
    
    return totalTax;
  }

  @Override
  public String toString() {
    return "Customer [name=" + name + ", address=" + address + ", accounts="
        + Arrays.toString(accounts) + ", taxRate=" + taxRate + "]";
  }

}
