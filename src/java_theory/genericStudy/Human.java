package java_theory.genericStudy;

public class Human extends Character{

    public Human(WeaponEffect weapon) {
        this.kind = "Human";
        this.myweapon = weapon;
    }

    @Override
    public void attack() {
//        myweapon.showEffect();
        System.out.println(myweapon.getName() +"로 공격");
    }

    @Override
    public void showSelf() {
        System.out.println("I'm a " +kind+".");
    }
}
