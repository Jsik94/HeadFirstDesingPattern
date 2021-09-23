package lesson1.self_study;

public class Enforce implements WeaponBehavior {


    WeaponBehavior weaponBehavior;

    public Enforce(WeaponBehavior weaponBehavior){

        if((Math.random()*10+1)>5){
            this.weaponBehavior = weaponBehavior;
            System.out.println("강화성공!");
        }

    }

    @Override
    public void attack() {
        System.out.println("+1강 ");
        this.weaponBehavior.attack();
    }

    public WeaponBehavior getWeaponBehavior() {
        return weaponBehavior;
    }
}
