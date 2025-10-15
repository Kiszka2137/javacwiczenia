import java.util.Scanner;

public class zadania {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Program zawiera 6 zadań do wyboru:");
        System.out.println("1. Konwersja Celsjusz -> Fahrenheit");
        System.out.println("2. Znalezienie min i max spośród 3 liczb całkowitych");
        System.out.println("3. Obliczenie BMI");
        System.out.println("4. Obliczenie podatku dochodowego");
        System.out.println("5. Obliczenie miesięcznej raty za sprzęt AGD");
        System.out.println("6. Prosty kalkulator");
        System.out.print("Wybierz numer zadania (1-6): ");

        int wybor = scanner.nextInt();
        scanner.nextLine(); // czyścimy bufor

        switch (wybor) {
            case 1:
                konwersjaCelsiusToFahrenheit();
                break;
            case 2:
                minMaxTrzechLiczb();
                break;
            case 3:
                obliczBMI();
                break;
            case 4:
                obliczPodatek();
                break;
            case 5:
                obliczRateRatalna();
                break;
            case 6:
                prostyKalkulator();
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
        }

        System.out.println("Koniec programu. Naciśnij Enter aby zakończyć.");
        scanner.nextLine();
    }

    // 1. Konwersja Celsjusz -> Fahrenheit
    static void konwersjaCelsiusToFahrenheit() {
        System.out.print("Podaj temperaturę w stopniach Celsjusza: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = 1.8 * celsius + 32.0;
        System.out.printf("%.2f stopni Celsjusza to %.2f stopni Fahrenheita.\n", celsius, fahrenheit);
    }

    // 2. Min i max spośród 3 liczb całkowitych
    static void minMaxTrzechLiczb() {
        System.out.println("Podaj 3 liczby całkowite:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int min = a;
        int max = a;

        if (b < min) min = b;
        if (c < min) min = c;

        if (b > max) max = b;
        if (c > max) max = c;

        System.out.println("Najmniejsza liczba: " + min);
        System.out.println("Największa liczba: " + max);
    }

    // 3. Obliczenie BMI
    static void obliczBMI() {
        System.out.print("Podaj wagę w kilogramach: ");
        double waga = scanner.nextDouble();
        System.out.print("Podaj wzrost w metrach: ");
        double wzrost = scanner.nextDouble();

        double bmi = waga / (wzrost * wzrost);
        System.out.printf("Twoje BMI wynosi: %.2f\n", bmi);

        if (bmi < 18.5) {
            System.out.println("Niedowaga");
        } else if (bmi <= 24.9) {
            System.out.println("Waga prawidłowa");
        } else {
            System.out.println("Nadwaga");
        }
    }

    // 4. Obliczenie podatku dochodowego
    static void obliczPodatek() {
        System.out.print("Podaj dochód: ");
        double dochod = scanner.nextDouble();

        double podatek;

        if (dochod <= 85528) {
            podatek = 0.18 * dochod - 556.02;
            if (podatek < 0) podatek = 0;
        } else {
            podatek = 14839.02 + 0.32 * (dochod - 85528);
        }

        System.out.printf("Należny podatek: %.2f PLN\n", podatek);
    }

    // 5. Obliczenie miesięcznej raty ratalnej
    static void obliczRateRatalna() {
        double cena;
        int raty;

        // Pobieranie ceny - walidacja
        do {
            System.out.print("Podaj cenę towaru (100 - 10000 zł): ");
            cena = scanner.nextDouble();
            if (cena < 100 || cena > 10000) {
                System.out.println("Błędna wartość ceny. Spróbuj ponownie.");
            }
        } while (cena < 100 || cena > 10000);

        // Pobieranie liczby rat - walidacja
        do {
            System.out.print("Podaj liczbę rat (6 - 48): ");
            raty = scanner.nextInt();
            if (raty < 6 || raty > 48) {
                System.out.println("Błędna liczba rat. Spróbuj ponownie.");
            }
        } while (raty < 6 || raty > 48);

        double oprocentowanie;

        if (raty <= 12) {
            oprocentowanie = 0.025; // 2.5%
        } else if (raty <= 24) {
            oprocentowanie = 0.05; // 5%
        } else {
            oprocentowanie = 0.10; // 10%
        }

        double cenaZOdsetkami = cena * (1 + oprocentowanie);
        double rata = cenaZOdsetkami / raty;

        System.out.printf("Miesięczna rata wynosi: %.2f zł\n", rata);
    }

    // 6. Prosty kalkulator
    static void prostyKalkulator() {
        System.out.println("Prosty kalkulator - działania: +, -, *, /");

        System.out.print("Podaj pierwszą liczbę: ");
        double a = scanner.nextDouble();

        System.out.print("Podaj symbol działania (+, -, *, /): ");
        char op = scanner.next().charAt(0);

        System.out.print("Podaj drugą liczbę: ");
        double b = scanner.nextDouble();

        double wynik;
        boolean valid = true;

        switch (op) {
            case '+':
                wynik = a + b;
                break;
            case '-':
                wynik = a - b;
                break;
            case '*':
                wynik = a * b;
                break;
            case '/':
                if (b == 0) {
                    System.out.println("Błąd: dzielenie przez zero jest niemożliwe.");
                    valid = false;
                    wynik = 0;
                } else {
                    wynik = a / b;
                }
                break;
            default:
                System.out.println("Błąd: nieznany symbol działania.");
                valid = false;
                wynik = 0;
        }

        if (valid) {
            System.out.printf("Wynik: %.2f\n", wynik);
        }
    }
}