package pattern.builderPattern;

public class Simulator {


    public static void main(String[] args) {

        SampleClass data = new SampleClass.SampleClassBuilder(12, "냥냥뇽")
                .setIsStudent(true)
                .build();

        System.out.println(data.getAge());
    }
}
