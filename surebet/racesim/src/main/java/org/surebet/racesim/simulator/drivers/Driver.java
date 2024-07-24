package org.surebet.racesim.simulator.drivers;

public abstract class Driver {
    private String name;
    private int driverNumber;
    private String team;

    private float age;
    private int experience;
    private int raceWins;
    private int podiums;

    public Driver(String name, int driverNumber, String team) {
        this.name = name;
        this.driverNumber = driverNumber;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

}
