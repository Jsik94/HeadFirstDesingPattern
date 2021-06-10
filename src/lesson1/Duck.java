package lesson1;

import lesson1.FlyBehavior;
import lesson1.QuackBehavior;

public abstract class Duck {


    //오리마다 다를 수 있는 행동 양식들은 다 뺌
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract  void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.Quack();
    }

    //Setter를 통해 해당 행동을 바꿀 수 있게 변경

    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }


    //공통부분의 행동양식
    public void swim(){
        System.out.println("수영은 모든오리 쌉가능");
    }
}
