package lesson3.self_study;

import java.util.ArrayList;

public abstract class Pizza implements CreatablePizza{

    String name ;
    Dough dough;
    Sauce sauce;

    ArrayList topping =new ArrayList();



    @Override
    public void bake() {
        System.out.println("bake 20mins");
    }

    @Override
    public void cut() {
        System.out.println("Cutting this Pizza....");
    }

    @Override
    public void box() {
        System.out.println("Place pizza in official PizzaStore Box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
