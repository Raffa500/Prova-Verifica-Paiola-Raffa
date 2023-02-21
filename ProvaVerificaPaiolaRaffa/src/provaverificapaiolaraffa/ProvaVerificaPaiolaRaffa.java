package provaverificapaiolaraffa;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class ProvaVerificaPaiolaRaffa extends JFrame {

    JButton Reset = new JButton("reset");
    JLabel Dispari = new JLabel("Dispari:");
    JTextField Contatore = new JTextField("");
    
    JButton[][] Bottoni = new JButton[5][5];
    JLabel[][] Numeri = new JLabel[5][5];
    
    GestBottone K = new GestBottone();
    JButton esci = new JButton("Esci");

    int conta;
    int numeroNuovo=0, numeroPrecedente=0;
    int numeroRandomico=0;
    
        public ProvaVerificaPaiolaRaffa() {

        int i = -1, j = -1;
    
        this.setLayout(null);

        this.add(Reset);
        this.add(Dispari);
        this.add(Contatore);
        this.add(esci);

        Reset.setBounds(10, 450, 70, 30);
        Reset.addActionListener(K);
        Dispari.setBounds(150, 450, 50, 30);
        Contatore.setBounds(200, 450, 50, 30);
        Contatore.setEditable(false);

        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                Bottoni[i][j] = new JButton();
                this.add(Bottoni[i][j]);
                Bottoni[i][j].setBounds(10 + (i * 42), 10 + (j * 42), 40, 40);
                Bottoni[i][j].setVisible(true);
                Bottoni[i][j].addActionListener(K);

                Numeri[i][j] = new JLabel();
                this.add(Numeri[i][j]);
                Numeri[i][j].setBounds(10 + (i * 42), 10 + (j * 42), 40, 40);
                Numeri[i][j].setBackground(Color.yellow);
                Numeri[i][j].setOpaque(true);
                Numeri[i][j].setHorizontalAlignment(JLabel.CENTER);
                Numeri[i][j].setVisible(false);
                numeroRandomico = (int) Math.floor((Math.random() * 25)) + 1;
                Numeri[i][j].setText(String.valueOf(numeroRandomico));
                esci.setBounds(300, 200, 100, 20);
                esci.addActionListener(K);
            }
        }

        conta = 0;
        Contatore.setText(String.valueOf(conta));

        this.setLocation(200, 100);
        this.setSize(470, 550);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ProvaVerificaPaiolaRaffa();
    }

    class GestBottone implements ActionListener {

        public void actionPerformed(ActionEvent E) {
            int i = -1, j = -1;
            int  nr = 0;

            for (i = 0; i < 5; i++) {
                for (j = 0; j < 5; j++) {
                    if (E.getSource() == Bottoni[i][j]) {
                        Bottoni[i][j].setVisible(false);
                        Numeri[i][j].setVisible(true);

                        numeroNuovo = Integer.parseInt(Numeri[i][j].getText());
                        if (numeroNuovo < numeroPrecedente) {
                            conta++;
                            Contatore.setText(String.valueOf(conta));
                            Numeri[i][j].setBackground(Color.red);
                            
                        }
                        numeroPrecedente = Integer.parseInt(Numeri[i][j].getText());
                    } else {
                        Numeri[i][j].setBackground(Color.green);
                    }
                }
            }

            if(conta>0) {
               for (i = 0; i < 5; i++) {
                   for (j = 0; j < 5; j++) {
                        Bottoni[i][j].setVisible(false);
                        Numeri[i][j].setVisible(true);
                   }
               }    
               
            }
           
            if (E.getSource() == Reset) {
                for (i = 0; i < 5; i++) {
                    for (j = 0; j < 5; j++) {
                        Bottoni[i][j].setVisible(true);
                        Numeri[i][j].setVisible(false);
                        numeroRandomico = (int) Math.floor((Math.random() * 25)) + 1;
                        Numeri[i][j].setText(String.valueOf(numeroRandomico));
                    }
                }
                conta=0;
                Contatore.setText(String.valueOf(conta));
            }
           
            if (E.getSource() == esci) {
                System.exit(0);
            }
        }
    }
}

