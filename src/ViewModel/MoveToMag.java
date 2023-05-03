package ViewModel;

import Model.Magasin;
import Model.Person;

public class MoveToMag
{
    public static int Moving(Person p, Magasin m)
    {
        float time = p.Walking(m.getRoad()) / (float)p.getKph();
        System.out.println(time);
        System.out.println(p.Walking(m.getRoad()));
        System.out.println((float)p.getKph());
        if (time > 1)
        {

            return Math.abs((int)time*5);
        }
        return 1000;
    }
}