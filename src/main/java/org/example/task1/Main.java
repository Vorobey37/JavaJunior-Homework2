package org.example.task1;

/*Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.*/


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Animal[] animals = createAnimalTypeArray();
        getInfo(animals);
    }

    public static Animal[] createAnimalTypeArray() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ArrayList<Animal> typeAnimalList = new ArrayList<>();
        ArrayList<Class<?>> classArray = new ArrayList<>();

        classArray.add(Class.forName("org.example.task1.Dog"));
        classArray.add(Class.forName("org.example.task1.Cat"));
        classArray.add(Class.forName("org.example.task1.Bird"));

        for (Class<?> classElement : classArray) {
            if (Dog.class.equals(classElement)){
                Constructor[] constructors = classElement.getConstructors();
                Object dog = constructors[0].newInstance("Шарик", 2, "Охотник");
                typeAnimalList.add((Animal)dog);
            }
            if (Cat.class.equals(classElement)){
                Constructor[] constructors = classElement.getConstructors();
                Object cat = constructors[0].newInstance("Мурка", 5, "Рыжий");
                typeAnimalList.add((Animal)cat);
            }
            if (Bird.class.equals(classElement)){
                Constructor[] constructors = classElement.getConstructors();
                Object bird = constructors[0].newInstance("Орлик", 1, 2000);
                typeAnimalList.add((Animal)bird);
            }

        }

        return typeAnimalList.toArray(new Animal[typeAnimalList.size()]);
    }

    public static void getInfo(Animal[] animals) throws InvocationTargetException, IllegalAccessException {
        for (Animal animal : animals) {
            Class clazz = animal.getClass();
            System.out.println("Название класса: " + clazz);
            getFieldsInfo(clazz);
            getConstructorsInfo(clazz);
            getMethodsInfo(clazz);
            runMakeSound(animal);
            System.out.println("--------------------------------");

        }
    }

    private static void getFieldsInfo(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("  Поля класса:");
        for (Field field : fields){
            System.out.println("    " + field.getName());
        }
        Field[] superClassFields = clazz.getSuperclass().getDeclaredFields();
        System.out.println("  Поля родительского класса:");
        for (Field field : superClassFields){
            System.out.println("    " + field.getName());
        }
    }

    private static void getMethodsInfo(Class<?> clazz){
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("  Методы класса:");
        for (Method method : methods){
            System.out.println("    " + method.getName());
        }
        Method[] superClassMethods = clazz.getSuperclass().getDeclaredMethods();
        System.out.println("  Методы родительского класса:");
        for (Method method : superClassMethods){
            System.out.println("    " + method.getName());
        }
    }

    private static void getConstructorsInfo(Class<?> clazz){
        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("  Конструкторы класса:");
        for (Constructor constructor : constructors){
            System.out.println("    " + constructor.getName());
        }
    }

    public static void runMakeSound(Animal animal) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = animal.getClass().getDeclaredMethods();
        Method[] superClassMethods = animal.getClass().getSuperclass().getDeclaredMethods();
        int count = 0;
        for (Method method : methods) {
            if (method.getName().equals("makeSound")) {
                System.out.println("    *********");
                System.out.print("    ");
                method.invoke(animal);
                count++;
            }
        }
        for (Method superClassMethod : superClassMethods) {
            if (superClassMethod.getName().equals("makeSound")) {
                System.out.println("    *********");
                System.out.print("    ");
                superClassMethod.invoke(animal);
                    count++;
            }
        }

        if (count == 0){
            System.out.println("    *********");
            System.out.println("    Звуки мы не издаем!");
        }
    }
}