import java.util.Scanner;

public class subSet {
    static int w[], x[], flag, sum, n, total, i, s, k, r;

    public void sumOfSubset(int s, int k, int r) {
        x[k] = 1;
        if (s + w[k] == sum) {
            System.out.println("The subset: ");
            for (i = 1; i <= k; i++) {
                flag = 1;
                if (x[i] == 1) {
                    System.out.println(w[i]);
                }
            }
        } else if (s + w[k] + w[k + 1] <= sum) {
            sumOfSubset(s + w[k], k + 1, r - w[k]);
        }
        if (s + r - w[k] >= sum && s + w[k + 1] <= sum) {
            x[k] = 0;
            sumOfSubset(s, k + 1, r - w[k]);
        }
    }

    public static void main(String args[]) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Enter the number of elements");
            n = s.nextInt();
            w = new int[n + 1];
            x = new int[n + 1];
            System.out.println("Enter the elements");
            for (int i = 1; i <= n; i++) {
                w[i] = s.nextInt();
                total = total + w[i];
            }
            System.out.println("Enter the sum");
            sum = s.nextInt();
        }
        if (total < sum) {
            System.out.println("subset is not possible");
            System.exit(0);
        }
        subSet ss = new subSet();
        ss.sumOfSubset(0, 1, total);
        if (flag == 0) {
            System.out.println("Subset not possible");
        }
    }
}