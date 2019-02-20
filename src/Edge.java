/* Tugas Kecil 2 IF2211 Strategi Algoritma "Lone Island"
NIM / Nama  : 13517048 / Leonardo
Nama File   : Edge.java
Deskripsi   : Kelas Pair untuk dipakai pada LonelyIsland.java
*/
import java.util.*;

public class Edge<F,S> {
    //Terdapat First dan Second, Edge penghubung dari vertex first ke vertex second
    private F first;
    private S second;
    
    //ctor
    public Edge(F _first, S _second){
        this.first = _first;
        this.second = _second;
    }
    //getter
    public F getFirst(){
        return this.first;
    }

    public S getSecond(){
        return this.second;
    }
    //setter
    public void setFirst(F _first){
        this.first = _first;
    }

    public void setSecond(S _second){
        this.second = _second;
    }
}