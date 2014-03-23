package vamk.java.assignment7;

public class Villa extends House {
  
  private Integer numberOfFloors;
  private Float yardArea, garageArea;
  
  public Villa(Integer constructionYear, String address, Float area,
      Float squareMeterPrice, Integer numberOfFloors, Float yardArea, Float garageArea) {
    
    super(constructionYear, address, area, squareMeterPrice);
    this.numberOfFloors = numberOfFloors;
    this.yardArea = yardArea;
    this.garageArea = garageArea;
  }
  
  public Float getPrice() {
    return (this.area + this.yardArea + this.garageArea) * this.squareMeterPrice;
  }

}
