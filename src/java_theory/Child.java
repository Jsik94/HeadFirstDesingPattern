package java_theory;

public class Child extends Parents{
//    public Child(int age, int sex) {
//        super(age, sex);
//    }

    String hobby = "Nothing";


    public Child(String hobby) {
        super(10,true);
        this.hobby = hobby;
    }

    public Child(){
        this("수면");
    }

    public void playSomething(String acting){
        System.out.println("Play - " +  hobby);

    }

    private void self_intro (){
        System.out.println("Age : " + age);
        System.out.println("Sex : " + (gender == true ? "man" : "woman"));
    }

    @Override
    public void doAllThings() {
       // super.doAllThings();
        System.out.println("Do All Thing!");
        walk();
        eat();
        playSomething(hobby);
        self_intro();
    }
}
