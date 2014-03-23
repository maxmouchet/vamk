package vamk.java.assignment7;

public class House {

  protected Integer constructionYear;
  protected String address;
  protected Float area, squareMeterPrice;

  public House(Integer constructionYear, String address, Float area,
      Float squareMeterPrice) {

    this.constructionYear = constructionYear;
    this.address = address;
    this.area = area;
    this.squareMeterPrice = squareMeterPrice;
  }

  @Override
  public String toString() {
    return "House [constructionYear=" + constructionYear + ", address="
        + address + ", area=" + area + ", squareMeterPrice=" + squareMeterPrice
        + "]";
  }

}
