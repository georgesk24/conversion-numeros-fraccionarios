/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fracciones.PanelDecimalFraccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Fraccion;

/**
 *
 * @author de
 */
public class ControllerDecimalFraccion extends ControllerGeneral implements ActionListener{

    PanelDecimalFraccion view;
    
    public final void events(){
        view.btnConvertir.addActionListener(this);
        view.btnLimpiar.addActionListener(this);
    }
    
    public ControllerDecimalFraccion(PanelDecimalFraccion view){
        this.view=view;
        events();
    }
    
    public void limpiarCampos(){
        view.txtDecimal.setText("");
        view.txtFraccion.setText("");
    }
    
    public Fraccion toFraccion (double decimal){
        return new Fraccion().toFraccion(decimal);        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object evt = ae.getSource();
        
        if(evt.equals(view.btnConvertir)){
        
            if(validarCampos(view.txtDecimal)==true){
                
                try{

                    double decimal = Double.parseDouble(view.txtDecimal.getText());
                    
                    Fraccion resultado = toFraccion(decimal);
                    
                    view.txtFraccion.setText(resultado.toString());
                    
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Error de formato "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);                
                }
            
            }
            
        
        }else if(evt.equals(view.btnLimpiar)){
            limpiarCampos();
        }
        
    }
    
}
