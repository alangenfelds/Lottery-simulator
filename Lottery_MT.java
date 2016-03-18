package com.javarush.test.Lottery_MT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by alangenfelds on 18.03.2016.
 */
public class Lottery_MT
{
    public static int NUM0,NUM1,NUM2,NUM3,NUM4,NUM5;
    public int[] ticket=new int[6];
    public static volatile long games;

    public static void main(String[] args) {

        // Lottery 6 from 48 simulation
        System.out.println("Lottery 6 from 48 simulation");
        System.out.println("Please enter 6 ticket numbers:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            System.out.print("NUM0: ");
            NUM0=Integer.parseInt(reader.readLine());
            System.out.print("NUM1: ");
            NUM1=Integer.parseInt(reader.readLine());
            System.out.print("NUM2: ");
            NUM2=Integer.parseInt(reader.readLine());
            System.out.print("NUM3: ");
            NUM3=Integer.parseInt(reader.readLine());
            System.out.print("NUM4: ");
            NUM4=Integer.parseInt(reader.readLine());
            System.out.print("NUM5: ");
            NUM5=Integer.parseInt(reader.readLine());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Calculating...");
//----------------------- prisvaivaem znachenija massivu iz dannih v forme
        int[] ticket = {NUM0,NUM1,NUM2,NUM3,NUM4,NUM5};
   //     int[] ticket={13,14,22,32,41,47};
        Arrays.sort(ticket);
        //int[] result = {0,0,0,0,0,0};
        //   int[] result = {4,6,23,26,31,48};

//----------------------------

        Thread t1 = new Generator(ticket);
        Thread t2 = new Generator(ticket);
        Thread t3 = new Generator(ticket);
        Thread t4 = new Generator(ticket);
        Thread t5 = new Generator(ticket);
        Thread t6 = new Generator(ticket);
        Thread t7 = new Generator(ticket);
        Thread t8 = new Generator(ticket);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();

        while (true)
        {
            if ( t1.getState().equals(Thread.State.TERMINATED))
            {
                t2.interrupt();
                t3.interrupt();
                t4.interrupt();
                t5.interrupt();
                t6.interrupt();
                t7.interrupt();
                t8.interrupt();
                break;
            }
            if ( t2.getState().equals(Thread.State.TERMINATED))
            {
                t1.interrupt();
                t3.interrupt();
                t4.interrupt();
                t5.interrupt();
                t6.interrupt();
                t7.interrupt();
                t8.interrupt();
                break;
            }
            if ( t3.getState().equals(Thread.State.TERMINATED))
            {
                t1.interrupt();
                t2.interrupt();
                t4.interrupt();
                t5.interrupt();
                t6.interrupt();
                t7.interrupt();
                t8.interrupt();
                break;
            }
            if ( t4.getState().equals(Thread.State.TERMINATED))
            {
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
                t5.interrupt();
                t6.interrupt();
                t7.interrupt();
                t8.interrupt();
                break;
            }
            if ( t5.getState().equals(Thread.State.TERMINATED))
            {
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
                t4.interrupt();
                t6.interrupt();
                t7.interrupt();
                t8.interrupt();
                break;
            }
            if ( t6.getState().equals(Thread.State.TERMINATED))
            {
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
                t4.interrupt();
                t5.interrupt();
                t7.interrupt();
                t8.interrupt();
                break;
            }
            if ( t7.getState().equals(Thread.State.TERMINATED))
            {
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
                t4.interrupt();
                t5.interrupt();
                t6.interrupt();
                t8.interrupt();
                break;
            }
            if ( t8.getState().equals(Thread.State.TERMINATED))
            {
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
                t4.interrupt();
                t5.interrupt();
                t6.interrupt();
                t7.interrupt();
                break;
            }
        } // end while true
        Arrays.sort(ticket);
        System.out.println("Your ticket numbers: "+Arrays.toString(ticket));
    }
}

