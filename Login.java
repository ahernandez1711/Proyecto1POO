/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class Login implements ActionListener {
    public GUILogin GUI= new GUILogin();
    public Personaje Main=new Personaje();


    public Login(){
        GUI.BtnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(GUI.BtnLogin)){
            try {
                Main.dinero=Integer.parseInt(GUI.TxfDinero.getText());
                Tienda a= new Tienda(Main);
                a.GUI.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
    
}
