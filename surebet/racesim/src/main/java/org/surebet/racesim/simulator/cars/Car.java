package org.surebet.racesim.simulator.cars;

public abstract class Car {
    // Info
    private String modelName;
    private String team; // Constructor
    private double weight;
    private double width;
    private double height;
    private int year;

    // Performance attributes
    private double topSpeed;
    private double acceleration;
    private double handling;
    private double brakingEfficiency;

    // Aerodynamics
    private double aerodynamicEfficiency;
    private double totalDownforce;

    // Gearbox
    private String gearboxType;
    private int[] torquePerGear;
    private int[] horsePowerPerGear;
    private int[] gearIsUsable;

    // Setup
    private double suspension;
    private double breakBias;

    // Reliability
    private double reliability;
    private double engineReliability;
    private double gearboxReliability;
    private double suspensionReliability;

    // Fuel
    private double fuelCapacity;
    private double fuelWeight;
    private double startingFuelLoad;
    private double currentFuelLoad;
    private double fuelConsumptionRate;

    // Tires
    private String tireCompound;
    private double gripLevels;
    private double degradationRate;
    private double condition; // Total laps used before fitting.

    public Car(String modelName, String team, double weight, double height, double width, int year,
               double topSpeed, double acceleration, double handling, double brakingEfficiency,
               double aerodynamicEfficiency, double totalDownforce, String gearboxType, int[] torquePerGear,
               int[] horsePowerPerGear, int[] gearIsUsable, double suspension, double breakBias,
               double reliability, double engineReliability, double gearboxReliability, double suspensionReliability,
               double fuelCapacity, double fuelWeight, double startingFuelLoad, double currentFuelLoad,
               double fuelConsumptionRate, String tireCompound, double gripLevels, double degradationRate,
               double condition) {
        this.modelName = modelName;
        this.team = team;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.year = year;
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        this.handling = handling;
        this.brakingEfficiency = brakingEfficiency;
        this.aerodynamicEfficiency = aerodynamicEfficiency;
        this.totalDownforce = totalDownforce;
        this.gearboxType = gearboxType;
        this.torquePerGear = torquePerGear;
        this.horsePowerPerGear = horsePowerPerGear;
        this.gearIsUsable = gearIsUsable;
        this.suspension = suspension;
        this.breakBias = breakBias;
        this.reliability = reliability;
        this.engineReliability = engineReliability;
        this.gearboxReliability = gearboxReliability;
        this.suspensionReliability = suspensionReliability;
        this.fuelCapacity = fuelCapacity;
        this.fuelWeight = fuelWeight;
        this.startingFuelLoad = startingFuelLoad;
        this.currentFuelLoad = currentFuelLoad;
        this.fuelConsumptionRate = fuelConsumptionRate;
        this.tireCompound = tireCompound;
        this.gripLevels = gripLevels;
        this.degradationRate = degradationRate;
        this.condition = condition;
    }

    // Getters and Setters

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getHandling() {
        return handling;
    }

    public void setHandling(double handling) {
        this.handling = handling;
    }

    public double getBrakingEfficiency() {
        return brakingEfficiency;
    }

    public void setBrakingEfficiency(double brakingEfficiency) {
        this.brakingEfficiency = brakingEfficiency;
    }

    public double getAerodynamicEfficiency() {
        return aerodynamicEfficiency;
    }

    public void setAerodynamicEfficiency(double aerodynamicEfficiency) {
        this.aerodynamicEfficiency = aerodynamicEfficiency;
    }

    public double getTotalDownforce() {
        return totalDownforce;
    }

    public void setTotalDownforce(double totalDownforce) {
        this.totalDownforce = totalDownforce;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    public int[] getTorquePerGear() {
        return torquePerGear;
    }

    public void setTorquePerGear(int[] torquePerGear) {
        this.torquePerGear = torquePerGear;
    }

    public int[] getHorsePowerPerGear() {
        return horsePowerPerGear;
    }

    public void setHorsePowerPerGear(int[] horsePowerPerGear) {
        this.horsePowerPerGear = horsePowerPerGear;
    }

    public int[] getGearIsUsable() {
        return gearIsUsable;
    }

    public void setGearIsUsable(int[] gearIsUsable) {
        this.gearIsUsable = gearIsUsable;
    }

    public double getSuspension() {
        return suspension;
    }

    public void setSuspension(double suspension) {
        this.suspension = suspension;
    }

    public double getBreakBias() {
        return breakBias;
    }

    public void setBreakBias(double breakBias) {
        this.breakBias = breakBias;
    }

    public double getReliability() {
        return reliability;
    }

    public void setReliability(double reliability) {
        this.reliability = reliability;
    }

    public double getEngineReliability() {
        return engineReliability;
    }

    public void setEngineReliability(double engineReliability) {
        this.engineReliability = engineReliability;
    }

    public double getGearboxReliability() {
        return gearboxReliability;
    }

    public void setGearboxReliability(double gearboxReliability) {
        this.gearboxReliability = gearboxReliability;
    }

    public double getSuspensionReliability() {
        return suspensionReliability;
    }

    public void setSuspensionReliability(double suspensionReliability) {
        this.suspensionReliability = suspensionReliability;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelWeight() {
        return fuelWeight;
    }

    public void setFuelWeight(double fuelWeight) {
        this.fuelWeight = fuelWeight;
    }

    public double getStartingFuelLoad() {
        return startingFuelLoad;
    }

    public void setStartingFuelLoad(double startingFuelLoad) {
        this.startingFuelLoad = startingFuelLoad;
    }

    public double getCurrentFuelLoad() {
        return currentFuelLoad;
    }

    public void setCurrentFuelLoad(double currentFuelLoad) {
        this.currentFuelLoad = currentFuelLoad;
    }

    public double getFuelConsumptionRate() {
        return fuelConsumptionRate;
    }

    public void setFuelConsumptionRate(double fuelConsumptionRate) {
        this.fuelConsumptionRate = fuelConsumptionRate;
    }

    public String getTireCompound() {
        return tireCompound;
    }

    public void setTireCompound(String tireCompound) {
        this.tireCompound = tireCompound;
    }

    public double getGripLevels() {
        return gripLevels;
    }

    public void setGripLevels(double gripLevels) {
        this.gripLevels = gripLevels;
    }

    public double getDegradationRate() {
        return degradationRate;
    }

    public void setDegradationRate(double degradationRate) {
        this.degradationRate = degradationRate;
    }

    public double getCondition() {
        return condition;
    }

    public void setCondition(double condition) {
        this.condition = condition;
    }
}
