package vamk.java.assignment7;

public class Flat extends House {

  private Integer numberOfRooms;
  private Float maintenanceCharge;

  public Flat(Integer constructionYear, String address, Float area,
      Float squareMeterPrice, Integer numberOfRooms, Float maintenanceCharge) {

    super(constructionYear, address, area, squareMeterPrice);
    this.numberOfRooms = numberOfRooms;
    this.maintenanceCharge = maintenanceCharge;
  }

  public Float getUnitMaintenanceCharge() {
    return this.maintenanceCharge / this.squareMeterPrice;
  }

}
