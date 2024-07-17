package org.surebet;

public class Placeholders {
    String[] drivers;
    String[] constructors;
    public Placeholders(){}

    // 195 item found today.
    // TODO: Delete this unholy abomination, setup DB.
    public final String[] getDrivers() {

        drivers = new String[]{"Max Verstappen", "Lando Norris", "Charles Leclerc", "Carlos Sainz", "Oscar Piastri", "Sergio Perez", "Geprge Russell", "Lewis Hamilton", "Fernando Alonso", "Lance Stroll", "Nico Hulkenberg", "Yuki Tsunoda", "Daniel Ricciardo", "Oliver Bearman", "Pierre Gasly", "Kevin Magnussen", "Alex Albon", "Alexander Albon", "Zhou Guyanyu", "Logan Sargeant", "Valteri Bottas"};

        return drivers;
    }

    public final String[] getConstructors() {
        constructors = new String[]{"Red Bull", "Red Bull Racing", "McLaren", "Mclaren", "Ferrari", "Mercades", "Sauber", "Kick Sauber", "Aston Martin", "Williams", "Haas", "Alpine", "VCARB", "RB", "Racing Bulls"};

        return constructors;
    }
}
