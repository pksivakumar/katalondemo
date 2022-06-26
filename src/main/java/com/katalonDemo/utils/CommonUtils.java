package com.katalonDemo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommonUtils {

    public static List<Integer> randomNumberGenerator(){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < 4) {

            int random = randomGenerator .nextInt(11);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return numbers;
    }
}
