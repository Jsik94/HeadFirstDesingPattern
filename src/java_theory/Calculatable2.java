package java_theory;

public interface Calculatable2 extends Calculatable{

    static void useStaticPrivate(){
        //상속을 받아도 private static은 못씀!!

        Calculatable.sayHello();
    }
}
