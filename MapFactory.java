import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

//Diego Ruiz 18761

public class MapFactory {
    
    public Map CrearMapa(int a){
        if(a==1){
            Map<String, String> mapa = new HashMap<String, String>();
                return mapa;
        }else if(a==2){
            Map<String, String> mapa = new TreeMap<String, String>();
                return mapa;               
        }else if(a==3){
            Map<String, String> mapa = new LinkedHashMap<String, String>();
            return mapa;
        }
        else{
            return null;
        }
    }
}