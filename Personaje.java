/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pry;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Personaje {
    public int dinero=0;
    public int StatAtaque=0;
    public int StatDefensa=0;
    public int StatVida=100;
    public int StatMana=100;
    public int StatCrit=0;
    public Yelmo Cabeza;
    public Pechera Pecho;
    public Arma Espada;
    public ArrayList<Yelmo> AlforjaDeYelmos=new ArrayList();
    public ArrayList<Pechera> AlforjaDePecheras=new ArrayList();
    public ArrayList<Arma> AlforjaDeArmas=new ArrayList();
}
