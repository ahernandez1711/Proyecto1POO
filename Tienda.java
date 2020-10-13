/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pry;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author pablo
 */
public class Tienda implements ActionListener{
    public GUITienda GUI=new GUITienda();
    public Personaje Main;
    public ArrayList<Yelmo> EstanteriaDeYelmos=new ArrayList();
    public ArrayList<JButton> ListaYelmos=new ArrayList();
    public ArrayList<Pechera> EstanteriaDePechera=new ArrayList();
    public ArrayList<JButton> ListaPecheras=new ArrayList();
    public ArrayList<Arma> EstanteriaDeArmas=new ArrayList();
    public ArrayList<JButton> ListaArmas=new ArrayList();
    public JPanel FondoPecheras;
    public JPanel FondoArmas;
    public JButton Seleccionado;
    public int itemSeleccionado;

    public Tienda(Personaje Main) throws IOException {
        this.Main = Main;
        this.GUI.BtnComprar.addActionListener(this);
        this.GUI.BtnArmaEquipar.addActionListener(this);
        this.GUI.BtnYelmoEquipar.addActionListener(this);
        this.GUI.BtnPecheraEquipar.addActionListener(this);
        this.GUI.BtnVenderYelmo.addActionListener(this);
        this.GUI.BtnVenderPechera.addActionListener(this);
        this.GUI.BtnVenderArma.addActionListener(this);
        GUI.LblStatAtaque.setText(Main.StatAtaque+"");
        GUI.LblStatDefensa.setText(Main.StatDefensa+"");
        GUI.LblStatVida.setText(Main.StatVida+"");
        GUI.LblStatMana.setText(Main.StatMana+"");
        GUI.LblStatCrit.setText(Main.StatCrit+"%");
        GUI.LblEquipado.setText("0");
        GUI.LblInventario.setText("0");
        _init_();
         generarBotones(GUI.PnlYelmos, FondoPecheras, FondoArmas,4 , 4);
         GUI.repaint();
         GUI.setEnabled(true);
    }
    public void _init_() throws IOException{
        GUI.PnlPecheras.setSize(600, 225);
        GUI.PnlPecheras.setLocation(0, 250);
        GUI.PnlFondo.add(GUI.PnlPecheras);
        Dinero();
        GUI.PnlArmas.setSize(600, 225);
        GUI.PnlArmas.setLocation(0, 475);
        GUI.PnlFondo.add(GUI.PnlArmas);
        GUI.PnlYelmos.setBackground(Color.BLACK);
        GUI.PnlArmas.setBackground(Color.BLUE);
        GUI.PnlPecheras.setBackground(Color.CYAN);
        this.FondoArmas=GUI.PnlArmas;
        this.FondoPecheras=GUI.PnlPecheras;
        
    }
    public void generarBotones(JPanel FondoA,JPanel FondoB,JPanel FondoC,int CantidadX,int CantidadY) throws IOException{
            for (int i = 0; i < CantidadX; i++) {
                for (int j = 0; j < CantidadY; j++) {
                    Yelmo PLH=new Yelmo();
                    JButton Btn= new JButton();
                    Btn.setBackground(Color.WHITE);
                    this.ListaYelmos.add(Btn);
                    Btn.addActionListener(this);
                    this.EstanteriaDeYelmos.add(PLH);
                    Btn.setFont(new java.awt.Font("Tahoma",0,9));
                    Btn.setSize(200, 50);
                    Btn.setText(PLH.Nombre);
                    Btn.setLocation((200*i)-200,50*j+25);
                    FondoA.add(Btn);
                }
            
        }
            for (int i = 0; i < CantidadX; i++) {
                for (int j = 0; j < CantidadY; j++) {
                    
                    Pechera PLH=new Pechera();
                    JButton Btn2= new JButton();
                    Btn2.setBackground(Color.WHITE);
                    Btn2.setFont(new java.awt.Font("Tahoma",0,9));
                    this.ListaPecheras.add(Btn2);
                    this.EstanteriaDePechera.add(PLH);
                    Btn2.addActionListener(this);                    
                    Btn2.setSize(200, 50);                    
                    Btn2.setLocation((200*i)-200,50*j+25);
                    Btn2.setText(PLH.Nombre);

                    FondoB.add(Btn2);
                    GUI.repaint();
                }
            
        }
            for (int i = 0; i < CantidadX; i++) {
                for (int j = 0; j < CantidadY; j++) {
                    Arma PLH=new Arma();
                    this.EstanteriaDeArmas.add(PLH);
                    JButton Btn= new JButton();
                    Btn.setBackground(Color.WHITE);
                    Btn.setFont(new java.awt.Font("Tahoma",0,9));
                    this.ListaArmas.add(Btn);
                    Btn.addActionListener(this);
                     FondoC.add(Btn);
                    Btn.setLocation((200*i)-200,50*j+25);
                    Btn.setSize(200, 50);
                    Btn.setText(PLH.Nombre);
                }
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < this.ListaArmas.size(); i++) {        
        if(e.getSource().equals(this.ListaArmas.get(i))){
            this.GUI.LblItemNombre.setText(this.EstanteriaDeArmas.get(i).Nombre);
            this.GUI.LblItemVida.setText("+0");
            this.GUI.LblItemDefensa.setText("+0");
            this.GUI.LblItemMana.setText("+0");
            this.GUI.LblItemAtaque.setText("+"+this.EstanteriaDeArmas.get(i).StatAtaque);
            this.GUI.LblItemCritico.setText("+"+this.EstanteriaDeArmas.get(i).StatCrit+"%");
            this.GUI.LblPrecio.setText(""+this.EstanteriaDeArmas.get(i).Costo);
            this.GUI.LblEquipado.setText(cuantasArmasEquipado(this.EstanteriaDeArmas.get(i).Nombre)+"");
            this.GUI.LblInventario.setText(cuantasArmasAlforja(this.EstanteriaDeArmas.get(i).Nombre)+"");
            for (int j = 0; j < this.ListaYelmos.size(); j++) {
                 ListaYelmos.get(j).setEnabled(true);
             }
             for (int k = 0; k< this.ListaPecheras.size(); k++) {
                 ListaPecheras.get(k).setEnabled(true);
             }
             for (int j = 0; j < this.ListaArmas.size(); j++) {
                 ListaArmas.get(j).setEnabled(true);
             }
             Seleccionado=ListaArmas.get(i);
             this.itemSeleccionado=3;
             ListaArmas.get(i).setEnabled(false);
       }
        }
        for (int i = 0; i < this.ListaPecheras.size(); i++) {        
        if(e.getSource().equals(this.ListaPecheras.get(i))){
            this.GUI.LblItemNombre.setText(this.EstanteriaDePechera.get(i).Nombre);
            this.GUI.LblItemVida.setText("+"+this.EstanteriaDePechera.get(i).StatVida);
            this.GUI.LblItemDefensa.setText("+"+this.EstanteriaDePechera.get(i).StatDefensa);
            this.GUI.LblItemMana.setText("+0");
            this.GUI.LblItemAtaque.setText("+0");
            this.GUI.LblItemCritico.setText("+0%");
            this.GUI.LblEquipado.setText(cuantasPecherasEquipado(this.EstanteriaDePechera.get(i).Nombre)+"");
            this.GUI.LblInventario.setText(cuantasPecherasAlforja(this.EstanteriaDePechera.get(i).Nombre)+"");
            this.GUI.LblPrecio.setText(this.EstanteriaDePechera.get(i).Costo+"");
            for (int j = 0; j < this.ListaArmas.size(); j++) {
                 ListaArmas.get(j).setEnabled(true);
             }
             for (int k = 0; k< this.ListaYelmos.size(); k++) {
                 ListaYelmos.get(k).setEnabled(true);
             }
             for (int k = 0; k< this.ListaPecheras.size(); k++) {
                 ListaPecheras.get(k).setEnabled(true);
             }
             Seleccionado=ListaPecheras.get(i);
             this.itemSeleccionado=2;
             ListaPecheras.get(i).setEnabled(false);
       }
        }
        for (int i = 0; i < this.ListaYelmos.size(); i++) {        
        if(e.getSource().equals(this.ListaYelmos.get(i))){
            
            this.GUI.LblItemNombre.setText(this.EstanteriaDeYelmos.get(i).Nombre);
            this.GUI.LblItemVida.setText("+0");
            this.GUI.LblItemDefensa.setText("+"+this.EstanteriaDeYelmos.get(i).StatDefensa);
            this.GUI.LblItemMana.setText("+"+this.EstanteriaDeYelmos.get(i).StatMana);
            this.GUI.LblItemAtaque.setText("+0");
            this.GUI.LblItemCritico.setText("+0%");
            this.GUI.LblPrecio.setText(this.EstanteriaDeYelmos.get(i).Costo+"");
            this.GUI.LblEquipado.setText(cuantosYelmoEquipado(this.EstanteriaDeYelmos.get(i).Nombre)+"");
            this.GUI.LblInventario.setText(cuantosYelmoAlforja(this.EstanteriaDeYelmos.get(i).Nombre)+"");
             for (int j = 0; j < this.ListaArmas.size(); j++) {
                 ListaArmas.get(j).setEnabled(true);
             }
             for (int k = 0; k< this.ListaPecheras.size(); k++) {
                 ListaPecheras.get(k).setEnabled(true);
             }
             for (int k = 0; k< this.ListaYelmos.size(); k++) {
                 ListaYelmos.get(k).setEnabled(true);
             }
             Seleccionado=ListaYelmos.get(i);
             this.itemSeleccionado=1;
             ListaYelmos.get(i).setEnabled(false);
        }
       }if(e.getSource().equals(GUI.BtnComprar)){
            AdquirirItem();
        }else if(e.getSource().equals(GUI.BtnYelmoEquipar)){
            Yelmo YItem=getYelmo(GUI.CbxYelmo.getItemAt(GUI.CbxYelmo.getSelectedIndex()));
            try{
                Main.StatDefensa-=Main.Cabeza.StatDefensa;
                Main.StatMana-=Main.Cabeza.StatMana;
                Main.Cabeza=YItem;
                Main.StatDefensa+=YItem.StatDefensa;
                Main.StatMana+=YItem.StatMana;
                GUI.LblStatAtaque.setText(Main.StatAtaque+"");
                GUI.LblStatDefensa.setText(Main.StatDefensa+"");
                GUI.LblStatVida.setText(Main.StatVida+"");
                GUI.LblStatMana.setText(Main.StatMana+"");
                GUI.LblStatCrit.setText(Main.StatCrit+"%");
                
            } catch(NullPointerException f){
                Main.Cabeza=YItem;
                Main.StatDefensa+=YItem.StatDefensa;
                Main.StatMana+=YItem.StatMana;
                GUI.LblStatAtaque.setText(Main.StatAtaque+"");
                GUI.LblStatDefensa.setText(Main.StatDefensa+"");
                GUI.LblStatVida.setText(Main.StatVida+"");
                GUI.LblStatMana.setText(Main.StatMana+"");
                GUI.LblStatCrit.setText(Main.StatCrit+"%");
            }
        
        
        } else if(e.getSource().equals(GUI.BtnPecheraEquipar)){
            Pechera PItem=getPechera(GUI.CbxPechera.getItemAt(GUI.CbxPechera.getSelectedIndex()));
            try{
                Main.StatDefensa-=Main.Pecho.StatDefensa;
                Main.StatVida-=Main.Pecho.StatVida;
                Main.Pecho=PItem;
                Main.StatDefensa+=PItem.StatDefensa;
                Main.StatVida+=PItem.StatVida;
                GUI.LblStatAtaque.setText(Main.StatAtaque+"");
                GUI.LblStatDefensa.setText(Main.StatDefensa+"");
                GUI.LblStatVida.setText(Main.StatVida+"");
                GUI.LblStatMana.setText(Main.StatMana+"");
                GUI.LblStatCrit.setText(Main.StatCrit+"%");
            } catch(NullPointerException f){
                Main.Pecho=PItem;
                Main.StatDefensa+=PItem.StatDefensa;
                Main.StatVida+=PItem.StatVida;
                GUI.LblStatAtaque.setText(Main.StatAtaque+"");
                GUI.LblStatDefensa.setText(Main.StatDefensa+"");
                GUI.LblStatVida.setText(Main.StatVida+"");
                GUI.LblStatMana.setText(Main.StatMana+"");
                GUI.LblStatCrit.setText(Main.StatCrit+"%");
            }
        
        
        }else if(e.getSource().equals(GUI.BtnArmaEquipar)){
            Arma AItem=getArma(GUI.CbxArma.getItemAt(GUI.CbxArma.getSelectedIndex()));
            try{
                Main.StatAtaque-=Main.Espada.StatAtaque;
                Main.StatCrit-=Main.Espada.StatCrit;
                Main.Espada=AItem;
                Main.StatAtaque+=Main.Espada.StatAtaque;
                Main.StatCrit+=Main.Espada.StatCrit;
                GUI.LblStatAtaque.setText(Main.StatAtaque+"");
                GUI.LblStatDefensa.setText(Main.StatDefensa+"");
                GUI.LblStatVida.setText(Main.StatVida+"");
                GUI.LblStatMana.setText(Main.StatMana+"");
                GUI.LblStatCrit.setText(Main.StatCrit+"%");
            } catch(NullPointerException f){
                Main.Espada=AItem;
                Main.StatAtaque+=Main.Espada.StatAtaque;
                Main.StatCrit+=Main.Espada.StatCrit;
                GUI.LblStatAtaque.setText(Main.StatAtaque+"");
                GUI.LblStatDefensa.setText(Main.StatDefensa+"");
                GUI.LblStatVida.setText(Main.StatVida+"");
                GUI.LblStatMana.setText(Main.StatMana+"");
                GUI.LblStatCrit.setText(Main.StatCrit+"%");
            }
        
        
        } else if(e.getSource().equals(GUI.BtnVenderYelmo)){
            
                
           
                Yelmo YItem= getYelmo(this.GUI.CbxYelmo.getItemAt(this.GUI.CbxYelmo.getSelectedIndex()));
                System.out.println("Salida");
                Main.dinero+=(YItem.Costo/2);
                try{
                if(YItem.Nombre.compareTo(Main.Cabeza.Nombre)==0){
                    Main.StatDefensa-=Main.Cabeza.StatDefensa;
                    Main.StatMana-=Main.Cabeza.StatMana;
                    Main.Cabeza=null;
                }
                }
                catch(NullPointerException j){
                    
                }
                this.GUI.CbxYelmo.removeItemAt(this.GUI.CbxYelmo.getSelectedIndex());
                Dinero();
                GUI.LblStatAtaque.setText(Main.StatAtaque+"");
                GUI.LblStatDefensa.setText(Main.StatDefensa+"");
                GUI.LblStatVida.setText(Main.StatVida+"");
                GUI.LblStatMana.setText(Main.StatMana+"");
                GUI.LblStatCrit.setText(Main.StatCrit+"%");
            } else if(e.getSource().equals(GUI.BtnVenderPechera)){
                Pechera PItem= getPechera(this.GUI.CbxPechera.getItemAt(this.GUI.CbxPechera.getSelectedIndex()));
                System.out.println("Salida");
                Main.dinero+=(PItem.Costo/2);
                try{
                if(PItem.Nombre.compareTo(Main.Pecho.Nombre)==0){
                    Main.StatDefensa-=Main.Pecho.StatDefensa;
                    Main.StatVida-=Main.Pecho.StatVida;
                    Main.Pecho=null;
                }
                }
                catch(NullPointerException j){
                    
                }
                this.GUI.CbxPechera.removeItemAt(this.GUI.CbxPechera.getSelectedIndex());
                Dinero();
                GUI.LblStatAtaque.setText(Main.StatAtaque+"");
                GUI.LblStatDefensa.setText(Main.StatDefensa+"");
                GUI.LblStatVida.setText(Main.StatVida+"");
                GUI.LblStatMana.setText(Main.StatMana+"");
                GUI.LblStatCrit.setText(Main.StatCrit+"%");
            } else if(e.getSource().equals(GUI.BtnVenderArma)){
                Arma AItem= getArma(this.GUI.CbxArma.getItemAt(this.GUI.CbxArma.getSelectedIndex()));
                Main.dinero+=(AItem.Costo/2);
                try{
                if(AItem.Nombre.compareTo(Main.Espada.Nombre)==0){
                    Main.StatAtaque-=Main.Espada.StatAtaque;
                    Main.StatCrit-=Main.Espada.StatCrit;
                    Main.Espada=null;
                }
                }
                catch(NullPointerException j){
                    
                }
                this.GUI.CbxArma.removeItemAt(this.GUI.CbxArma.getSelectedIndex());
                Dinero();
                GUI.LblStatAtaque.setText(Main.StatAtaque+"");
                GUI.LblStatDefensa.setText(Main.StatDefensa+"");
                GUI.LblStatVida.setText(Main.StatVida+"");
                GUI.LblStatMana.setText(Main.StatMana+"");
                GUI.LblStatCrit.setText(Main.StatCrit+"%");
            }
            
        
    
            
           
        
        
}
public void AdquirirItem(){
        switch (itemSeleccionado) {
            case 1:
                Yelmo YItem=getYelmo(Seleccionado.getText());
               if( YItem.Costo<=Main.dinero){
                   Main.dinero-=YItem.Costo;
                   Main.AlforjaDeYelmos.add(YItem);
                   Seleccionado.setVisible(false);
                   Dinero();
                   GUI.CbxYelmo.addItem(YItem.Nombre);
               }else{
                   
               }
                break;
            case 2:
                Pechera PItem=getPechera(Seleccionado.getText());
               if( PItem.Costo<=Main.dinero){
                   Main.dinero-=PItem.Costo;
                   Main.AlforjaDePecheras.add(PItem);
                   Seleccionado.setVisible(false);
                   Dinero();
                   GUI.CbxPechera.addItem(PItem.Nombre);
               }else{
                   
               }
                break;
            default:
                Arma AItem=getArma(Seleccionado.getText());
               if( AItem.Costo<=Main.dinero){
                   Main.dinero-=AItem.Costo;
                   Main.AlforjaDeArmas.add(AItem);
                   Seleccionado.setVisible(false);
                   Dinero();
                   GUI.CbxArma.addItem(AItem.Nombre);
               }else{
                  
               }
                break;
        }
        }
public Yelmo getYelmo(String Item){
    for (int i = 0; i < this.EstanteriaDeYelmos.size(); i++) {
        if(Item.compareTo(EstanteriaDeYelmos.get(i).Nombre)==0){
            return EstanteriaDeYelmos.get(i);
        }
        
    }
    return null;
}
public Pechera getPechera(String Item){
    for (int i = 0; i < this.EstanteriaDePechera.size(); i++) {
        if(Item.compareTo(EstanteriaDePechera.get(i).Nombre)==0){
            return EstanteriaDePechera.get(i);
        }
        
    }
    return null;
}
public Arma getArma(String Item){
    for (int i = 0; i < this.EstanteriaDeArmas.size(); i++) {
        if(Item.compareTo(EstanteriaDeArmas.get(i).Nombre)==0){
            return EstanteriaDeArmas.get(i);
        }
        
    }
    return null;
}
public void Dinero(){
    this.GUI.LblDinero.setText(Main.dinero+"");
}
public int cuantosYelmoAlforja(String SYelmo){
    int contador=0;
    for (int i = 0; i < Main.AlforjaDeYelmos.size(); i++) {
        Yelmo get = Main.AlforjaDeYelmos.get(i);
        if(SYelmo.compareTo(get.Nombre)==0){
            contador++;
        }
        
    }
    return contador;
}
public int cuantosYelmoEquipado(String SYelmo){
    try{
        if(SYelmo.compareTo(Main.Cabeza.Nombre)==0){
            return 1;
        }else{
            return 0;
        }
    }
    catch(NullPointerException j){
        return 0;
    }
}    
public int cuantasPecherasAlforja(String SPechera){
    int contador=0;
    for (int i = 0; i < Main.AlforjaDePecheras.size(); i++) {
        Pechera get = Main.AlforjaDePecheras.get(i);
        if(SPechera.compareTo(get.Nombre)==0){
            contador++;
        }
        
    }
    return contador;
}
public int cuantasPecherasEquipado(String SPechera){
    try{
        if(SPechera.compareTo(Main.Pecho.Nombre)==0){
            return 1;
        }else{
            return 0;
        }
    }
    catch(NullPointerException j){
        return 0;
    }
}    
public int cuantasArmasAlforja(String SArmas){
    int contador=0;
    for (int i = 0; i < Main.AlforjaDeArmas.size(); i++) {
        Arma get = Main.AlforjaDeArmas.get(i);
        if(SArmas.compareTo(get.Nombre)==0){
            contador++;
        }
        
    }
    return contador;
}
public int cuantasArmasEquipado(String SArmas){
        try{
        if(SArmas.compareTo(Main.Espada.Nombre)==0){
            return 1;
        }else{
            return 0;
        }
        }catch(NullPointerException j){
            return 0;
        }
}
}