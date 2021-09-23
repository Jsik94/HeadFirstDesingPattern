package lesson3.self_study;

public class PizzaAlvoloClamPizza extends Pizza {



    PizzaIngredientFactory ingredientFactory ;

    PizzaAlvoloClamPizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Prepare " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        topping.add("Add Clam");


    }
}
