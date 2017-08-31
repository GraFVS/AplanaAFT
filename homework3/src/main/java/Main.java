public class Main {
    public static void main(String[] args) {

        // Создаем экзмепляры классов сладостей
        Sweetness candy = new Candy("Конфетки", 1.5, 290.49, "С ликёром");
        Sweetness jellybean = new Jellybean("Мармеладки", 0.9, 120.8, "Красные");
        Sweetness chocolate = new Chocolate("Шоколадки", 0.6, 319.90, "Пористый");
        Sweetness lollipop  = new Lolipop("Леденцы на палочке", 1.2, 109.30, "Круглые");

        // Создаем экземпляр класса подарка
        NYGift g = new NYGift(candy, jellybean, chocolate, lollipop);

        // Выводим на экран информацию о подарке
        g.printSweetnesssInfo();

        // Считаем и выводим на экран общий вес и общую стоимость подарка
        g.calculateTotalWeight();
        System.out.println("Масса подарка - " + g.getTotalWeight() + " кг.");
        g.calculateTotalPrice();
        System.out.println("Стоимость подарка - " + g.getTotalPrice() + " р.");

    }
}