/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package provaverificawilli;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class ProvaVerificaWilli extends JFrame {

    JButton R = new JButton("reset");
    JLabel L = new JLabel("Dispari:");
    JTextField C = new JTextField("");

    JButton[][] B = new JButton[5][5];
    JLabel[][] D = new JLabel[5][5];

    GestBottone K = new GestBottone();
   
    JButton esci = new JButton("Esci");

    int conta;
    int nn=0, np=0;
    int n=0;
   
    public ProvaVerificaWilli() {

        int i = -1, j = -1;
       

        this.setLayout(null);

        this.add(R);
        this.add(L);
        this.add(C);
        this.add(esci);

        R.setBounds(10, 450, 70, 30);
        R.addActionListener(K);
        L.setBounds(150, 450, 50, 30);
        C.setBounds(200, 450, 50, 30);
        C.setEditable(false);

        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                B[i][j] = new JButton();
                this.add(B[i][j]);
                B[i][j].setBounds(10 + (i * 42), 10 + (j * 42), 40, 40);
                B[i][j].setVisible(true);
                B[i][j].addActionListener(K);

                D[i][j] = new JLabel();
                this.add(D[i][j]);
                D[i][j].setBounds(10 + (i * 42), 10 + (j * 42), 40, 40);
                D[i][j].setBackground(Color.yellow);
                D[i][j].setOpaque(true);
                D[i][j].setHorizontalAlignment(JLabel.CENTER);
                D[i][j].setVisible(false);
                n = (int) Math.floor((Math.random() * 25)) + 1;
                D[i][j].setText(String.valueOf(n));
                 esci.setBounds(300, 200, 100, 20);
                 esci.addActionListener(K);
            }
        }

        conta = 0;
        C.setText(String.valueOf(conta));

        this.setLocation(200, 100);
        this.setSize(470, 550);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ProvaVerificaWilli();
    }

    class GestBottone implements ActionListener {

        public void actionPerformed(ActionEvent E) {
            int i = -1, j = -1;
            int  nr = 0;

            for (i = 0; i < 5; i++) {
                for (j = 0; j < 5; j++) {
                    if (E.getSource() == B[i][j]) {
                        B[i][j].setVisible(false);
                        D[i][j].setVisible(true);

                        nn = Integer.parseInt(D[i][j].getText());
                        if (nn < np) {
                            conta++;
                            C.setText(String.valueOf(conta));
                            D[i][j].setBackground(Color.red);
                        }
                        np = Integer.parseInt(D[i][j].getText());
                    } else {
                        D[i][j].setBackground(Color.green);
                    }
                }
            }

            if(conta>0) {
               for (i = 0; i < 5; i++) {
                   for (j = 0; j < 5; j++) {
                        B[i][j].setVisible(false);
                        D[i][j].setVisible(true);
                   }
               }    
               
            }
           
            if (E.getSource() == R) {
                for (i = 0; i < 5; i++) {
                    for (j = 0; j < 5; j++) {
                        B[i][j].setVisible(true);
                        D[i][j].setVisible(false);
                        n = (int) Math.floor((Math.random() * 25)) + 1;
                        D[i][j].setText(String.valueOf(n));
                    }
                }
                conta=0;
                C.setText(String.valueOf(conta));
            }
           
            if (E.getSource() == esci) {
                System.exit(0);
            }
        }
    }
}

