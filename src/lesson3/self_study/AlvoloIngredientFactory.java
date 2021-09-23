package lesson3.self_study;

public class AlvoloIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new OrignalDough();
    }

    @Override
    public Sauce createSauce() {
        return new SpcialTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new AlvoloCheese();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new GeneralPepperoni();
    }

    @Override
    public Clam createClam() {
        return new FreshClam();
    }
}
