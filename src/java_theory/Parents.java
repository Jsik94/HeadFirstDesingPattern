package java_theory;

public class Parents {

    public int age;
    protected boolean gender;
    private boolean tobacoo;


    public Parents(int age,boolean sex){
        this.age = age;
        this.gender = sex;
    }

    public Parents(){
        this(10,true);
    }

    public void walk() {
        System.out.println("walk anythere");
    }

    public void eat() {
        System.out.println("eat sandwich");
    }

    private void smoke() {
        System.out.println("smoking~");
    }

    protected void doAllThings() {
        System.out.println("Do All Thing!");
        walk();
        eat();
        smoke();
    }
}
