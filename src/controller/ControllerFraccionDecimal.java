/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fracciones.PanelFraccionDecimal;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import model.Fraccion;

/**
 *
 * @author de
 */
public class ControllerFraccionDecimal extends ControllerGeneral implements ActionListener, KeyListener{
    
    PanelFraccionDecimal view;
    
    public final void events(){
        view.btnConvertir.addActionListener(this);
        view.btnLimpiar.addActionListener(this);
        view.txtNumerador.addKeyListener(this);
        view.txtDenominador.addKeyListener(this);
    }
    
    public ControllerFraccionDecimal(PanelFraccionDecimal view){
        this.view=view;
        events();
    }
    
    /*Limpiamos los campos de texto*/
    public void limpiarCampos(){
        view.txtNumerador.setText("");
        view.txtDenominador.setText("");
        view.txtResultado.setText("");
    }    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object evt = ae.getSource();
        
        if(evt.equals(view.btnConvertir)){
            
            if(validarCampos(view.txtNumerador)==true && validarCampos(view.txtDenominador)==true){
                
                try{
                
                    int numerador = Integer.parseInt(view.txtNumerador.getText());
                    int denominador = Integer.parseInt(view.txtDenominador.getText());   
                    
                    if(denominador!=0){
                        
                        Fraccion f1 = new Fraccion(numerador, denominador);
                        double decimal = f1.toDecimal();
                        view.txtResultado.setText(String.valueOf(decimal));
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Operacion invalida\nEl denominador debe ser distinto de 0", "ERROR", JOptionPane.ERROR_MESSAGE);                        
                    }
                    
                }catch(HeadlessException | NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Error de formato "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);                    
                }
            
            }else{
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }else if(evt.equals(view.btnLimpiar)){
            limpiarCampos();
        }
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {

        Object evt = ke.getSource();
        
        char c = ke.getKeyChar();
        
        if(evt.equals(view.txtNumerador)){
        
            if(c=='-'){
            
                String cadena = view.txtNumerador.getText();
                
                if(cadena.length()>0){
                
                    if(cadena.charAt(0)!='-'){
                        view.txtNumerador.setText("-"+cadena);
                        ke.consume();
                    }
                    
                }else{
                    view.txtNumerador.setText("-");
                }
            
            }
            
            if(validarNumero(ke)!=true){
                ke.consume();
            }
            
        }else if(evt.equals(view.txtDenominador)){


            if(c=='-'){
            
                String cadena = view.txtDenominador.getText();
                
                if(cadena.length()>0){
                
                    if(cadena.charAt(0)!='-'){
                        view.txtDenominador.setText("-"+cadena);
                        ke.consume();
                    }
                    
                }else{
                    view.txtDenominador.setText("-");
                }
            
            }
            
            if(validarNumero(ke)!=true){
                ke.consume();
            }            
        
        }
        
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
    
    
    
}
