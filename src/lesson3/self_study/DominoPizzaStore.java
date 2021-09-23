package lesson3.self_study;

public class DominoPizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String type) {

        if(type.equals("basic")){
            return new DominoBasicPizza();
        }else if(type.equals("cheese")){
            return new DominoCheeseiPizza();
        }else if(type.equals("pepperoni")){
            return new DominoPepperoniPizza();
        }else if(type.equals("clam")){
            return new DominoClamPizza();
        }
        return null;
    }
}
