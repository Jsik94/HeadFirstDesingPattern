package java_theory;

public interface RemoteControl {

    static final int TRUNON = 999;
    static final int TRUNOF = 998;
    String thing = "리모컨";

    void turn_on();
    void trun_off();

    private int getTrunon(){
        return TRUNON;
    }
    private int getTrunof(){
        return TRUNOF;
    }
    default void printDiscription(){
        System.out.println(thing+"입니다.");
        System.out.println("turn on 과 off 의 기능이 있습니다.");
        System.out.println("turn on : " + getTrunon());
        System.out.println("turn off : " + getTrunof());

    }

}
