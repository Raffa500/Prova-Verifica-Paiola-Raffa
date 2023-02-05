/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manipolazioni.di.array.dinamici;

import java.util.ArrayList;
import java.util.Random;

public class ManipolazioniDiArrayDinamici {

    public static void main(String[] args) {
    Random random = new Random();
    ArrayList<Integer> primoArray = new ArrayList<>();
    ArrayList<Integer> secondoArray = new ArrayList<>();
    
    int primoArraySize = 10;
    int secondoArraySize = 20;
    
    for (int i = 0; i < primoArraySize; i++) {
      primoArray.add(random.nextInt(101) - 50);
    }
    
    for (int i = 0; i < secondoArraySize; i++) {
      int numero = random.nextInt(101) - 50;
      secondoArray.add(numero);
      if (!primoArray.contains(numero)) {
        primoArray.add(numero);
      }
    }
    
    int max = Integer.MIN_VALUE;
    String NomeArray = "";
    for (int i : primoArray) {
      if (i > max) {
        max = i;
        NomeArray = "Primo Array";
      }
    }
    
    for (int i : secondoArray) {
      if (i > max) {
        max = i;
        NomeArray = "Secondo Array";
      }
    }
    
    System.out.println("Primo Array:");
    for (int i : primoArray) {
      System.out.print(i + " ");
    }
    
    System.out.println("\nSecondo Array:");
    for (int i : secondoArray) {
      System.out.print(i + " ");
    }
    
    System.out.println("\nNumero piu grande e " + max + " e si trova nel " + NomeArray);
  }
}
