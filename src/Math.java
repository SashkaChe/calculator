import java.util.ArrayList;
import java.util.Arrays;

public class Math {

    public void mathOperation(Parsing pars) throws Exception {

        ArrayList<String> formula = pars.getArray();

        ArrayList<String> polka = new ArrayList<>();
        ArrayList<String> znaki = new ArrayList<>();


        // преобразование в обратную польскую запись

        for(int i = 0; i < formula.size(); i++) {

switch (formula.get(i)) {

    case "*":
    case "/":
        if (znaki.size() < 1) {
            znaki.add(formula.get(i));
        } else {
            if (znaki.get(znaki.size()-1).equals("-") || znaki.get(znaki.size()-1).equals("+")) {
                znaki.add(formula.get(i));
            } else {
                polka.add(znaki.get(znaki.size()-1));
                znaki.remove(znaki.size()-1);
                znaki.add(formula.get(i));
            }
        }

        break;
    case "+":
    case "-":
        if (znaki.size() < 1) {
            znaki.add(formula.get(i));
        } else {

            while (znaki.size() > 0) {
                polka.add(znaki.get(znaki.size()-1));
                znaki.remove(znaki.size()-1);
            }

            znaki.add(formula.get(i));

        }

        break;

    default:polka.add(formula.get(i));
}
        }
        while (znaki.size() > 0) {
            polka.add(znaki.get(znaki.size()-1));
            znaki.remove(znaki.size()-1);
        }

        // удаляем мусор из листа
        polka.removeAll(Arrays.asList("", null));
        System.out.println(polka.size());

        // получаем значение выражения на основе обартной польской записи
        double x = Double.parseDouble(polka.get(0));
        double y = 0;

        for(int i = 1; i < polka.size(); i++) {

            switch (polka.get(i)) {

                case "*": x = x * y; break;
                case "/": x = x / y; break;
                case "+": x = x + y; break;
                case "-": x = x - y; break;

                default: y = Double.parseDouble(polka.get(i));
            }
        }
        System.out.println(x);

    }

}
