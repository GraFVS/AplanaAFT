public class Lolipop extends Sweetness {
    private String shape;

    public Lolipop(String name, double weight, double price, String shape) {
        super(name, weight, price);
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return super.toString() + " , Форма = " + getShape() + ".";
    }
}