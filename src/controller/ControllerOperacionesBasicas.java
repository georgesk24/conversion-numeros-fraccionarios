
package controller;

import fracciones.PanelOperacionesBasicas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import model.Fraccion;

/**
 *
 * @author Software Galaxia TV
 */
public class ControllerOperacionesBasicas extends ControllerGeneral implements ActionListener, KeyListener{
    
    PanelOperacionesBasicas view;

    /*agregamos eventos*/
    public final void events(){
        view.btnLimpiar.addActionListener(this);
        view.btnCalcular.addActionListener(this);
        view.text1Numerador.addKeyListener(this);
        view.text1Denominador.addKeyListener(this);
        view.text2Denominador.addKeyListener(this);
        view.text2Numerador.addKeyListener(this);
    }
    
    /*Metodo constructor de la clase, inicializamos la vista y llamamos el metodo events()*/
    public ControllerOperacionesBasicas(PanelOperacionesBasicas view){
        this.view=view;
        events();
    }
    
    /*metodos para realizar las operaciones basicas (suma, resta, multiplicacion, division)*/
    public String sumar(Fraccion f1, Fraccion f2){
        return f1.sumar(f2).toString();
    }
    
    public String restar(Fraccion f1, Fraccion f2){
        return f1.restar(f2).toString();
    }    
    
    public String multiplicar(Fraccion f1, Fraccion f2){
        return f1.multiplicar(f2).toString();
    }    
    
    public String dividir(Fraccion f1, Fraccion f2){
        return f1.dividir(f2).toString();
    }    
    
    /*Limpiamos los campos de texto*/
    public void limpiarCampos(){
        view.text1Numerador.setText("");
        view.text1Denominador.setText("");
        view.text2Numerador.setText("");
        view.text2Denominador.setText("");
        view.text3Resultado.setText("");
    }
    
    /*Metodos para controlar los respectivos eventos que se ejecuten*/
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evt = ae.getSource();
        
        if(evt.equals(view.btnLimpiar)){
        
            limpiarCampos();
        
        }else if(evt.equals(view.btnCalcular)){
            
            if(validarCampos(view.text1Numerador)==true && validarCampos(view.text1Denominador)==true &&
               validarCampos(view.text2Numerador)==true && validarCampos(view.text2Denominador)==true){

                try{
                
                    int numerador1 = Integer.parseInt(view.text1Numerador.getText());
                    int denominador1 = Integer.parseInt(view.text1Denominador.getText());
                    
                    int numerador2 = Integer.parseInt(view.text2Numerador.getText());
                    int denominador2 = Integer.parseInt(view.text2Denominador.getText());
                    
                    Fraccion f1 = new Fraccion(numerador1, denominador1);
                    Fraccion f2 = new Fraccion(numerador2, denominador2);                    
                
                    String resultado="";
                    
                    switch(view.jcOperaciones.getSelectedItem().toString()){
                        
                        case "+":
                            resultado = sumar(f1, f2);
                        break;
                        
                        case "-":
                            resultado = restar(f1, f2);
                        break;
                        
                        case "*":
                            resultado = multiplicar(f1, f2);
                        break;
                        
                        case "/":
                            resultado = dividir(f1, f2);
                        break;
                        
                    }
                    
                    if(!resultado.equals("El denominador debe ser distinto de 0")){
                        view.text3Resultado.setText(resultado);
                    }else{
                        JOptionPane.showMessageDialog(null, "Error De Ejecución \n El denominador de la fracción debe ser distinto de 0", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Formato Invalido "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            
            }else{
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
        Object evt = ke.getSource();
        
        if(evt.equals(view.text1Numerador)){
            validarNumero(ke);           
        }else if(evt.equals(view.text1Denominador)){
            validarNumero(ke);           
        }else if(evt.equals(view.text2Numerador)){
            validarNumero(ke);           
        }else if(evt.equals(view.text2Denominador)){
            validarNumero(ke);           
        }
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
    
}
