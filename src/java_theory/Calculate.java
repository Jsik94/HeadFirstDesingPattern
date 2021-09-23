package java_theory;

public class Calculate implements Calculatable{


    Calculate(){
        Calculatable.sayHello();
        Calculatable calculatable ;

    }
    @Override
    public void printDefaultOut() {
        System.out.println("얘는 오버라이딩이 그래서 된다능!!");;

    }



    @Override
    public int sum(int a, int b) {
        return a+b;
    }
}
