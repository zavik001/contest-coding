import java.util.*;

public class RectangleIntersections {

    static class Rectangle {
        int id;
        int xL, yL, xR, yR;

        public Rectangle(int id, int xL, int yL, int xR, int yR) {
            this.id = id;
            this.xL = xL;
            this.yL = yL;
            this.xR = xR;
            this.yR = yR;
        }

        public boolean intersects(Rectangle other) {
            return this.yL < other.yR && this.yR > other.yL;
        }
    }

    static class Event implements Comparable<Event> {
        int x;
        Rectangle rect;
        boolean isStarting;

        public Event(int x, Rectangle rect, boolean isStarting) {
            this.x = x;
            this.rect = rect;
            this.isStarting = isStarting;
        }

        @Override
        public int compareTo(Event other) {
            if (this.x != other.x) return Integer.compare(this.x, other.x);
            return Boolean.compare(other.isStarting, this.isStarting); 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        List<Rectangle> rectangles = new ArrayList<>();
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int xL = scanner.nextInt();
            int yL = scanner.nextInt();
            int xR = scanner.nextInt();
            int yR = scanner.nextInt();
            Rectangle rect = new Rectangle(i, xL, yL, xR, yR);
            rectangles.add(rect);
            events.add(new Event(xL, rect, true));  
            events.add(new Event(xR, rect, false)); 
        }

        Collections.sort(events);

        int[] intersections = new int[n];
        TreeSet<Rectangle> activeRectangles = new TreeSet<>(Comparator.comparingInt(r -> r.yL));

        for (Event event : events) {
            Rectangle rect = event.rect;
            if (event.isStarting) {
                
                for (Rectangle active : activeRectangles) {
                    if (rect.intersects(active)) {
                        intersections[rect.id]++;
                        intersections[active.id]++;
                    }
                }
                activeRectangles.add(rect);
            } else {
                activeRectangles.remove(rect);
            }
        }

        
        for (int count : intersections) {
            System.out.print(count + " ");
        }
    }
}
