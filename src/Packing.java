import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class Packing {
    private List<Orderline> orderList;
    private List<Case> cases;

    public Packing(List<Orderline> orderList, List<Case> cases) {
        this.orderList = orderList;
        this.cases = cases;
    }

    // places the product with largest surface area first in the list
    public List<Orderline> sortOrderList(){
        this.orderList.sort(new Comparator<Orderline>() {
            @Override
            public int compare(Orderline o1, Orderline o2) {
                return o1.getProduct().square() > o2.getProduct().square() ? -1 : 0;
            }
        });
//        System.out.println("sorted list: " + orderList);
        return orderList;
    }

    // rotate horizontally so X was longer side
    public List<Orderline> rotateOrderList(){
        for (Orderline x : this.orderList) {
            if (x.getProduct().getSizeX() < x.getProduct().getSizeY())
                x.getProduct().rotate();
        }
//        System.out.println("rotated list: " + orderList);
        return orderList;
    }

    public void Packing(int x, int y) {
        ListIterator<Orderline> listiter = this.orderList.listIterator();
        while (listiter.hasNext()) {
            Orderline order = listiter.next();
            if (order.getProduct().getSizeX() <= x && order.getProduct().getSizeY() <= y && order.getNumberOfProducts() > 0) {
//                System.out.println("This product is fit in  (" + x + ", " + y + ") : " + order);
                System.out.println("product: " + order.getProduct());
                listiter.set(new Orderline(order.getNumberOfProducts() - 1, order.getProduct()));

                Packing(order.getProduct().getSizeX(), y - order.getProduct().getSizeY());

                Packing(x-order.getProduct().getSizeX(), y);

                break;
            }
        }
    }

    public void CasePacking() {
        int sizeZ = this.orderList.get(0).getProduct().getSizeZ();
        sortOrderList();
        rotateOrderList();
        for (Case box : this.cases) {
            System.out.printf("In case id = %d places:%n", box.getId());
            for (int i = 1; i <= box.getSizeZ() / sizeZ; i++) {
                System.out.printf("Level %d: %n", i);
                Packing(box.getSizeX(), box.getSizeY());
            }
        }
    }
}
