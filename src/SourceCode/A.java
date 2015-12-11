public class A implements Cloneable {

    int y;
    int x;

    public A(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public A clone() throws CloneNotSupportedException {
        return (A)super.clone();
    }
}
