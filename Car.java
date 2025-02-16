public class Car {
    private final String modeli;
    private boolean holati = true;
    private int narxi;

    public Car(String modeli, int narxi) {
        this.modeli = modeli;
        this.narxi = narxi;
    }

    public boolean isHolati() {
        return holati;
    }


    public String getModeli() {
        return modeli;
    }

    public boolean setHolati(boolean holati) {
        this.holati = holati;
        return holati;
    }

    public int getNarxi() {
        return narxi;
    }

    @Override
    public String toString() {
        return "Modeli = " + modeli + "  Narxi = " + narxi;
    }
}