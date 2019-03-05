import java.util.ArrayList;

abstract public class Tower implements Flyable{
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }
    public void unregister(Flyable flyable){

        flyable.registerTower();

        observers.remove()
        for (int i = 0; i < observers.size(); i++){

        }
    }
    protected void conditionsChanged(){

    }

}
