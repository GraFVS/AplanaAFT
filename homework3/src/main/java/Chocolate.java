public class Chocolate extends Sweetness {
    private String porisity;

    public Chocolate(String name, double weight, double price, String porisity) {
        super(name, weight, price);
        this.porisity = porisity;
    }

    public String getporisity() {
        return porisity;
    }

    public void setporisity(String porisity) {
        this.porisity = porisity;
    }

    @Override
    public String toString() {
        return super.toString() + " , Вид шоколада = " + getporisity() + ".";
    }
}