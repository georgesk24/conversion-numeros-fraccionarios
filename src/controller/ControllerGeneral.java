package controller;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Software Galaxia TV
 */
public class ControllerGeneral {
    
    /*Validamos que el dato ingresado por teclado sea igual a un numero*/
    public boolean validarNumero(KeyEvent e){
        char key = e.getKeyChar();
        return Character.isDigit(key);    
    }
        
    /*Validamos que el campo de texto no este vacio*/
    public boolean validarCampos(JTextField textfield){
        return !textfield.getText().isEmpty() && textfield.getText().length()>0;
    }
    
    
}
