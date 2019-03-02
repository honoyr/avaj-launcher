interface Product { }


abstract public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = idCounter;
    }

    private static long nextId(){
        idCounter += 1;
        return idCounter;
    }

//    public abstract Product factoryMethod();
}
