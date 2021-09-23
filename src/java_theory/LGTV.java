package java_theory;

public class LGTV implements RemoteControl{



    public void watchNetflix(){
        System.out.println("넷플릭스가 나온다.");
    }


    @Override
    public void turn_on() {
        System.out.println("LG 티비가 켜졌다");
    }

    @Override
    public void trun_off() {
        System.out.println("LG 티비가 꺼졌다.");
    }

    @Override
    public void printDiscription() {
        RemoteControl.super.printDiscription();
        System.out.println("넷플릭스 기능이 있습니다.");
    }
}
