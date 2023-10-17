package Week06_01;

import java.util.ArrayList;
import java.util.List;

public class StringList {
    public static List<String> convertToLowerCase(List<String> inputList) {
        List<String> resultList = new ArrayList<>();

        for (String item : inputList) {
            resultList.add(item.toLowerCase());
        }

        return resultList;
    }

    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("Apple");
        originalList.add("Banana");
        originalList.add("Cherry");

        List<String> lowercaseList = convertToLowerCase(originalList);

        for (String item : lowercaseList) {
            System.out.println(item);
        }
    }
}
