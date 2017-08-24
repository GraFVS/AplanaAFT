import java.util.Scanner;

// Задание второе - работа со строками

public class task2 {
    public static void main(String[] args) {
        //Предусловия задачи
        String stroka = "Я хороший разработчик автотестов";
        System.out.println("Дана строка:");
        System.out.println(stroka);
        System.out.println("");

        //Заменить слово "хороший" на новое и вывести из образовавшейся строки слово "разработчик"
        editString(stroka);


    }

    public static void editString(String string) {
        // Замена слова "хороший" на новое
        System.out.println("Введите слово, на которое нужно заменить слово «хороший»:");
        Scanner sc = new Scanner(System.in);
        String newWord = sc.nextLine();
        String newString = string.replace("хороший", newWord);
        System.out.println("После замены строка выглядит следующим образом:");
        System.out.println(newString);

        // Вывод значения "разработчик" из полученной строки
        int charcount = newWord.length();
        System.out.println("- Кто-кто, вы говорите?");
        System.out.println("- " + newString.substring(3+charcount, 14+charcount) + "!");


    }

}
