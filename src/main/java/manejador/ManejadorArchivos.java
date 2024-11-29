/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author paveg
 */
public class ManejadorArchivos {
    public static ArrayList<String> leerArchivo(String archivo) {
        ArrayList<String> lineas = new ArrayList<>();
        try {
            BufferedReader lector = new BufferedReader(
                    new FileReader(archivo));
            String linea;
            while((linea=lector.readLine())!=null){
                lineas.add(linea);
            }
//            linea=lector.readLine();
//            while(linea!=null){
//                lineas.add(linea);
//                linea=lector.readLine();
//            }
            return lineas;
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }

    }
    public static String leerLinea(String archivo,int numLinea) {
        ArrayList<String> lineas = new ArrayList<>();
        try {
            BufferedReader lector = new BufferedReader(
                    new FileReader(archivo));
            String linea=null;
            for (int i = 0; i<=numLinea; i++) {
                linea=lector.readLine();
            }
            return linea;
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }

    }
    public static ArrayList<String> reemplazarLinea(String archivo,int numLinea,String nuevaLinea){
       ArrayList<String> lineas = leerArchivo(archivo);
       lineas.set(numLinea,nuevaLinea);
        BufferedWriter escritor=null;
        try{
        escritor= new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i < lineas.size(); i++) {
                escritor.write(lineas.get(i)+"\n");
            }
            return lineas;
        }catch(IOException ex){
            return null;
        }finally{
            try{
                escritor.close();
            }catch(IOException ex){
                return null;
            }
        }
    }
    public static ArrayList<String> agregarLinea(String archivo,String nuevaLinea){
       ArrayList<String> lineas = leerArchivo(archivo);
       lineas.add(nuevaLinea);
        BufferedWriter escritor=null;
        try{
            escritor= new BufferedWriter(new FileWriter(archivo,true));
            escritor.write(nuevaLinea+"\n");
            return lineas;
        }catch(IOException ex){
            return null;
        }finally{
            try{
                escritor.close();
            }catch(IOException ex){
                return null;
            }
        }
    }
    public static ArrayList<String> eliminarLinea(String archivo,int numLinea){
       ArrayList<String> lineas = leerArchivo(archivo);
       lineas.remove(numLinea);
        BufferedWriter escritor=null;
        try{
        escritor= new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i < lineas.size(); i++) {
                escritor.write(lineas.get(i)+"\n");
            }
            return lineas;
        }catch(IOException ex){
            return null;
        }finally{
            try{
                escritor.close();
            }catch(IOException ex){
                return null;
            }
        }
    }

    
}
