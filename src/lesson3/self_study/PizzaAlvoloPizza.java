package lesson3.self_study;

public class PizzaAlvoloPizza extends PizzaStore{
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new AlvoloIngredientFactory();


        if(type.equals("basic")){

            pizza =  new PizzaAlvoloBasicPizza(ingredientFactory);
            pizza.setName("Basic");
        }else if(type.equals("cheese")){
            pizza =  new PizzaAlvoloCheeseiPizza(ingredientFactory);
            pizza.setName("cheese");
        }else if(type.equals("Pepperoni")){
            pizza =  new PizzaAlvoloPepperoniPizza(ingredientFactory);
            pizza.setName("Pepperoni");
        }else if(type.equals("clam")){
            pizza =  new PizzaAlvoloClamPizza(ingredientFactory);
            pizza.setName("Clam");
        }
        return pizza;
    }
}
