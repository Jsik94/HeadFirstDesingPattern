package java_theory.genericStudy;

public class Sword implements WeaponEffect {

    String name = "칼";

    @Override
    public void showEffect() {
        System.out.println("슈슈슈슈슈슉");
    }

    @Override
    public String getName() {
        return name;
    }
}
