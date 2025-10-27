import java.util.Scanner;

public class zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę całkowitą dodatnią: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Podana liczba nie jest dodatnia!");
        } else {
            System.out.println("Liczby nieparzyste nie większe od " + n + ":");
            for (int i = 1; i <= n; i += 2) {
                System.out.print(i);
                if (i + 2 <= n) System.out.print(", ");
            }
        }

        scanner.close();
    }
}