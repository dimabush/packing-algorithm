public class Product extends Dimension {

    public Product(int id, int sizeX, int sizeY, int sizeZ) {
        super(id, sizeX, sizeY, sizeZ);
    }


    public int square() {
        return (this.getSizeX() * this.getSizeY());
    }

    public void rotate(){
        int temp = getSizeX();
        setSizeX(getSizeY());
        setSizeY(temp);
    }


}
