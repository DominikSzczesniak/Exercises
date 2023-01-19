package stringofnumbers;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NumbersApp {

    public static void main(String[] args) {
        MathematicalOperation mathematicalOperation = new MathematicalOperation();

        System.out.println("Addition: " + mathematicalOperation.action("12,34,56;67,+"));
        System.out.println("Substraction: " + mathematicalOperation.action("14.14,36;2,-"));
        System.out.println("Multiplication: " + mathematicalOperation.action("3,4,2,*"));

    }
}
