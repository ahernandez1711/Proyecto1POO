/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pry;

import java.io.IOException;
import java.util.Random;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author pablo
 */
public class Pechera {
    public String Nombre;
    public int StatDefensa;
    public int StatVida;
    public int Costo;

    public Pechera() throws IOException {
             OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
	.url("https://omgvamp-hearthstone-v1.p.rapidapi.com/cards/"+getNombre()+"?locale=esES")
	.get()
	.addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
	.addHeader("x-rapidapi-key", "7f72a5870fmsh157a167be4580f0p160d5djsn877644979bc9")
	.build();

    Response response = client.newCall(request).execute();
    JSONArray a= new JSONArray(response.body().string());
    JSONObject obj= a.getJSONObject(0);
        String name= obj.getString("name");
        int H=obj.getInt("health");
        int C=obj.getInt("cost");
        int A=obj.getInt("attack");
        this.Nombre=getPechera()+name;
        this.StatDefensa=A;
        this.StatVida=(H+C+A)*100;
        this.Costo=C*1000;
    }
    
    
    
    public String getNombre(){
        Random r=new Random();
        int Selec=r.nextInt(19);
        switch (Selec){
                case 0:
                    return "Brillacorteza";
                case 1:
                    return "Goru el Gran Árbol";
                case 2:
                    return "Vereesa Brisaveloz";
                case 3:
                    return  "Maestro destructor Bum";       
                case 4:
                    return  "Alta inquisidora Melenablanca";
                case 5:
                    return  "Veranus";
                case 6:
                    return  "Armagedillo";            
                case 7:
                    return  "Malygos, Aspecto de la Magia";
                case 8:
                    return  "Mozaki maestra duelista";
                case 9:
                    return  "Camarera Lynchen";
                case 10:
                    return  "Al'ar";
                case 11:
                    return  "Tradicionalista Polkelt";
                case 12:
                    return  "Comandante de foso";
                case 13:
                    return  "Kayn Furia del Sol";
                case 14:
                    return  "Altruis el Proscrito";
                case 15:
                    return  "Kalecgos";
                case 16:
                    return  "Atracador de bombas";
                case 17:
                    return  "Archivista Elysiana";
                case 18:
                    return  "Nethrandamus"; 
                 default:
                     return"";
        }
    }
    public String getPechera(){
        Random r=new Random();
        int Selec=r.nextInt(8);
        switch (Selec){
                case 0:
                    return "Pechera de batalla de ";
               case 1:
                    return "Pechera de tela de ";
                case 2:
                    return "Pechera de placas de ";
                case 3:
                    return "Pechera de malla de ";
                 case 4:
                    return "Cota de malla de";
                 case 5:
                    return "Pechera de cuero de ";
                case 6:
                    return "Toga magica de ";
                case 7:
                    return "Pechera defensiva de ";    
                    
                default: 
                    return "";
        }
    }

    @Override
    public String toString() {
        return "Pechera{" + "Nombre=" + Nombre + ", StatDefensa=" + StatDefensa + ", StatVida=" + StatVida + ", Costo=" + Costo + '}';
    }
    
}
