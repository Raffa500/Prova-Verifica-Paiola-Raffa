/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package soluzioneprovapaiola;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SoluzioneProvaPaiola extends JFrame{

    boolean game = true;
    int contPunteggio = 0;
    int numPrecedente = 0;
    JButton[][] A = new JButton[6][6];
    JLabel[][] Testo = new JLabel[6][6];
    JButton riprova = new JButton("Riprova");
    JButton esci = new JButton("Esci");
    GestBottone S1 = new GestBottone();
    JLabel testoPari = new JLabel("0");

    SoluzioneProvaPaiola() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(null);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                A[i][j] = new JButton(":)");
                Testo[i][j] = new JLabel(String.valueOf((int) (Math.random() * 98 + 1)));
                A[i][j].addActionListener(S1);
                this.add(Testo[i][j]);
                Testo[i][j].setBounds(10 + (45 * j), 10 + (45 * i), 40, 30);
                this.add(A[i][j]);
                Testo[i][j].setVisible(false);
                A[i][j].setBounds(10 + (45 * j), 10 + (45 * i), 40, 30);
            }
        }
        testoPari.setBounds(300, 150, 100, 30);
        riprova.setBounds(300, 100, 100, 20);
        esci.setBounds(300, 200, 100, 20);
        riprova.addActionListener(S1);
        esci.addActionListener(S1);

        this.add(riprova);
        this.add(esci);
        this.add(testoPari);
        this.setLocation(200, 100);
        this.setSize(500, 400);

    }

    public static void main(String args[]) {
        JFrame gui = new SoluzioneProvaPaiola();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui.setVisible(true);

            }
        });
    }

    class GestBottone implements ActionListener {

        public void actionPerformed(ActionEvent E) {
            int j = 0, i, n = 0;

            if (game) {
                for (i = 0; i < 5; i++) {
                    for (j = 0; j < 5; j++) {
                        if (E.getSource() == A[i][j]) {
                            A[i][j].setVisible(false);
                            Testo[i][j].setVisible(true);
                            System.out.println(Integer.parseInt(Testo[i][j].getText()) + " " + numPrecedente);
                            if (Integer.parseInt(Testo[i][j].getText()) < numPrecedente) {
                                game = false;
                                for (int k = 0; k < 5; k++) {
                                    for (int l = 0; l < 5; l++) {
                                        Testo[k][l].setOpaque(true);
                                        A[k][l].setVisible(false);
                                        Testo[k][l].setVisible(true);
                                        if (!(k == i && l == j) && Testo[k][l].getBackground() != Color.green) {
                                            Testo[k][l].setBackground(Color.yellow);
                                        }
                                    }
                                }
                                Testo[i][j].setBackground(Color.red);
                                Testo[i][j].setOpaque(true);
                            } else {
                                contPunteggio++;
                                numPrecedente = Integer.parseInt(Testo[i][j].getText());
                                testoPari.setText(Integer.toString(contPunteggio));
                                Testo[i][j].setBackground(Color.green);
                                Testo[i][j].setOpaque(true);
                            }
                        }
                    }
                }
            }

            if (E.getSource() == riprova) {
                for (i = 0; i < 5; i++) {
                    for (j = 0; j < 5; j++) {
                        A[i][j].setVisible(true);
                        Testo[i][j].setVisible(false);
                        Testo[i][j].setText(Integer.toString((int) (Math.random() * 98 + 1)));
                        numPrecedente = 0;
                        Testo[i][j].setBackground(null);
                    }
                }
                contPunteggio = 0;
                testoPari.setText(Integer.toString(contPunteggio));
                game = true;
            }

            if (E.getSource() == esci) {
                System.exit(0);
            }
        }
    }
}
