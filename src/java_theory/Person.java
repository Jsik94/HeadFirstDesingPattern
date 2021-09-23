package java_theory;

import java.util.List;

public class Person {
    String name;
    int value ;

    Person(){
        this(1000,"J-sik");
    }

    Person(int value,String name){
        this.value = value;
        this.name = name;
    }

    public void makeMoney(Money money){
        System.out.println(name+ "은/는 "+"돈을 벌었다  -- "+money.value);
        this.value += money.value;
    }

    public Dollar drawMoney(int value){
        System.out.println(name+ "은/는 "+"달러를 뽑았다 --" + value);
        this.value -= value;
        Dollar dollar = new Dollar(value, 12312312);
        return dollar;
    }

    public void getMoney(Money money){
        System.out.println(name+ "은/는 "+"돈을 얻었다 -- " + money.value);
        if(money instanceof Dollar){
            System.out.println("그 돈은 달러다");
        }else{
            System.out.println("그 돈은 원이다.");
        }
        this.value+= money.value;

    }


    public void showStatus(){
        System.out.println(name+ "의 "+"현재 가진 가치 - " + this.value);
    }


}
