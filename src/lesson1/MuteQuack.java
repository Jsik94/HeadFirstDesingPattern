package lesson1;

public class MuteQuack implements QuackBehavior{
    @Override
    public void Quack() {
        System.out.println("난 못울어~~");
    }
}
