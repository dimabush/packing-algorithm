import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PackingTest {
    private Packing packing;
    private Orderline order1 = new Orderline(5, new Product(1, 6, 12, 2));
    private Orderline order2 = new Orderline(10, new Product(2, 5, 4, 2));
    private Orderline order3 = new Orderline(6, new Product(3, 6, 10, 2));

    @Before
    public void setUp() throws Exception {
        List<Orderline> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        List<Case> cases = new ArrayList<>();
        cases.add(new Case(0, 21, 15, 6));

        packing = new Packing(orderList, cases);
    }

    @After
    public void tearDown() throws Exception {
        packing = null;
    }

    @Test
    public void sortOrderList() {
        /*Orderline order1 = new Orderline(5, new Product(1, 6, 12, 2));
        Orderline order2 = new Orderline(10, new Product(2, 4, 5, 2));
        Orderline order3 = new Orderline(6, new Product(3, 6, 10, 2));

        List<Orderline> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        List<Case> cases = new ArrayList<>();
        cases.add(new Case(0, 21, 15, 6));

        Packing packing = new Packing(orderList, cases);*/

        List<Orderline> expected = packing.sortOrderList();

        List<Orderline> actual = new ArrayList<>();
        actual.add(order1);
        actual.add(order3);
        actual.add(order2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rotateOrderList() {
        List<Orderline> expected = packing.rotateOrderList();

        order1.getProduct().rotate();
        order3.getProduct().rotate();
        List<Orderline> actual = new ArrayList<>();
        actual.add(order1);
        actual.add(order2);
        actual.add(order3);

        Assert.assertEquals(expected, actual);
    }

}