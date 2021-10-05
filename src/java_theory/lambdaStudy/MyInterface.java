package java_theory.lambdaStudy;

/*
* FunctionalInterface annotation
* -> 인터페이스가 단 하나의 추상메소드만 지닐때 사용할 수 있는 어노테이션이다.
*
*/
@FunctionalInterface
public interface MyInterface {

    int calc (int a, int b);

}
