package com.company;

public class Main {

    public static void main(String[] args) {
        // n1
        int[] a1 = new int[]{1, 2};

        // n2
        int[] a2 = new int[1000];
        for (int i = 1; i < 1001; i++)
            a2[i - 1] = i;

        // n3
        int[] a3 = new int[10];
        for (int i = 1, j = 0; i < 20; i += 2)
            a3[j++] = i;

        // n4
        int[] a4 = new int[20];
        for (int i = 0; i < 20; i++)
            a4[i] = i;
        for (int i = 0; i < a4.length; i++)
            if (a4[i] % 5 == 0)
                System.out.println(a4[i]);

        // n5
        int[] a5 = new int[1000];
        for (int i = 0; i < 1000; i++)
            a5[i] = i;
        for (int i = 0; i < a5.length; i++)
            if (a5[i] > 24 && a5[i] < 468)
                System.out.println(a5[i]);

        // n6
        int[] a6 = new int[20];
        int n1 = 0;
        for (int i = 1; i < 21; i++)
            a6[i-1] = i;
        for (int i = 0; i < a6.length; i++)
            if (a6[i] % 2 == 0)
                n1++;
        System.out.println(n1);

        // n7
        int n2 = 2;
        for (int i = 1; i < 11; i++)
            System.out.println(n2 + "x" + i + " = " + n2 * i);
    }
}
