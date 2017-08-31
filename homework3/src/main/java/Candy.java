public class Candy extends Sweetness {
    private String filling;

    public Candy(String name, double weight, double price, String filling) {
        super(name, weight, price);
        this.filling = filling;
    }

    public String getfilling() {
        return filling;
    }

    public void setfilling(String filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return super.toString() + " , Начинка = " + getfilling() + ".";
    }
}