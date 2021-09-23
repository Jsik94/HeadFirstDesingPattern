package java_theory;

public class GetSampleInterface implements Interface_Sample {

    static int a;

    public static void main(String[] args) {
        GetSampleInterface test = new GetSampleInterface();

        test.print();
    }

    @Override
    public void print() {
        System.out.println("Hello Interface");
    }




}

