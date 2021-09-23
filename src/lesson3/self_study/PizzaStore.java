package lesson3.self_study;

import lesson3.Pizza;

public abstract class PizzaStore {


    public lesson3.self_study.Pizza orderPizza(String type){
        lesson3.self_study.Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();



        return pizza;
    }

    abstract protected lesson3.self_study.Pizza createPizza(String type) ;

}
