package java_theory.OverridingNloading;

public class CatSimulator {

    public static void main(String[] args) {
        ParentCat pCat = new ParentCat();
        ChildCat cCat = new ChildCat();

        ParentCat pretendingMotherCat = new ChildCat();

        pretendingMotherCat.eat();
        ((ChildCat)pretendingMotherCat).eat("츄르");


    }
}
