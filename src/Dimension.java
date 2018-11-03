public class Dimension {
    private int id;
    private int sizeX;
    private int sizeY;
    private int sizeZ;


    Dimension(int id, int x, int y, int z) {
        this.id = id;
        this.sizeX = x;
        this.sizeY = y;
        this.sizeZ = z;
    }

    public int getId() {
        return id;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX){
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getSizeZ() {
        return sizeZ;
    }

    @Override
    public String toString() {
        return "id = " + getId() + ", (" + getSizeX() + ", " + getSizeY() + ", " + getSizeZ() + ") ";
    }
}
