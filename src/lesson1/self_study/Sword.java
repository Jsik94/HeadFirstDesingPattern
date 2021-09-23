package lesson1.self_study;

public class Sword implements WeaponBehavior{
    @Override
    public void attack() {
        System.out.println("검으로 슉슉슉");
    }
}
