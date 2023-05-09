package ViewModel;

import Model.Magasin;
import Model.Person;
import Model.Road;

public class MoveToMag
{
    public static int Moving(Person p, Road r)
    {
        float time = (p.Walking( r)/ (float)p.getKph());
        int timeInt=Math.abs((int)time*2);
        System.out.println("temps d'attente :"+timeInt);
        System.out.println("vitesse de la personne "+(float)p.getKph());
        if (time > 1)
        {

            return timeInt;
        }
        return 1000;
    }
}