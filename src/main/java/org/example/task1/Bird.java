package org.example.task1;

public class Bird extends Animal{

    private int flyingHeight;

    public Bird(String name, int age, int flyingHeight) {
        super(name, age);
        this.flyingHeight = flyingHeight;
    }

    public int getFlyingHeight() {
        return flyingHeight;
    }

    public void setFlyingHeight(int flyingHeight) {
        this.flyingHeight = flyingHeight;
    }

    public void flyUp(){
        System.out.println("Я взлетаю... и лечу!");
    }

    public  void peckGrain(){
        System.out.println("Пойду, поклюю зерно");
    }

    @Override
    public String toString() {
        return "Bird{" +
                "flyingHeight=" + flyingHeight +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
