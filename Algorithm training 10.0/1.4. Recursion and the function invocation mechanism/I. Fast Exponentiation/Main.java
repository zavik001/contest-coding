import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class Main {

    public static double power(double a, long n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            double x = power(a, n / 2);
            return x * x;
        }
        return a * power(a, n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        double a = Double.parseDouble(reader.readLine());
        long n = Long.parseLong(reader.readLine());
        DecimalFormat format = new DecimalFormat("0.##########");
        writer.write(format.format(power(a, n)));
        reader.close();
        writer.close();
    }
}
