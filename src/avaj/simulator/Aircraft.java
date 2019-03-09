package avaj.simulator;

interface Product { }


abstract public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        nextId();
        this.name = name;
        this.coordinates = coordinates;
        this.id = idCounter;
    }

    private static long nextId(){
        idCounter += 1;
        return idCounter;
    }

//    public abstract Product factoryMethod();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public static long getIdCounter() {
        return idCounter;
    }
}