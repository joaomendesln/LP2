package com.javatpoint;  
import java.io.FileWriter;  
public class FileWriterExample {  
    public static void main(String args[]){    
         try{    
           FileWriter fw=new FileWriter("C:\\Users\\jmln_\\eclipse-workspace\\testeEscrita\\src\\com\\javatpoint\\testout.txt");    
           fw.write("Welcome to javaTpoint.");    
           fw.close();    
          }catch(Exception e){System.out.println(e);}    
          System.out.println("Success...");    
     }    
}  