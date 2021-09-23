package lesson1;

import lesson1.ModelDuck;

public class MiniDuckSimulator {

    public static void main(String[] args){
//        lesson1.Duck mallard = new lesson1.MallardDuck();
//        mallard.performFly();
//        mallard.performQuack();
//
//        Duck model = new ModelDuck();
//
//        model.performFly();
//        model.performQuack();
//        //이런식으로 같은 인터페이스 형식을 넣으면
//        //setter에 의해 수정
//        model.setFlyBehavior(new FlyRocketPowerd());
//        model.performFly();


        Duck myDuck = new RobotDuck();

        myDuck.performFly();
        myDuck.performQuack();
    }
}
