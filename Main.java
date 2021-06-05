import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;

//Diego Ruiz 18761

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        String line = null;
        String key;
        String value = "e";
        int op;
        boolean NUKE = false;
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        MapFactory fact = new MapFactory();
        Map<String, String> mapa;
        Map<String, String> usuarioMapa;
        Map<String, Integer> cantMapa;
        Menu menu = new Menu();
        menu.PrintMenu();
        op = scan.nextInt();
        mapa = fact.CrearMapa(op);
        usuarioMapa = fact.CrearMapa(op);
        cantMapa = fact.CrearMapa(op);
        try{
                FileReader fileReader = new FileReader("banco.txt");

                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {                          
                    key = line.substring(0, line.indexOf('|'));                   
                    value = line.substring(line.lastIndexOf("|") + 1);
                    mapa.put(key, value);                  
                } 
                bufferedReader.close(); 
                while(!NUKE){
                menu.PrintMenu2();
                try{
                    op = scan.nextInt();
                }
                catch(Exception e){
                    System.out.println(e);
                }
                key = scan.nextLine();
                switch(op){
                    case 1:
                        System.out.println("Ingrese el nombre del servicio que desea agregar");                        
                        key = scan.nextLine();
                        if(mapa.containsKey(key)){
                            value = mapa.get(key);
                            usuarioMapa.put(key, value); 
                            if(cantMapa.containsKey(key)){
                                int i = cantMapa.get(key) + 1;
                                cantMapa.put(key, i); 
                            }
                            else{
                                cantMapa.put(key, 1);
                            }      
                            System.out.println(cantMapa.get(key));
                        }else{
                            System.out.println("Ese servicio no existe");
                        }
                    break;
                    case 2:
                        System.out.println("Ingrese el nombre del servicio");                        
                        key = scan.nextLine();
                        if(mapa.containsKey(key)){
                            System.out.println("El servicio es de tipo: " + mapa.get(key));
                        }else{
                            System.out.println("Ese servicio no existe");
                        }
                    break;
                    case 3:
                        for(String e: usuarioMapa.keySet()){
                            System.out.println(e + "|" + usuarioMapa.get(e) + "|" + cantMapa.get(e));
                        }
                        break;
                    case 4:
                        for(String e: usuarioMapa.keySet()){
                            if(usuarioMapa.get(e).equals("A")){
                                System.out.println(e + "|" + usuarioMapa.get(e) + "|" + cantMapa.get(e));
                            }
                        }
                        for(String e: usuarioMapa.keySet()){
                            if(usuarioMapa.get(e).equals("B")){
                                System.out.println(e + "|" + usuarioMapa.get(e) + "|" + cantMapa.get(e));
                            }
                        }
                        for(String e: usuarioMapa.keySet()){
                            if(usuarioMapa.get(e).equals("C")){
                                System.out.println(e + "|" + usuarioMapa.get(e) + "|" + cantMapa.get(e));
                            }
                        }
                        for(String e: usuarioMapa.keySet()){
                            if(usuarioMapa.get(e).equals("D")){
                                System.out.println(e + "|" + usuarioMapa.get(e) + "|" + cantMapa.get(e));
                            }
                        }
                        break;
                    case 5:
                        for(String e: mapa.keySet()){
                            System.out.println(e + "|" + mapa.get(e));
                        }
                        break;
                    case 6:
                        for(String e: mapa.keySet()){
                            if(mapa.get(e).equals("A")){
                                System.out.println(e + "|" + mapa.get(e));
                            }
                        }
                        for(String e: mapa.keySet()){
                            if(mapa.get(e).equals("B")){
                                System.out.println(e + "|" + mapa.get(e));
                            }
                        }
                        for(String e: mapa.keySet()){
                            if(mapa.get(e).equals("C")){
                                System.out.println(e + "|" + mapa.get(e));
                            }
                        }
                        for(String e: mapa.keySet()){
                            if(mapa.get(e).equals("D")){
                                System.out.println(e + "|" + mapa.get(e));
                            }
                        }
                        break;    
                    case 7:
                    	System.out.println("Gracias por usar el sistema.");
                        NUKE = true;
                    break;
                    default:
                        System.out.println("Eso no se puede hacer.");
                }
                }
                scan.close();
                
            }
            catch(FileNotFoundException ex) {
                System.out.println(
                    "Unable to open file '" + "banco.txt" + "'");
            }
            catch(IOException ex) {
                    System.out.println("Error reading file '" + "banco.txt" + "'");
                }
    }


    }
    

