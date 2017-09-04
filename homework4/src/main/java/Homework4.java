import java.util.*;

public class Homework4 {
    public static void main(String[] args) {
        // создание мапы
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Фёдор Смолов", 18);
        map.put("Беким Балай", 9);
        map.put("Артем Дзюба", 13);
        map.put("Жулиано", 8);
        map.put("Мануэл Фернандеш", 7);
        map.put("Квинси Промес", 12);
        map.put("Дмитрий Полоз", 7);
        map.put("Денис Глушаков", 8);
        map.put("Ари", 12);
        map.put("Жонатас", 9);
        map.put("Сердар Азмун", 7);
        map.put("Сергей Корниленко", 8);
        map.put("Аблай Мбенг", 7);

        // вызов метода сортировки мапы
        Map<String, Integer> sortedMap = sortRevers(map);

        // задание 1
        System.out.println("Число забитых мячей по убыванию:");
        printCollection(sortedMap.values());
        System.out.println("---------------------------------");

        // задание 2
        System.out.println("Список бобмардиров сезона 2016/2017:");
        printMap(sortedMap);
        System.out.println("---------------------------------");

        // задание 3
        System.out.println("3 лучших бомбардира:");
        printMapTop3(sortedMap);

    }

    // метод сортировки мапы в обратном порядке
    public static Map<String, Integer> sortRevers(Map<String, Integer> map) {
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        Collections.sort(list);
        for (int i = list.size(); i > 0; i--) {
            for (Map.Entry<String, Integer> current : map.entrySet()) {
                if (current.getValue().equals(list.get(i - 1)))
                    sortedMap.put(current.getKey(), current.getValue());
            }
        }
        return sortedMap;
    }

    // метод вывода коллекции
    public static void printCollection(Collection<Integer> col) {
        for (int i : col) {
            System.out.println(i);
        }
    }

    // метод вывода мапы
    public static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> current : map.entrySet()) {
            System.out.println(current.getKey()+" - "+current.getValue());
        }
    }

    // метод вывода первых 3х записей мапы
    public static void printMapTop3(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        for (int i = 0; iterator.hasNext() && i < 3; i++) {
            Map.Entry<String, Integer> current = iterator.next();
            System.out.println(current.getKey()+" - "+current.getValue());
        }
    }
}