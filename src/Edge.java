/* Tugas Kecil 2 IF2211 Strategi Algoritma "Lone Island"
NIM / Nama  : 13517048 / Leonardo
Nama File   : Edge.java
Deskripsi   : Kelas Edge (berupa pair of template) untuk dipakai pada LonelyIsland.java
*/
import java.util.*;

public class Edge<T> { //tidak pasti memakai integer agar dapat dipakai pada proyek-proyek lain
    //Terdapat First dan Second, Edge penghubung dari vertex first ke vertex second
    private T first;
    private T second;
    
    //ctor
    public Edge(T _first, T _second){
        this.first = _first;
        this.second = _second;
    }
    //getter
    public T getFirst(){
        return this.first;
    }

    public T getSecond(){
        return this.second;
    }
    //setter
    public void setFirst(T _first){
        this.first = _first;
    }

    public void setSecond(T _second){
        this.second = _second;
    }
}