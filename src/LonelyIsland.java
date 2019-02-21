/* Tugas Kecil 2 IF2211 Strategi Algoritma "Lone Island"
NIM / Nama  : 13517048 / Leonardo
Nama File   : LonelyIsland.java
Deskripsi   : Main program untuk mencari pulau dead-end dari suatu graf berarah. Memanggil Edge.java untuk class pair
*/
import java.util.*;
import java.io.*;

public class LonelyIsland {
    public static void Solve(int vertex, int bridges, int firstvert, List<Edge<Integer, Integer>> listOfBridge){ 
        List<Integer> passed = new ArrayList<Integer>();
        boolean stuck[] = new boolean[vertex+1]; //memakai boolean agar hasil unik
        for (int i = 0; i <= vertex; i++){ // inisialisasi
            stuck[i] = false;
        }
        System.out.println("Stuck Routes :");
        DFS(bridges, firstvert, listOfBridge, passed, stuck);//memanggil algoritma DFS
        System.out.println("\nStuck Islands :");
        for (int j = 1; j <= vertex; j++){ // print terurut
            if (stuck[j]){
                System.out.println(j);
            }
        }
    }

    public static void DFS(int bridges, int firstvert, List<Edge<Integer, Integer>> listOfBridge, List<Integer> passed, boolean stuck[]){
        // penyelesaian dengan algoritma Decrease and Conquer - Depth First Search (DFS)
        passed.add(firstvert);
        boolean skt = false;
        for (int i = 0; i < bridges; i++){
            if (listOfBridge.get(i).getFirst() == firstvert){
                if(!isPassed(listOfBridge.get(i).getSecond(), passed)){
                    DFS(bridges, listOfBridge.get(i).getSecond(), listOfBridge, passed, stuck);
                    skt = true;
                    //backtrack, hilangkan elemen terakhir
                    passed.remove(passed.size()-1);
                }
            }
        }
        if (skt == false){//tidak ada yang jembatan ke pulau lain
            stuck[firstvert] = true; 
            for (int i = 0; i < passed.size(); i++){
                System.out.print(passed.get(i));// menampilkan rute yang stuck
                if (i < passed.size() - 1){
                    System.out.print(" -> ");
                } else {
                    System.out.println();
                }
            }
        }
    }

    public static boolean isPassed(int vert, List<Integer> li){
        boolean sem = false;
        int i = 0;
        while ((i < li.size()) && (!sem)){
            if (vert == li.get(i)){
                sem = true;
            } else {
                i += 1;
            }
        }
        return sem;
    }
    public static void main(String[] args){
        // main program
        System.out.print("Input file name(end with .txt) : ");
        Scanner scan = new Scanner(System.in);
        String namafile = scan.nextLine();
        try {
            List<Edge<Integer,Integer>> listOfBridge = new ArrayList<Edge<Integer,Integer>>();
            File input = new File(namafile); //deklarasi file agar data di dalamnya dapat diambil
            Scanner scaninp = new Scanner(input); //mengambil input dari file

            int vertex = scaninp.nextInt();
            int bridges = scaninp.nextInt();
            int firstvert = scaninp.nextInt();

            for (int i = 0; i < bridges; i++){
                int fst = scaninp.nextInt();
                int scd = scaninp.nextInt();

                Edge<Integer, Integer> temp = new Edge<Integer, Integer>(fst, scd);
                listOfBridge.add(temp);
            }
            long start = System.nanoTime();
            Solve(vertex, bridges, firstvert, listOfBridge);
            long end = System.nanoTime();
            System.out.printf("Execution Time : %.2f milliseconds\n", (double)((end-start)/1000000));
            scaninp.close();
        } catch (Exception e) {
            System.out.println("File not found! Program stopped.");
        }
        scan.close();
    }
}