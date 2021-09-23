package lesson1;

public class RobotDuck extends Duck{


    public RobotDuck(){
        this(new FlyRocketPowerd(),new Silence_Quack());
    }
    public RobotDuck(FlyBehavior fb, QuackBehavior qb){
        flyBehavior = fb;
        quackBehavior =qb;
    }


    @Override
    public void display() {
        System.out.println("저는 로봇오리입니다.");
    }
}
