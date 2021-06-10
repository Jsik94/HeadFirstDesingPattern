package lesson1;

public class ModelDuck extends Duck {

    public ModelDuck(){
        flyBehavior = new FlayNoWay();
        quackBehavior = new Quack();
    }


    @Override
    public void display() {
        System.out.println("모형오리임");
    }
}
