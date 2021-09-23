package lesson1.self_study;

public class User {

    private WeaponBehavior weaponBehavior;

    User(){
        System.out.println("캐릭터가 생성되었습니다.");
        this.weaponBehavior = new Fist();
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public WeaponBehavior getWeaponBehavior() {
        return weaponBehavior;
    }

    public void attack(){
        weaponBehavior.attack();
    }
}
