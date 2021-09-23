package lesson1.self_study;

public class Bow implements WeaponBehavior{
    @Override
    public void attack() {
        System.out.println("화살로 슈슈슈슈슈슉슉슉");
    }
}
