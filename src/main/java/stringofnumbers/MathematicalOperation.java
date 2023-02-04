package stringofnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MathematicalOperation {

    public int action(final String numbers) {
        List<String> listOfStrings = new ArrayList<>(List.of(numbers.split("[,;.]")));
        String lastElement = listOfStrings.get(listOfStrings.size() - 1);
        listOfStrings.remove(listOfStrings.size() - 1);
        List<Integer> convertedList = new ArrayList<>();
        for (String number : listOfStrings) {
            convertedList.add(Integer.parseInt(number));
        }

        if (Objects.equals(lastElement, "+")) {
            return convertedList.stream().mapToInt(number -> {
                int result = 0;
                result += number;
                return result;
            }).sum();
        } else if (Objects.equals(lastElement, "-")) {
            return convertedList.stream().mapToInt(number -> -number).sum();
        } else if (Objects.equals(lastElement, "*")) {
            int multiplicationResult = 1;
            for (int number : convertedList) {
                multiplicationResult *= number;
            }
            return multiplicationResult;
        } else if (Objects.equals(lastElement, "/")) {
            int divisionResult = convertedList.get(0) * convertedList.get(0);
            for (int number : convertedList) {
                divisionResult /= number;
            }
            return divisionResult;
        }
        return 0;
    }
}
