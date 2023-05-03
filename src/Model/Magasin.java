package Model;

public class Magasin
{
    private String name;
    private Road road;

    public Magasin(String name, Road road)
    {
        this.name= name;
        if(road!= null)
        {
            this.road=road;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }
}