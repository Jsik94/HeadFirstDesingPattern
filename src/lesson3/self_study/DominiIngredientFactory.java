package lesson3.self_study;

public class DominiIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new DominoOrignalDough();
    }

    @Override
    public Sauce createSauce() {
        return new SpcialMirinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new DominoCheese();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new HandMadePepperoni();
    }

    @Override
    public Clam createClam() {
        return new FreshClam();
    }
}
