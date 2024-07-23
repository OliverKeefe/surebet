package org.surebet.racesim.simulator.drivers;

public abstract class Driver {
    private String driversName;
    private int driversNumber;
    private String driversTeam;

    public Driver(String name, int driverNumber, String team) {
        this.driversName = driversName;
        this.driversNumber = driversNumber;
        this.driversTeam = driversTeam;
    }

}

public String getDriversTeam() {
    return driversTeam;
}

public void setDriversTeam(String driversTeam) {
    this.driversTeam = driversTeam;
}