package lesson1;
//Fly와 같은 행동도 인터페이스로 나눈 이유
//1. 모든 오리마다 Fly 행동양식이 다르다 (못날거나, 날거나 뭐등등)
//2. 그렇기에 오리 Class 의 공통된 행동양식으로 쓰일수 없어서 1차적으로 분리
//3. 그리고 나는 오리와 못나는 오리를 위해 Class를 통해 행동 양식을 구현

public interface FlyBehavior {
    public void fly();
}
