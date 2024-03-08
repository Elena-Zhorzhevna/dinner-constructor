package ru.practicum.dinner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DinnerConstructor {
    ArrayList<String> dishes = new ArrayList<>();
    HashMap<String, ArrayList<String>> storage = new HashMap<>();
    Random randomizer = new Random();
    //dishes = dinnerConstructor.get(dishType);


    public ArrayList<String> generateListOfDishes(int quantity, ArrayList<String> types) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            String oneGen = "";
            for (String type: types) {
                if (oneGen.isEmpty()) {
                    oneGen = getRandomElem(type);
                } else {
                    oneGen += "," + getRandomElem(type);
                }
            }
            result.add(oneGen);
        }
        return result;
    }

    private String getRandomElem(String type) {
        int arrSize = storage.get(type).size();
        int pos = randomizer.nextInt(arrSize);
        return storage.get(type).get(pos);
    }
}