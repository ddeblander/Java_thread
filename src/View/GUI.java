package View;

import Model.Magasin;
import Model.Person;
import Model.Road;
import ViewModel.MoveToMag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame implements ActionListener
{
    private JList<String> list1, list2;
    private List<Person> persons;
    private List<Road> roads;
    private List<Magasin> magasins;
    private DefaultListModel<String> model1, model2;
    private JButton addButton1, addButton2;
    public GUI()
    {
        super("Thread demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        populate();

        model1 = new DefaultListModel<>();
        for(Person p:persons)
        {
            model1.addElement(p.getName());
        }

        list1 = new JList<>(model1);
        JScrollPane scrollPane1 = new JScrollPane(list1);

        model2 = new DefaultListModel<>();
        list2 = new JList<>(model2);
        JScrollPane scrollPane2 = new JScrollPane(list2);

        addButton1 = new JButton("walk persons to magasin");
        addButton1.addActionListener(this);

        addButton2 = new JButton("Person return Home");
        addButton2.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton1);
        buttonPanel.add(addButton2);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(scrollPane1, BorderLayout.WEST);
        contentPanel.add(scrollPane2, BorderLayout.EAST);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(contentPanel);
        pack();
        setLocationRelativeTo(null);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton1) {
            int id=0;
            for(Person p:persons)
            {
                try {
                    System.out.println(Thread.activeCount());
                    System.out.println("Thread :"+Thread.currentThread());
                    Thread.sleep(MoveToMag.Moving(p,magasins.get(id).getRoad()));
                    p.setR(magasins.get(id).getRoad());

                    id++;
                    model1.removeElement(p.getName());
                    model2.addElement(p.getName());
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }

        } else if (e.getSource() == addButton2)
        {
            for(Person p:persons)
            {
                System.out.println("nombre de thread actifs : "+Thread.activeCount());
                Thread asyncThread = new Thread(()->
                {

                    {
                        try
                        {

                            System.out.println("Thread :"+Thread.currentThread().threadId());
                            Thread.sleep(MoveToMag.Moving(p,p.getPreviousR()));
                            model2.removeElement(p.getName());
                            model1.addElement(p.getName());
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }


                    }

                });
                asyncThread.start();
            }





        }
    }
    private void populate()
    {
        persons= new ArrayList<>();
        roads= new ArrayList<>();
        magasins= new ArrayList<>();
        roads.add(new Road("rue cédric",0,0));
        roads.add(new Road("rue Mirko",100,100));
        roads.add(new Road("rue David",1000,50));


        roads.add(new Road("rue Magasin1",10000,10000));
        roads.add(new Road("rue Magasin2",5000,3000));
        roads.add(new Road("rue Magasin3",500,200));

        magasins.add(new Magasin("magasin1",roads.get(3)));
        magasins.add(new Magasin("magasin2",roads.get(4)));
        magasins.add(new Magasin("magasin3",roads.get(5)));



        persons.add(new Person("Cédric",5,roads.get(0)));
        persons.add(new Person("Mirko",10,roads.get(1)));
        persons.add(new Person("David",10,roads.get(2)));

    }

}
