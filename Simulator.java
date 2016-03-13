package Lottery_6_48;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by alangenfelds on 12.02.2016.
 */
public class Simulator {

    static int NUM0,NUM1,NUM2,NUM3,NUM4,NUM5;

    public static void main(String[] args) {

        // Lottery 6 from 48 simulation

        long games=0;
        int pos1,pos2,pos3,pos4,pos5;
        boolean result0,result1,result2,result3,result4,result5;
        Random rand = new Random(100);

        System.out.println("Lottery 6 from 48 simulation");
        System.out.println("Please enter 6 ticket numbers:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            NUM0=Integer.parseInt(reader.readLine());
            NUM1=Integer.parseInt(reader.readLine());
            NUM2=Integer.parseInt(reader.readLine());
            NUM3=Integer.parseInt(reader.readLine());
            NUM4=Integer.parseInt(reader.readLine());
            NUM5=Integer.parseInt(reader.readLine());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
//----------------------- prisvaivaem znachenija massivu iz dannih v forme
        int[] ticket = {NUM0,NUM1,NUM2,NUM3,NUM4,NUM5};
        int[] result = {0,0,0,0,0,0};
     //   int[] result = {4,6,23,26,31,48};

//----------------------------
//             Esli nomer na pozicii 0 najden v rezultate - to rezultat FALSE, esli vse nomera prisutstvujut v rezultate - znachit vse FALSE i cikl While naetom zakancivaetsa.


            while ( //uslovie - esli v kazdoj strochke naselsa iskomij element, znachit vse nomera vipali i rezultat FALSE
                    ((result[0] != ticket[0]) && (result[0] != ticket[1]) && (result[0] != ticket[2]) && (result[0] != ticket[3]) && (result[0] != ticket[4]) && (result[0] != ticket[5]))
                            ||
                    ((result[1] != ticket[0]) && (result[1] != ticket[1]) && (result[1] != ticket[2]) && (result[1] != ticket[3]) && (result[1] != ticket[4]) && (result[1] != ticket[5]))
                            ||
                    ((result[2] != ticket[0]) && (result[2] != ticket[1]) && (result[2] != ticket[2]) && (result[2] != ticket[3]) && (result[2] != ticket[4]) && (result[2] != ticket[5]))
                            ||
                    ((result[3] != ticket[0]) && (result[3] != ticket[1]) && (result[3] != ticket[2]) && (result[3] != ticket[3]) && (result[3] != ticket[4]) && (result[3] != ticket[5]))
                            ||
                    ((result[4] != ticket[0]) && (result[4] != ticket[1]) && (result[4] != ticket[2]) && (result[4] != ticket[3]) && (result[4] != ticket[4]) && (result[4] != ticket[5]))
                            ||
                    ((result[5] != ticket[0]) && (result[5] != ticket[1]) && (result[5] != ticket[2]) && (result[5] != ticket[3]) && (result[5] != ticket[4]) && (result[5] != ticket[5]))
                    )   // konec uslovija


            {
//------------GENERIRUEM MASSIV S REZULTATOM---------------
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
//                Arrays.sort(result);
//                System.out.println("Game Nr."+games+"   Result numbers: "+Arrays.toString(result));
                games++;
            } // end of While

        System.out.println("You won 6 from 6 after "+games+" games ("+games/54+") years.");
        Arrays.sort(ticket);
        System.out.println("Your ticket numbers: "+Arrays.toString(ticket));
        Arrays.sort(result);
        System.out.println("Result numbers: "+Arrays.toString(result));



    }
}
