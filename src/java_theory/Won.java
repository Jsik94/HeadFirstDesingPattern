package java_theory;

public class Won extends Money {

    String unit = "원";
    int check_code;

    public Won(int value,int serial) {
        super(value,serial);
        check_code = value+serial;
    }

    @Override
    public void check_value() {
        System.out.println("My value is " + value +unit);
    }


}
