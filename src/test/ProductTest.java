import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void square() {
        Product product = new Product(0,2,4,6);
        int s = product.square();
        assertEquals(8, s);

    }
}