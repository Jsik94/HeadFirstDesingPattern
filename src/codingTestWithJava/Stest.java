package codingTestWithJava;

public class Stest {

    public static void main(String[] args) {

        Human first = new Woman();





    }
}


interface Human{

}

class Woman implements Human{
    String b;
}


class Man implements Human{
    String a;


}
