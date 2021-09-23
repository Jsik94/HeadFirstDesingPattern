package lesson3;

public abstract class PizzaStore {
    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory){
        this.factory = simplePizzaFactory;
    }

    Pizza orderPizza(String type){

        Pizza pizza =createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return  pizza;
    }

    protected abstract  Pizza createPizza(String type);
}
