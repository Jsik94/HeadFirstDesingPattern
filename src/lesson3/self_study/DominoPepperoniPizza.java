package lesson3.self_study;

public class DominoPepperoniPizza extends Pizza {

    DominoPepperoniPizza(){
        name = "Pepperoni Pizza";

        topping.add("Add Domino Cheese");
        topping.add("Add pepperoni");

    }

    @Override
    public void prepare() {

        System.out.println("Add Basil pesto");
    }
}
