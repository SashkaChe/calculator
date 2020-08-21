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

        // получаем значение выражения на основе обартной польской записи
        ArrayList<Double> num = new ArrayList<>();

        for(int i = 0; i < polka.size();) {

            switch (polka.get(i)) {

                case "*":

                    Double y = num.get(num.size()-2) * num.get(num.size()-1);

                    num.set(num.size()-2, y);
                    num.remove(num.size()-1);
                    polka.remove(polka.get(i));
                    i = 0;

                    break;

                case "/":


                    Double s = num.get(num.size()-2) / num.get(num.size()-1);

                    num.set(num.size()-2, s);
                    num.remove(num.size()-1);
                    polka.remove(polka.get(i));


                    break;


                case "+":

                    Double z = num.get(num.size()-2) + num.get(num.size()-1);

                    num.set(num.size()-2, z);
                    num.remove(num.size()-1);
                    polka.remove(polka.get(i));


                    break;

                case "-":

                    Double d = num.get(num.size()-2) - num.get(num.size()-1);

                    num.set(num.size()-2, d);
                    num.remove(num.size()-1);
                    polka.remove(polka.get(i));


                    break;

                default:

                    num.add(Double.parseDouble(polka.get(i)));
                    polka.remove(polka.get(i));


            }
        }
        System.out.print(num.get(0));

    }

}
