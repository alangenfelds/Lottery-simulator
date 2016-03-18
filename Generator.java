package com.javarush.test.Lottery_MT;

import java.util.Arrays;
import java.util.Random;

public class Generator extends Thread
{

    int pos1,pos2,pos3,pos4,pos5;
    Random rand = new Random(100);
    int[] result = new int[6];
    int[] ticket = new int[6];

    public Generator(int[] ticket)
    {
        this.ticket = ticket;
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+" STARTING");
        while (result[0]!=ticket[0] || result[1]!=ticket[1] ||result[2]!=ticket[2] || result[3]!=ticket[3] || result[4]!=ticket[4] || result[5]!=ticket[5])
        {
        //------------GENERIRUEM MASSIV S REZULTATOM---------------
            if (isInterrupted()) break;
            rand = new Random();
            result[0]=rand.nextInt(48)+1;   //pervij element ljuboj iz 48
            //proverka na povtori s predidushimi nomerami

            rand = new Random();
            pos1=rand.nextInt(48)+1;
            while (pos1 == result[0]){						//vtoroj element dolzen otlichatsa ot pervogo
                rand = new Random();
                pos1=rand.nextInt(47)+1;
            }
            result[1]=pos1;
            //--------------------------------------
            rand = new Random();
            pos2=rand.nextInt(48)+1;
            while ((pos2 == result[0]) || (pos2 == result[1])){  //tretij element dolzen otlichatsa ot vseh predidushih i t.d.
                rand = new Random();
                pos2=rand.nextInt(48)+1;
            }
            result[2]=pos2;
            //------------------------------------------
            rand = new Random();
            pos3=rand.nextInt(48)+1;
            while ((pos3 == result[0]) || (pos3 == result[1]) || (pos3 == result[2])){
                rand = new Random();
                pos3=rand.nextInt(48)+1;
            }
            result[3]=pos3;
            //------------------------------------------
            rand = new Random();
            pos4=rand.nextInt(48)+1;
            while ((pos4 == result[0]) || (pos4 == result[1]) || (pos4 == result[2]) || (pos4 == result[3])){
                rand = new Random();
                pos4=rand.nextInt(48)+1;
            }
            result[4]=pos4;
            //------------------------------------------
            rand = new Random();
            pos5=rand.nextInt(48)+1;
            while ((pos5 == result[0]) || (pos5 == result[1]) || (pos5 == result[2]) || (pos5 == result[3]) || (pos5 == result[4])){
                rand = new Random();
                pos5=rand.nextInt(48)+1;
            }
            result[5]=pos5;

            //-----------------REZULTAT SGENERIROVAN---------------------------
            Arrays.sort(result);
            Lottery_MT.games++;
        } // end of While
        if (!isInterrupted())
        {
            System.out.println("You won 6 from 6 after "+Lottery_MT.games+" games ("+Lottery_MT.games/54+") years.");
            System.out.println("Result numbers: "+Arrays.toString(result)+" by "+Thread.currentThread().getName());
        }
        else System.out.println(Thread.currentThread().getName()+" Interrupted");

    }
}
