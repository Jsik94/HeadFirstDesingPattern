package lesson3;

public class NYPizzaStore extends PizzaStore{
    public NYPizzaStore(SimplePizzaFactory simplePizzaFactory) {
        super(simplePizzaFactory);
    }

    @Override
    protected Pizza createPizza(String type) {

        if(type.equals("cheese")){
            return new NYStyleCheesePizza();
        }else if(type.equals("pepperoni")){
            return new NYStyleCheesePizza();
        }else if(type.equals("veggie")){
            return new NYStyleCheesePizza();
        }
        return null;


    }
}
