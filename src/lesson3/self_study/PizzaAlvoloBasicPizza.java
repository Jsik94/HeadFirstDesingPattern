package lesson3.self_study;

public class PizzaAlvoloBasicPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    PizzaAlvoloBasicPizza(PizzaIngredientFactory pizzaIngredientFactory){
        this.ingredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        dough =ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        System.out.println("Prepare " + name);
    }
}
