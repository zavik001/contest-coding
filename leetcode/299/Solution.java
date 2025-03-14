// https://leetcode.com/problems/bulls-and-cows/?envType=problem-list-v2&envId=hash-table
// reminder stream api))
import java.util.Map;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static String getHint(String secret, String guess) {
        if (secret.length() != guess.length()) {
            return "";
        }

        AtomicInteger k = new AtomicInteger();
        int b = 0;

        Map<Character, Integer> sm = new HashMap<>();
        Map<Character, Integer> gm = new HashMap<>();

        IntStream.range(0, secret.length()).forEach(i -> {
            if (secret.charAt(i) == guess.charAt(i)) {
                k.incrementAndGet();
            } else {
                sm.put(secret.charAt(i), sm.getOrDefault(secret.charAt(i), 0) + 1);
                gm.put(guess.charAt(i), gm.getOrDefault(guess.charAt(i), 0) + 1);
            }
        });

        b = sm.keySet().stream()
                .filter(gm::containsKey)
                .mapToInt(r -> Math.min(sm.get(r), gm.get(r)))
                .sum();

        return k.get() + "A" + b + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("111", "111"));
    }
}