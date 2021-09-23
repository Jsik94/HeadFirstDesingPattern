package lesson3;

public class ChicagoStyleCheesePizza extends Pizza{
    public ChicagoStyleCheesePizza(){
        name = "Chicago Style Depp dish Cheese CreatablePizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        topping.add("Grated Reggiano Cheese");
    }

    @Override
    public void cut() {
        System.out.println("Cutting 4 slices");
    }
}
