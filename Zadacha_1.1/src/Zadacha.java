import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * Created by Альвидас on 05.10.2016.
 */
public class Zadacha {
    public static void main(String[] args){
        Scanner scan=null;
        try {
            scan = new Scanner(new File("in.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
            System.exit(2);
        }
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new FileWriter("out.txt"));
        }catch(IOException e){
            System.out.print("Error");
        }
        String w="";
        while(scan.hasNext()){
            w = w + " " + scan.next();
        }
        System.out.println(w);

        boolean proverka = w.contains(";");

        String m = "";
        String f = "";

        if(proverka = true){
            String[] wParts = w.split("\\;");
            m = wParts[0];
            f = wParts[1];
        }else{
            System.out.println("Error");
            System.exit(1);
        }

        StringTokenizer mass1 = new StringTokenizer(m);
        int l1 = mass1.countTokens();
        StringTokenizer mass2 = new StringTokenizer(f);
        int l2 = mass2.countTokens();
        String a[] = new String[l1];
        String b[] = new String[l2];

        for(int i=0; i<l1; i++){
            try{
                a[i] = mass1.nextToken();
            }catch(NoSuchElementException u){
                System.exit(l1);
            }
        }
        for(int i=0; i<l2; i++){
            try{
                b[i] = mass2.nextToken();
            }catch(NoSuchElementException u){
                System.exit(12);
            }
        }

        int mas1[] = new int[l1];
        int mas2[] = new int[l2];
        pw.print("Массив А: ");
        for(int i=0; i<l1; i++){
            try{
                mas1[i] = Integer.parseInt(a[i]);
                pw.print(mas1[i] + " ");
            }catch(NumberFormatException e){
                System.out.println("Вы ввели не число");
                System.exit(1);
            }
        }
        pw.print("\nМассив B: ");
        for(int i=0; i<l2; i++){
            try{
                mas2[i] = Integer.parseInt(b[i]);
                pw.print(mas2[i] + " ");
            }catch(NumberFormatException e){
                System.out.println("Вы ввели не число");
                System.exit(1);
            }
        }

        int max;
        if(l1>l2){
            max = l1;
        }else{
            max = l2;
        }

        int c[]= new int[max];
        int p = 0;
        for(int t=0; t<l1; t++){
            for(int y=0; y<l2; y++){
                if(mas1[t]==mas2[y]){
                    c[p]=mas2[y];
                    p++;
                }
            }
        }

        pw.print("\nМассив С: ");
        for(int z=0; z<p; z++){
            pw.print(c[z] + " ");
        }

        pw.close();
    }
}
