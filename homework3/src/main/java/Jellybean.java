public class Jellybean extends Sweetness {
    private String color;

    public Jellybean(String name, double weight, double price, String color) {
        super(name, weight, price);
        this.color = color;
    }

    public String getcolor() {
        return color;
    }

    public void setcolor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " , Цвет = " + getcolor() + ".";
    }
}