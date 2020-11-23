import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        Comparator<int[]> edgeComparator = Comparator.comparing((int[] arr) -> arr[0])
                                                    .thenComparingInt(arr -> arr[1]);
//        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);  // 오름차순
        PriorityQueue<int[]> queue = new PriorityQueue<>(edgeComparator);

        queue.add(new int[] {0, 10});  // [거리, 출발점]
        queue.add(new int[] {0, 4});
        queue.add(new int[] {0, 3});
        queue.add(new int[] {0, 8});
        queue.add(new int[] {0, 20});
        queue.add(new int[] {1, 0});
        queue.add(new int[] {-2, 0});

//        int[] popped = new int[2];
        while (!queue.isEmpty()) {
            int[] popped = queue.poll();
            System.out.println(popped[0] + " " + popped[1]);
        }

    }
}
