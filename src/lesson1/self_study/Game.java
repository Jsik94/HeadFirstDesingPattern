package lesson1.self_study;

public class Game {

    public static void main(String[] args) {

        User user1 = new User();

        user1.attack();
        user1.setWeaponBehavior(new Sword());
        user1.attack();

        user1.setWeaponBehavior(new Bow());
        user1.attack();

        Enforce enforce = new Enforce(user1.getWeaponBehavior());



    }
}
