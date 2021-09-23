package java_theory;

public interface Bank {
    public int MAX_INTEGER = 10000000;

    void withDraw(int Price);
    void deposit(int Price);

    static void BCAuth(String bankName){
        System.out.println(bankName+"에서 블록체인 인증을 요청합니다.");
        System.out.println("인증로직을 수행중입니다.");
    }
}
