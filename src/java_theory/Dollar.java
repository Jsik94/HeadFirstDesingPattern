package java_theory;

public class Dollar extends Money{

    String unit = "$";


    public Dollar(int value, int serial) {
        super(value, serial);
    }

    @Override
    public void check_value() {
        System.out.println("My value is " + value +unit);
    }


}
