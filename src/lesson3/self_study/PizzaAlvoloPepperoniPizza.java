package lesson3.self_study;

public class PizzaAlvoloPepperoniPizza extends Pizza {

    PizzaIngredientFactory ingredientFactory ;

    PizzaAlvoloPepperoniPizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Prepare " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();

        topping.add("Add pepperoni");


    }

    @Override
    public void cut() {
        System.out.println("Cut honeycomb Style");
    }


}
