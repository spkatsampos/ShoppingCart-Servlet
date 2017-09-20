import java.io.*;
import java.util.*;
public class Catalog {

    String item;
    String title;
    double price;
    
 public String getitem(){return this.item;}
 public String gettitle(){return this.title;}
 public double getprice(){return this.price;}
 
 public Catalog(String item, String title, double price){
     this.item=item;
     this.price=price;
     this.title=title;
 }
   
}