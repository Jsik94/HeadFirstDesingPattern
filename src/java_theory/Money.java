package java_theory;

public class Money {
    int value;
    final int serial;

    public Money(int value,int serial){
        this.value =value;
        this.serial = serial;
    }

    public Money(){
        this(10000,20302033);
    }

    public void check_value(){
        System.out.println("My value :" + "value");
    }

}

