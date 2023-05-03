package Model;

public class Road
{
    private String name;
    private int x, y;
    public Road(String name, int x, int y)
    {
        this.name = name;

        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(short x) {
        this.x = x;
    }

    public void setY(short y) {
        this.y = y;
    }
}