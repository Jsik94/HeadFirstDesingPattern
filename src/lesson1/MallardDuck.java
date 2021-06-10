package lesson1;

public class MallardDuck extends Duck{

    public MallardDuck(){
        //인터페이스에 실제 구현된 클레스를 같다 붙여서 있는 메소드를 그대로 쓰게 만듬
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }


    @Override
    public void display() {
        System.out.println("물오리 임");
    }
}
