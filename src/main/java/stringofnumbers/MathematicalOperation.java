package stringofnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MathematicalOperation {

    public int action(String numbers) {
        List<String> listOfStrings = new ArrayList<>(List.of(numbers.split("[,;.]")));
        String lastElement = listOfStrings.get(listOfStrings.size() - 1);
        listOfStrings.remove(listOfStrings.size() - 1);
        List<Integer> convertedList = new ArrayList<>();
        for (String number : listOfStrings) {
            convertedList.add(Integer.parseInt(number));
        }

        if (Objects.equals(lastElement, "+")) {
            return convertedList.stream()
                    .collect(Collectors.summingInt(number -> {
                        int result = 0;
                        result += number;
                        return result;
                    }));
        }
        else if (Objects.equals(lastElement, "-")){
            return convertedList.stream()
                    .collect(Collectors.summingInt(number -> -number));
        }
        //else if (Objects.equals(lastElement, "*")){
//            return convertedList.stream()
//                    .mapToInt(number -> {
//                        int product = 1;
//                        product *= number;
//                        return product;
//                    });
        else return 0;
    }
}
