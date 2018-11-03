import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Case> cases = new ArrayList<>();
        cases.add(new Case(0, 21, 15, 6));
        cases.add(new Case(1, 11, 8, 6));
        cases.add(new Case(2, 11, 8, 6));

        List<Orderline> orderList = new ArrayList<>();
        orderList.add(new Orderline(5, new Product(1, 6, 12, 2)));
        orderList.add(new Orderline(10, new Product(2, 4, 5, 2)));
        orderList.add(new Orderline(6, new Product(3, 6, 10, 2)));


        //packing
        System.out.println(orderList);
        Packing packing = new Packing(orderList, cases);
        packing.CasePacking();



    }
}
