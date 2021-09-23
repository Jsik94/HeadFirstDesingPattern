package java_theory.OverridingNloading;

public class ParentCat {

    private int age ;

    public ParentCat(){
        this(10);
    }

    public ParentCat(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("엄마냥 밥이다아아옹");
    }

    protected void hit(){
        System.out.println("냥냥 펀치");
    }

    private void careMyKids(){
        System.out.println("아기냥을 챙긴다.");
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
