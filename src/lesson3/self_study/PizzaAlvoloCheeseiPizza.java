package lesson3.self_study;

public class PizzaAlvoloCheeseiPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory ;

    PizzaAlvoloCheeseiPizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Prepare " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();

        topping.add("Add Alvolo Cheese");
        topping.add("Add Cheddar Cheese");
        topping.add("Add gouda Cheese");


    }
}
