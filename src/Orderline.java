
public class Orderline {
    private int numberOfProducts;
    private Product product;

    public Orderline(int numberOfProducts, Product product){
        this.numberOfProducts = numberOfProducts;
        this.product = product;
    }

    public int getNumberOfProducts(){
        return numberOfProducts;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "number of Products is " + numberOfProducts + ", " + product.toString();
    }


}
