public class Customer {
    private String fio;
    private String tel;
    private Car mashin;
    private int budjet;

    public Customer(String fio, String tel){
        this.fio = fio;
        this.tel = tel;
    }
    public Customer(String fio, String tel, int budjet){
        this.fio = fio;
        this.tel = tel;
        this.budjet = budjet;
    }

    public String getFio() {
        return fio;
    }

    public Car getMashin() {
        return mashin;
    }

    public String getTel() {
        return tel;
    }

    public void setMashin(Car mashin) {
        this.mashin = mashin;
    }

    public int getBudjet() {
        return budjet;
    }

    public void setBudjet(int budjet) {
        this.budjet = budjet;
    }
}
