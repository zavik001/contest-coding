import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> second = new LinkedList<>();
        String[] firstCards = reader.readLine().split(" ");
        String[] secondCards = reader.readLine().split(" ");
        for (int i = 0; i < 5; i++) {
            first.add(Integer.parseInt(firstCards[i]));
            second.add(Integer.parseInt(secondCards[i]));
        }
        int moves = 0;
        while (moves < 1000000 && !first.isEmpty() && !second.isEmpty()) {
            int a = first.poll();
            int b = second.poll();
            moves++;
            if ((a == 0 && b == 9) || (a > b && !(a == 9 && b == 0))) {
                first.add(a);
                first.add(b);
            } else {
                second.add(a);
                second.add(b);
            }
        }
        if (moves == 1000000 && !first.isEmpty() && !second.isEmpty()) {
            writer.write("botva");
        } else if (first.isEmpty()) {
            writer.write("second " + moves);
        } else {
            writer.write("first " + moves);
        }
        reader.close();
        writer.close();
    }
}
