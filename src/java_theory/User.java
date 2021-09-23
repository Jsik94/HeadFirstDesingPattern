package java_theory;

public class User {

    public static void main(String[] args) {
        RemoteControl myRemote;

        myRemote = new SamsungAITV();
        myRemote.printDiscription();
        myRemote.turn_on();
        myRemote.trun_off();

        System.out.println("TV 변경");

        myRemote = new SamsungAITV();
        myRemote.printDiscription();
        myRemote.turn_on();
        myRemote.trun_off();


    }
}
