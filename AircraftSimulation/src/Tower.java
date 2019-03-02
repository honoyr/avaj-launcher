

abstract public class Tower implements Flyable{
    private  Flyable observers;

    public void register(Flyable flyable){}
    public void unregister(Flyable flyable){}
    protected void conditionsChanged(){

    }

}
