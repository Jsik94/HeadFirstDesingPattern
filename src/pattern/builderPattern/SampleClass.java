package pattern.builderPattern;

public class SampleClass {
    private int age;
    private String name;

    //Optional Member
    private boolean isStudent;

    private SampleClass(SampleClassBuilder sampleClassBuilder) {
        this.age = sampleClassBuilder.age;
        this.name = sampleClassBuilder.name;
        this.isStudent = sampleClassBuilder.isStudent;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isStudent() {
        return isStudent;
    }

    static class SampleClassBuilder {
        /*
        필수 항목은 생성자에
        나머지는 setter를 이용하여 구현

         */


        private int age;
        private String name;

        private boolean isStudent;

        public SampleClassBuilder(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public SampleClassBuilder setIsStudent (boolean isStudent){
            this.isStudent = isStudent;
            return this;
        }

        public SampleClass build(){
            return new SampleClass(this);
        }

    }

}
