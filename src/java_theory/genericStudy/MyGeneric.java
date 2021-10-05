package java_theory.genericStudy;



public class MyGeneric <E>{
    E val;



    public MyGeneric(E val) {
        this.val = val;
    }

    public <T> void setGen(T a){
        System.out.println("해당 파라미터의 클래스 : " + a.getClass().getName());
    }


    public static void main(String[] args) {
        MyGeneric<Integer> sample = new MyGeneric<>(10);

        sample.setGen("안녕하세요");
        sample.setGen(12);
        sample.setGen(12F);

    }
}
