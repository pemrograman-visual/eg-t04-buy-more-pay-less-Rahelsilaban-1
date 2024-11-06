// 12S24010 - Artha Liebe Siregar
// 12S24054 - Rahel Juri Elisabet SIlaban

import java.util.*;
import java.lang.Math;

public class T04 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] iSBN = new String[3];
        double[] price = new double[3];
        int[] quantity = new int[3];
        double tPrice, totalPrice;
        String tISBN;
        int tQuantity;
        int initialize, index, loop, position;

        for (initialize = 0; initialize <= 2; initialize++) {
            iSBN[initialize] = "";
            price[initialize] = 0.0;
            quantity[initialize] = 0;
        }
        tISBN = input.nextLine();
        index = 0;
        position = 0;
        while (!tISBN.equals("---")) {
            tPrice = Double.parseDouble(input.nextLine());
            tQuantity = Integer.parseInt(input.nextLine());
            boolean next;

            next = false;
            for (loop = 0; loop <= 2; loop++) {
                if (tISBN.equals(iSBN[loop])) {
                    next = true;
                    position = loop;
                }
            }
            if (next == true) {
                quantity[position] = quantity[position] + tQuantity;
            } else {
                iSBN[index] = tISBN;
                price[index] = tPrice;
                quantity[index] = tQuantity;
                index = index + 1;
            }
            tISBN = input.nextLine();
        }
        double diskon;
        int isi;

        diskon = 0;
        totalPrice = 0.0;
        for (isi = 0; isi <= 2; isi++) {
            double tempPrice;

            if (quantity[isi] >= 20) {
                tempPrice = (price[isi] - price[isi] * 0.05) * quantity[isi];
            } else {
                if (quantity[isi] >= 10) {
                    tempPrice = (price[isi] - price[isi] * 0.05) * quantity[isi];
                } else {
                    if (quantity[isi] >= 5) {
                        tempPrice = (price[isi] - price[isi] * 0.05) * quantity[isi];
                    } else {
                        tempPrice = price[isi] * quantity[isi];
                    }
                }
            }
            totalPrice = totalPrice + tempPrice;
        }
        System.out.println(toFixed(totalPrice,2));
    }
    
    private static String toFixed(double value, int digits) {
        return String.format("%." + digits + "f", value);
    }
}
