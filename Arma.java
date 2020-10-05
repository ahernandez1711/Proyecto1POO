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
public class Arma {
    public String Nombre;
    public int StatAtaque;
    public int StatCrit;
    public int Costo;

    public Arma() throws IOException {
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
        this.Nombre=getArma()+name;
        this.StatAtaque=A+C;
        this.StatCrit=H+C+A;
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
    public String getArma(){
        Random r=new Random();
        int Selec=r.nextInt(11);
        switch (Selec){
                case 0:
                    return "Gran espada de ";
               case 1:
                    return "Hacha legendaria de ";
                case 2:
                    return "Baculo magico de ";
                case 3:
                    return "Gran guadaña de ";
                 case 4:
                    return "Espada de una mano de ";
                 case 5:
                    return "Decapitadora de ";
                case 6:
                    return "Daga corta de ";
                case 7:
                    return "Arma de asta de ";    
                case 8:
                    return "Arco poderoso de ";
                case 9:
                    return "Arco de batalla de ";
                case 10:
                    return "Arco magico de ";    
                    
                default: 
                    return "";
        }
    }

    @Override
    public String toString() {
        return "Arma{" + "Nombre=" + Nombre + ", StatAtaque=" + StatAtaque + ", StatCrit=" + StatCrit + ", Costo=" + Costo + '}';
    }
    
    
}
