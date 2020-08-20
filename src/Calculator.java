import java.io.*;



public class Calculator {
    public static void main(String[] args) throws Exception {


        System.out.println("Допускается ввод только цифр и знаков математических операций. Для дробных чисел используйте '.' в качестве разделителя.\n" +
                "Если числа разделены пробелами и между ними нет никаких знаков, то они будут объединины в одно число (было 4 5, столо 45).");

        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        Validator val = new Validator(obj.readLine());
        Parsing pars = new Parsing(val);
        new Math().mathOperation(pars);

    }
}
