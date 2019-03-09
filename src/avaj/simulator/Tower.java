package avaj.simulator;

import java.util.ArrayList;

abstract public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();
    private LogFile file = new LogFile();

    public Tower() {
    }

    public void register(Flyable flyable){
        System.out.println("Tower says: " + flyable.getInfo() + "registered to weather tower.");
        file.AddToFile("Tower says: " + flyable.getInfo() + "registered to weather tower.\n");
        observers.add(flyable);

    }
    public void unregister(Flyable flyable){



        System.out.println(this.getClass().getSimpleName() + " says: "
                + flyable.getInfo()
                +  "unregistered from weather tower.");
        file.AddToFile(this.getClass().getSimpleName() + " says: "
                + flyable.getInfo()
                +  "unregistered from weather tower.\n");
        observers.remove(flyable);
    }
    protected void conditionsChanged(){
        if (observers.size() > 0) {
//            for (Flyable check : observers) {
//                System.out.print(check.getInfo());
//                check.updateConditions();
//            }
            for (int i = 0; i < observers.size(); i++)
            {
//                System.out.print(observers.get(i).getInfo());
                observers.get(i).updateConditions(file);
            }
        }
    }

    public void closeFile(){
        file.closeFile();
    }
}