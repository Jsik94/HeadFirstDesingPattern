package java_theory.genericStudy;

public abstract class Character {
    String kind;
    WeaponEffect myweapon;

    abstract void showSelf();
    abstract void attack();

    public <T extends WeaponEffect> void setMyweapon(T myweapon) {
        this.myweapon = myweapon;
    }
}
