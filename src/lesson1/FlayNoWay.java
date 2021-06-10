package lesson1;

import lesson1.FlyBehavior;

public class FlayNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("난 못날아~~");
    }
}
