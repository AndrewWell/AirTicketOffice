package variables;


import entity.Aircraft;

public class Airplane implements Aircraft {
    private String model, manufacturer, regNum, techCondition;
    private int yearOfManufacturer, passengerCapacity, crewMembers, baggageCapacity;

    public Airplane(String model, String manufacturer, int yearOfManufacturer,
                    int passengerCapacity, int crewMembers, int baggageCapacity, String regNum,
                    String techCondition) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.yearOfManufacturer = yearOfManufacturer;
        this.passengerCapacity = passengerCapacity;
        this.crewMembers = crewMembers;
        this.baggageCapacity = baggageCapacity;
        this.regNum = regNum;
        this.techCondition = techCondition;
    }

    @Override
    public String toString() {
        return model + "|" + manufacturer + "|" + yearOfManufacturer + "|" + passengerCapacity + "|"
                + baggageCapacity + "|" + crewMembers + "|" + regNum + "|" + techCondition;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public int getYearOfManufacture() {
        return yearOfManufacturer;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public int getBaggageCapacity() {
        return baggageCapacity;
    }

    @Override
    public String getRegNum() {
        return regNum;
    }

    @Override
    public String getTechCondition() {
        return techCondition;
    }
}
