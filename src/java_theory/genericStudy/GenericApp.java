package java_theory.genericStudy;

public class GenericApp {

    public static void main(String[] args) {

        //오크 4명생성
        MyArmy<Orc> ors = new MyArmy<>();
        ors.addSolider(new Orc(new Axe()));
        ors.addSolider(new Orc(new Axe()));
        ors.addSolider(new Orc(new Sword()));
        ors.addSolider(new Orc(new Axe()));


        //휴먼 3명 생성
        MyArmy<Human> hus = new MyArmy<>();
        hus.addSolider(new Human(new Sword()));
        hus.addSolider(new Human(new Sword()));
        hus.addSolider(new Human(new Sword()));


        ors.getSolider(0).showSelf();
        ors.attackAll();

        hus.getSolider(0).showSelf();
        hus.attackAll();

    }
}
