package java_theory;

public class SamsungAITV implements RemoteControl{
    @Override
    public void turn_on() {
        System.out.println("삐빕 TV ON");
    }

    @Override
    public void trun_off() {
        System.out.println("삐빕 TV OFF");
    }

    public void recommendChannel(){
        System.out.println("오늘의 추천채널입니다.");
    }

    @Override
    public void printDiscription() {
        System.out.println("삼성 TV 설명서입니다.");
        RemoteControl.super.printDiscription();
        System.out.println("채널 추천 기능이 있습니다.");
    }
}
