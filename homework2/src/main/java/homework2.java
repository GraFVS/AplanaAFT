import java.util.Scanner;

public class homework2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int charCount;
        //вызов метода запроса количества символов в будущем массиве
        charCount = askCharCount();

        int[] workArray = new int[charCount];
        //вызов метода инициализации массива
        workArray = enterArray(workArray, charCount);
        //вызов метода вывода массива в строчку
        System.out.println("Введённый массив выглядит следующим образом:");
        showArrayInString(workArray, charCount);

        //Цикл опроса сканера в поисках валидных точек входа
        String input;
        do {
            System.out.println("Для продолжения работы введите в консоль следующие символы:");
            System.out.println("«1» - Ваш массив будет отсортирован по убыванию");
            System.out.println("«2» - Будет выведена сумма наибольшего и наименьшего элемента Вашего массива");
            System.out.println("«3» - Программа найдёт, какой число повторяется в Вашем массиве чаще всего посчитает, сколько раз");
            System.out.println("«q» - Выход из программы");
            input = scanner.nextLine();
            switch (input){
                case "1":
                    //Выполнение кейса 1
                    System.out.println("Отсортируем его по убыванию:");
                    int[] sortedArray = selectionSort(workArray); //отсортировать массив по убыванию
                    showArrayInString(sortedArray, sortedArray.length); //вывести отсортированный массив в строчку через пробел
                    break;
                case "2":
                    //Выполнение кейса 2
                    System.out.println("Найдём сумму наибольшего и наименьшего элемента:");
                    System.out.println(findMaxElement(workArray)+findMinElement(workArray)); //выводим на экран сумму макс. и мин. элементов, найденных через вызов методов
                    break;
                case "3":
                    //Выполнение кейса 3
                    findMostCommonElement(workArray);
                    break;
                case "q":
                case "Q":
                case "КУ!":
                    System.out.println("Завершение работы программы");
                    break;
                default:
                    System.out.println("Неправильно, попробуй ещё");
                    break;
            }
        } while ((!input.equals("q")&&(!input.equals("Q"))&&(!input.equals("КУ!"))));
    }


    //Метод для выяснения количества элементов массива
    public static int askCharCount() {
        System.out.println("Введите число элементов создаваемго массива (не более 20)"); //просим юзера ввести число элементов массива
        Scanner scanner = new Scanner(System.in);
        int charCount = scanner.nextInt();                        //чтение числа эл.массива сканером
        if ((charCount <= 20) & (charCount > 0)) {                      //проверка числа элементов
        } else {
            do {
                System.out.println("Вы что-то делаете не так. Попробуйте ещё (от 1 до 20)");
                charCount = scanner.nextInt();
            }
            while ((charCount > 20) || (charCount < 1));
        }
        return charCount;
    }

    //Метод для инициализации массива
    public static int[] enterArray(int[] newArray, int charCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Отлично! Теперь по очереди введите элементы Вашего массива."); //
        for (int i = 0; i < charCount; i++) {
            newArray[i] = scanner.nextInt();
            }
        return newArray;
    }

    //Метод для вывода всех элементов массива в строчку
    public static void showArrayInString(int[] array, int charCount) {
        for (int i = 0; i <charCount; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    //Метод сортировки по убыванию
    public static int[] selectionSort(int[] arr){
            for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int max_i = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    max_i = j;
                }
            }
            if (i != max_i) {
                int tmp = arr[i];
                arr[i] = arr[max_i];
                arr[max_i] = tmp;
            }
        }
        return arr;
    }

    //Метод поиска наибольшего элемента массива
    public static int findMaxElement(int[] arr){
        int max = arr[0];
        for (int i=1; i<arr.length; i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    //Метод поиска наименьшего элемента массива
    public static int findMinElement(int[] arr){
        int min = arr[0];
        for (int i=1; i<arr.length; i++){
            if (arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    //Метод поиска наиболее повторяющегося элемента
    public static void findMostCommonElement(int[] arr){
        int maxCommonValue = arr[0];
        int maxCommonCount = 1;
        int curCommonValue;
        int curCommonCount;
        for (int i=0; i<arr.length; i++){
            curCommonValue = arr[i];
            curCommonCount = 1;
            for (int j=i+1; j<arr.length; j++){
                                if (arr[j]==curCommonValue){
                    curCommonCount++;
                }
                if (curCommonCount>maxCommonCount){
                    maxCommonCount=curCommonCount;
                    maxCommonValue=arr[j];
                }
            }
        }
        System.out.println("Чаще всего встречается элемент со значением " + maxCommonValue);
        System.out.println("Количество повторений: " + maxCommonCount);
    }
}

