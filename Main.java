import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<Car> carList;
    public static ArrayList<Customer> customerList;

    public static void main(String[] args) {

        customerList = new ArrayList<>();
        carList = new ArrayList<>();

        // Mashinalar ro'yhati
        carList.add(new Car("BMW",110));
        carList.add(new Car("MERS",70));
        carList.add(new Car("NISSAN",100));
        carList.add(new Car("FERRARI",200));
        carList.add(new Car("TOYOTA",80));

        // Mijozlar ro'yhati
        customerList.add(new Customer("Jumaniyozov Laylak", "000 tapolmin o'l", 200));
        customerList.add(new Customer("Jumaniyozov Qumri", "000 tapolmin o'l", 60));
        customerList.add(new Customer("O'jji tros", "+99899999999", 90));
        customerList.add(new Customer("O'lmas g'altak", "+998888888888", 120));
        customerList.add(new Customer("Ganjavoy", "+998562300101", 85));

        System.out.println(sotish(customerList.get(0), carList));
        System.out.println(sotish(customerList.get(0), carList));
    }

    // Mashina sotish jarayoni

    public static String sotish(Customer customer, ArrayList<Car> carList){
        if (customer.getBudjet() > 0){
            boolean xabar = true;
            System.out.println("Mijoz " + customer.getFio() + "ning budjeti: " + customer.getBudjet());
            for (Car car : carList) {
                if (car.isHolati() && car.getNarxi() <= customer.getBudjet()){
                    System.out.println(car);
                    xabar = false;
                }
            }
            if (xabar){
                return "Mijozga mos mashina topilmadi";
            }else {
                Scanner sc = new Scanner(System.in);
                System.out.println("Kerakli mashinani tanlash uchun mashinaning nomini yozing!");
                System.out.print("Enter: ");
                String tanlashSozi = sc.next();
                if (tanlashSozi.equals("BMW") || tanlashSozi.equals("bmw") && carList.get(0).isHolati()) {
                    customerList.remove(customer);
                    Main.carList.remove(carList.get(0));
                } else if (tanlashSozi.equals("MERS") || tanlashSozi.equals("mers") && carList.get(1).isHolati()) {
                    customerList.remove(customer);
                    Main.carList.remove(carList.get(1));
                } else if (tanlashSozi.equals("NISSAN") || tanlashSozi.equals("nissan") && carList.get(2).isHolati()) {
                    customerList.remove(customer);
                    Main.carList.remove(carList.get(2));
                } else if (tanlashSozi.equals("FERRARI") || tanlashSozi.equals("ferrari") && carList.get(3).isHolati()) {
                    customerList.remove(customer);
                    Main.carList.remove(carList.get(3));
                } else if (tanlashSozi.equals("TOYOTA") || tanlashSozi.equals("toyota") && carList.get(4).isHolati()) {
                    customerList.remove(customer);
                    Main.carList.remove(carList.get(4));
                } else {
                    System.out.println("Xato");
                }
            }
        }else {
            return "Mijozning mablag'i moshina sotib olishga yetarli emas";
        }

        // Qolgan mashinalarni ekranga chiqaramiz

        System.out.println("Qolgan mashinalar ro'yhati: ");
        for (Car cars : carList) {
            System.out.println(cars);
        }
        return " ";
    }


    public static String registratsiya(Customer customer, Car car){
        if (customer.getMashin() == null && car.isHolati()) {
            car.setHolati(false);
            customer.setMashin(car);
        }else {
            if (car.isHolati()){
                if (bekorQilish(customer)){
                    customer.setMashin(car);
                    car.setHolati(false);
                }else {
                    return " ";
                }
                return "Mashina almashtirildi";
            }else {
                return "Bu mijozga tegishli mashina";
            }
        }
        return "Mijozga mashina qo'shildi";
    }

    public static boolean bekorQilish(Customer customer) {
        Car car = customer.getMashin();

        int rating = rate();
        if (rating >= 4) {
            car.setHolati(true);
            customer.setMashin(null);
            return true;
        } else {
            double jarima = switch (rating) {
                case 1 -> car.getNarxi() * 0.6;
                case 2 -> car.getNarxi() * 0.3;
                case 3 -> car.getNarxi() * 0.1;
                default -> 0;
            };
            int newBudget = customer.getBudjet() - (int)jarima;
            customer.setBudjet(newBudget);
            System.out.println("Mashina sifati yaxshi emas!");
            System.out.println("Mijoz " + customer.getFio() + " to'laydigan summa: " + (int)jarima + "$");
            return false;
        }
    }


    public static int rate(){
        Random random = new Random();
        int randomNumber = random.nextInt(4) + 1;
        System.out.println("Mashina sifatiga berilgan baho: " + randomNumber);
        return randomNumber;
    }
}
