package java_theory;

public interface Calculatable {
    //Access modifier에 따른 method분류


    //public 구현부가 없음
    int sum(int a, int b);


    //private
    /*
    private 이므로 구현받은 클레스가 직접 사용할 수는 없음
    private키워드는 고정이라고 봐도됨


     */
    private void printout() {
        System.out.println("이건 기본적으로 이렇게 나와!");
    }

    private static void printStaticOut() {
        System.out.println("이것도 기본적으로 이렇게 나와!");
    }


    // default 이것도 구현은 하나 abstract가 아님 (클래스가 구현을 선택적으로 할 수 있음)
    default void printDefaultOut() {
        System.out.println("이건 디폴트야 ~~~");
    }

    default void printPublicOut(){
        printout();
        System.out.println("Private은 이렇게 밖에 못써~~~");
    }


    //static
    //스태틱은 인터페이스 이름으로 직접 참조가능 왜? static은 인스턴스 생성전에 이미 올라감~ 생성타이밍 차이임
    static void sayHello(){

    }


}
