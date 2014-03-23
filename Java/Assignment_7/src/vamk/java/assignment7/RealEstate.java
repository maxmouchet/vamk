package vamk.java.assignment7;

public class RealEstate {

  public static void main(String[] args) {
    Integer constructionYear = 2004;
    String address = "Palosaarentie 21";
    Float area = 200f;
    Float squareMeterPrice = 12000f;
    
    House house = new House(constructionYear, address, area, squareMeterPrice);
    System.out.println(house.toString());
    
    Flat flat = new Flat(constructionYear, address, area, squareMeterPrice, 2, 60.0f);
    System.out.println(flat.toString());
    System.out.println(flat.getUnitMaintenanceCharge() + "€");
    
    Villa villa = new Villa(constructionYear, address, area, squareMeterPrice, 3, 100.23f, 52.5f);
    System.out.println(villa.toString());
    System.out.println(villa.getPrice() + "€");
  }

}
