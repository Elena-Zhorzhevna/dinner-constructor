package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        // добавьте новое блюдо
        if (!dc.storage.containsKey(dishType)) {
            dc.storage.put(dishType, new ArrayList<>());
        }
        dc.storage.get(dishType).add(dishName);
    }

    private static void generateDishCombo() {

        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

        ArrayList<String> userList = new ArrayList<>();

        String nextItem = "";
        do {
            nextItem = scanner.nextLine();
            if (dc.storage.containsKey(nextItem)) {
                userList.add(nextItem);
            } else if (!nextItem.isEmpty()) {
                System.out.println("Такого типа блюда нет, введите другой");
            }
        } while (!nextItem.isEmpty());

        ArrayList<String> generatedData = dc.generateListOfDishes(numberOfCombos, userList);
        for (String pos: generatedData) {
            System.out.println(pos);
        }
    }
}


