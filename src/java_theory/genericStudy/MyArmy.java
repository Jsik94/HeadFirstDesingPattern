package java_theory.genericStudy;

import java.util.ArrayList;

public class MyArmy<T extends Character>{
    private ArrayList<T> people;

    public MyArmy() {
        this.people = new ArrayList<>();
    }

    public void addSolider (T one){
        people.add(one);
    }

    public void attackAll(){
        for (int i = 0 ; i < people.size();i++){
            people.get(i).attack();
        }
    }

    public T getSolider(int i){
        return people.get(i);
    }

}
