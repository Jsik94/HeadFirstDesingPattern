package java_theory.lambdaStudy;

public class MyCalculator {

    public static void main(String[] args) {

        /*
            인터페이스의 구현을 통해 람다식 사용이유와 차이를 알아보자.
            1.Concrete class를 이용하는 방법
            -> Concrete class가 정의되어있으므로, 재사용이 가능하다.

            2.익명 클래스를 구현하여 사용하는 방법
            -> 익명클래스이므로, 일회성 코드다. 재사용이 불가능하다.

            3. 람다식을 이용
            -> 이도 마찬가지로 익명클래스이므로 재사용 불가능하다. 익명클래스에 비해 간결한 코드를 제공한다.



         */




        //Concrete class를 이용하는 방법
        MyInterface my1 = new MyInterfaceImpl();
        System.out.println("Using Concrete class");
        System.out.println(my1.calc(1,2));

        //익명 클래스를 구현하여 사용하는 방법
        MyInterface my2 = new MyInterface() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        };
        System.out.println("Using Anonymous Class");
        System.out.println(my2.calc(1,2));


        //람다식을 이용
        MyInterface my3 = (a, b) -> a+b;
        System.out.println("Using Lambda function");
        System.out.println(my3.calc(1,2));


        //메소드 활용
        paramFunc((a, b) -> a+b,1,2);

        //반환형 람다
        System.out.println("람다를 반환값으로도 받을 수있다.");
        System.out.println(returnFunc(1));
    }


    static void paramFunc(MyInterface lambda, int a , int b){
        System.out.println(lambda.calc(a,b));
    }


    //인터페이스를 반환하면서, 해당 인터페이스가 @FunctionalInterface 라면 람다형 반환으로 만들 수 있다.
    static MyInterface returnFunc(int k){

        switch (k){
            case 0:
                return (a, b) -> a+b;
            case 1:
                return (a, b) -> a-b;
            case 2:
                return (a, b) -> a*b;
            case 3:
                return (a, b) -> Math.abs(a-b);

            default:
                return (a, b) -> a+b+k;
        }

    }
}
