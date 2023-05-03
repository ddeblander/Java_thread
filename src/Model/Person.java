package Model;

public class Person
{
    private String name;
    private float kph;
    private Road r;
    public Person(String name, float kph, Road r)
    {
        this.name = name;
        this.kph = kph;
        this.r = r;

    }


    public float Walking( Road rE)
    {
        if((rE != null)&&(r!= null))
        {
            int xB =r.getX();
            int xE=rE.getX();
            int yB =r.getY();
            int yE =rE.getY();

            return((xE-xB)+(yE-yB));
        }
        System.out.println("une Road est null dans Walking");
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getKph() {
        return kph;
    }

    public void setKph(float kph) {
        this.kph = kph;
    }

    public Road getR() {
        return r;
    }

    public void setR(Road r) {
        this.r = r;
    }
}