package java_theory.OverridingNloading;

public class ChildCat extends ParentCat{

    private String sound ;

    public ChildCat() {
        this(1,"으냐아아ㅏ아아아옹!");
    }

    public ChildCat(int age, String sound) {
        super(age);
        this.sound = sound;
    }


    @Override
    public void eat() {
        System.out.println("아기냥이 먹는다");
    }

    public void eat(String something){
        System.out.println("아기냥이가 " +something+"을/를 먹었다!");
    }

    public void shouting(){
        System.out.println("소리친다 - " + sound);

    }
}
