import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] priorities = new int[n];
            Queue<Document> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                priorities[j] = scanner.nextInt();
                queue.offer(new Document(j, priorities[j]));
            }
            System.out.println(printOrder(queue, m));
        }
    }

    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static int printOrder(Queue<Document> queue, int m) {
        int order = 0;
        while (!queue.isEmpty()) {
            Document doc = queue.poll();
            boolean hasHigherPriority = queue.stream().anyMatch(d -> d.priority > doc.priority);
            if (hasHigherPriority) {
                queue.offer(doc);
            } else {
                order++;
                if (doc.index == m) {
                    break;
                }
            }
        }
        return order;
    }
}
