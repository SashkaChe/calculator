import java.util.*;
import java.util.stream.Collectors;

import exception.NonCorrectSymbol;
import exception.NonMathSymbol;

// Проверка введенных символов

public class Validator {

    private String text;

    public Validator (String text) throws Exception {

        ArrayList<String> split = new ArrayList<>();

        StringTokenizer token = new StringTokenizer(text.trim(), " 0123456789+-*/.");
        while(token.hasMoreElements()) {
            split.add(token.nextToken());
        }

        // проверка на недопустимые символы (буквы, знаки)

        if (split.size() > 0) {
            System.out.print("Введены недопустимые символы: ");

            for (String x : split) {
                System.out.print(x + " ");
            }
            throw new NonMathSymbol();
        } else {

            // если недопустимых символов нет, то
            // проверяем корректность расстоновки знаков (не должно быть двух знаков подряд или знаков в начале/конце строки и тд.)

            String nospace = text.replace(" ", "");

            String[] arr = nospace.split("[\\.\\*\\+\\-\\/]{2,}");

            if (!nospace.equals(Arrays.stream(arr).collect(Collectors.joining()))) {
                System.out.println("Выражение составлено не корректно.");
                throw new NonCorrectSymbol();
            } else {
                this.text = text.trim();
            }
        }

    }

    public String getText() {
        return text;
    }


}
