package org.example.task1;

public class Cat extends Animal{

    private String color;


    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void makeSound(){
        System.out.println("Мяу-мяу");
    }

    public void sharpClaws(){
        System.out.println("Я точу свои когти!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
