package java_theory.genericStudy;

public class Axe implements WeaponEffect{
    String name = "도끼";
    @Override
    public void showEffect() {
        System.out.println("후우욱");
    }

    @Override
    public String getName() {
        return name;
    }
}
