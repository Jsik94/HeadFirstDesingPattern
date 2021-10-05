package java_theory.genericStudy;

public class Orc extends Character {

    public Orc(WeaponEffect weapon) {
        this.kind = "Orc";
        this.myweapon = weapon;
    }

    @Override
    public void attack() {
//        myweapon.showEffect();
        System.out.println(myweapon.getName() +"로 공격");
    }

    @Override
    public void showSelf() {
        System.out.println("I'm " +kind+".");
    }
}
