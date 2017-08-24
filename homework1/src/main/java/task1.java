import java.util.Scanner;

// Задание первое - решение уравнения

public class task1 {
    public static void main(String[] args) {
        // Считываем с консоли x и y
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите значение x:");
        int x = sc.nextInt();
        System.out.println("Введите значение y:");
        int y = sc.nextInt();

        System.out.println("Ответ: " + calculate(x , y));
    }

    // Вычисление уравнения
    public static double calculate(int x, int y) {
        return (double) (3 * (x + 2 * x - y)) / (2 * x);
    }
}