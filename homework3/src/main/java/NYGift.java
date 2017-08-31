public class NYGift {
    private double totalWeight;
    private double totalPrice;
    private Sweetness[] Sweetnesss;

    public NYGift(Sweetness... Sweetness) {
        for(Sweetness sw : Sweetness) {
            this.Sweetnesss = Sweetness;
        }
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void calculateTotalWeight() {
        for (int i = 0; i < Sweetnesss.length; i++) {
            this.totalWeight += Sweetnesss[i].getWeight();
        }
    }

    public void calculateTotalPrice() {
        for (int i = 0; i < Sweetnesss.length; i++) {
            this.totalPrice += Sweetnesss[i].getPrice();
        }
    }

    public void printSweetnesssInfo() {
        System.out.println("Содержимое новогоднего подарка: ");
        for (int i = 0; i < Sweetnesss.length; i++) {
            System.out.println(Sweetnesss[i].toString());
        }
        System.out.println("_________________________________________________________________________________");
    }
}