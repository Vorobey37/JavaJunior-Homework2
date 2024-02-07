package org.example.task1;

public class Dog extends Animal{

    private String type;

    public Dog(String name, int age, String type) {
        super(name, age);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void makeSound(){
        System.out.println("Гав-Гав");
    }

    public void bringThingBack(){
        System.out.println("Кидайте мне что-нибудь и я это принесу обратно!");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
