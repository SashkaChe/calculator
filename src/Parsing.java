import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parsing {

    private ArrayList<String> formula = new ArrayList<>();

    public Parsing(){
    }

    public Parsing (Validator obj) throws Exception {

        Pattern patt = Pattern.compile("([0-9]{0,})([\\*\\+\\-\\/\\.]{0,})");
        Matcher match = patt.matcher(obj.getText().replace(" ", ""));

        while (match.find()) {

            formula.add(match.group(1));
            formula.add(match.group(2));

        }

        for (int i = 0; i < formula.size()-1; i++) {

            if (formula.get(i).equals(".")) {

                String x = formula.get(i-1) + formula.get(i) + formula.get(i+1);
                formula.set(i, x);
                formula.remove(i+1);
                formula.remove(i-1);

            }

        }
    }
    public ArrayList<String> getArray() {
        return formula;
    }
}

