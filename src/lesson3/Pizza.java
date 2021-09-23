package lesson3;

import java.util.ArrayList;

public abstract class Pizza {

    String name;
    String dough;
    String sauce;
    ArrayList topping =new ArrayList();

    public void cut() {
        System.out.println("Cutting...");
    }

    public void bake() {
        System.out.println("Baking...");
    }

    public void box() {
        System.out.println("Boxing!");
    }

    public void prepare() {
        System.out.println(name);
        System.out.println("Tossing doug....");
        System.out.println("Adding toppings : ");
        for (int i = 0 ; i < topping.size();i++){
            System.out.println(" " + topping.get(i));
        }
    }

}
