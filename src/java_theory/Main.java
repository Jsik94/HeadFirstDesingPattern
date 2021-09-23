package java_theory;

public class Main {

    public static void main(String[] args) {

        Person j_sik = new Person();

        Person friend = new Person(0,"Minsu");
        //민수의 재정 상태
        friend.showStatus();
        //j_sik이 달러를 인출한다
        Dollar dollar = j_sik.drawMoney(1000);

        //민수가 돈을 받았다.
        friend.getMoney(dollar);
        //돈을 받은 뒤 재정 상태
        friend.showStatus();

        Bank mybank = new WooRi();



    }

}
