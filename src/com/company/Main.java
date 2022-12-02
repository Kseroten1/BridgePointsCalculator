package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

public class Main extends Frame implements ActionListener {

    TextField cards;
    Label wynik;
    Button licz;
    Button losuj;

    public Main() {
        super("Licznik punktów brydżowskich");
        setSize(600, 120);
        setLocation(600, 300);
        setLayout(new FlowLayout());
        setBackground(Color.lightGray);
        add(new Label("Podaj sekwencję kart: "));
        cards = new TextField(23);
        add(cards);
        licz = new Button("Licz");
        licz.addActionListener(this);
        add(licz);
        wynik = new Label("                                                                                         ");
        add(wynik);
        losuj = new Button("Losuj");
        losuj.addActionListener(this);
        add(losuj);

        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);
        Menu menu = new Menu("Plik");
        MenuItem mi = new MenuItem("Zamknij", new MenuShortcut('1'));
        menu.add(mi);
        menu.addActionListener(this);
        menuBar.add(menu);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        if (label.equals("Losuj")) {
            HashSet<Integer> set = new LinkedHashSet<Integer>();
            while(set.size() != 13) {
                set.add((int)(Math.random() * ((52 - 1) + 1)) + 1);
            }
            List<Integer> lista = new ArrayList<Integer>(set);
            Collections.sort(lista);
            lista.iterator();


        }
        if (label.equals("Licz")) {
            String karty = cards.getText();
            int wynikInt = 0;
            while (karty.contains("10")) {
                karty = karty.replace("10", "1");
            }
            for (int i = 0; i < karty.length(); i++) {
                if (karty.charAt(i) == 'A') {
                    wynikInt += 4;
                }
                if (karty.charAt(i) == 'K') {
                    wynikInt += 3;
                }
                if (karty.charAt(i) == 'Q') {
                    wynikInt += 2;
                }
                if (karty.charAt(i) == 'J') {
                    wynikInt += 1;
                }
            }
            int rozmiarPikow;
            rozmiarPikow = karty.indexOf('H') - karty.indexOf('S');
            if (rozmiarPikow == 1) {
                wynikInt += 3;
            } else if (rozmiarPikow == 2) {
                wynikInt += 2;
            } else if (rozmiarPikow == 3) {
                wynikInt += 1;
            }
            int rozmiarSerc;
            rozmiarSerc = karty.indexOf('D') - karty.indexOf('H');
            if (rozmiarSerc == 1) {
                wynikInt += 3;
            } else if (rozmiarSerc == 2) {
                wynikInt += 2;
            } else if (rozmiarSerc == 3) {
                wynikInt += 1;
            }
            int rozmiarKaro;
            rozmiarKaro = karty.indexOf('C') - karty.indexOf('D');
            if (rozmiarKaro == 1) {
                wynikInt += 3;
            } else if (rozmiarKaro == 2) {
                wynikInt += 2;
            } else if (rozmiarKaro == 3) {
                wynikInt += 1;
            }
            int rozmiarTrefl;
            rozmiarTrefl = karty.length() - karty.indexOf('C');
            if (rozmiarTrefl == 1) {
                wynikInt += 3;
            } else if (rozmiarTrefl == 2) {
                wynikInt += 2;
            } else if (rozmiarTrefl == 3) {
                wynikInt += 1;
            }
            String wynik = "Twój wynik to: ";
            wynik = wynik.concat(Integer.toString(wynikInt));
            JOptionPane.showMessageDialog(null, wynik);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

