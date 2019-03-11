package controller;

import fracciones.vistaPrincipal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener{
 
    vistaPrincipal view;
    
    public final void events(){
        view.btnOperacionesBasicas.addActionListener(this);
        view.btnDecimalFraccion.addActionListener(this);
        view.btnFraccionDecimal.addActionListener(this);
        view.btnSalir.addActionListener(this);
        view.panelOperacionesBasicas.btnRegresar.addActionListener(this);
        view.panelDecimalFraccion.btnRegresarPanelDecimalFraccion.addActionListener(this);
        view.panelFraccionDecimal.btnRegresar.addActionListener(this);
    }
    
    public Controller(vistaPrincipal view){
        this.view=view;
        events();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object evt = e.getSource();
        
        if(evt.equals(view.btnOperacionesBasicas)){
            /*Ocultamos los JPanel que no seran visibles*/
            view.panelMenu.setVisible(false);
            view.panelDecimalFraccion.setVisible(false);
            view.panelFraccionDecimal.setVisible(false);
            view.panelOperacionesBasicas.setVisible(true);
            
            /*Agregamos el JPanel que deseamos mostrar, este sera agregado al contenedor*/            
            view.Contenedor.add(view.panelOperacionesBasicas, BorderLayout.CENTER);
            view.Contenedor.validate();
            
        }else if(evt.equals(view.btnDecimalFraccion)){

            /*Ocultamos los JPanel que no seran visibles*/            
            view.panelMenu.setVisible(false);
            view.panelOperacionesBasicas.setVisible(false);
            view.panelFraccionDecimal.setVisible(false);
            view.panelDecimalFraccion.setVisible(true);  
            
            /*Agregamos el JPanel que deseamos mostrar, este sera agregado al contenedor*/
            view.Contenedor.add(view.panelDecimalFraccion, BorderLayout.CENTER);
            view.Contenedor.validate();
        
        }else if(evt.equals(view.btnFraccionDecimal)){

            /*Ocultamos los JPanel que no seran visibles*/                        
            view.panelMenu.setVisible(false);
            view.panelOperacionesBasicas.setVisible(false);
            view.panelDecimalFraccion.setVisible(false);            
            view.panelFraccionDecimal.setVisible(true);
            
            /*Agregamos el JPanel que deseamos mostrar, este sera agregado al contenedor*/            
            view.Contenedor.add(view.panelFraccionDecimal, BorderLayout.CENTER);
            view.Contenedor.validate();
            
        }else if(evt.equals(view.panelFraccionDecimal.btnRegresar) || evt.equals(view.panelOperacionesBasicas.btnRegresar) || evt.equals(view.panelDecimalFraccion.btnRegresarPanelDecimalFraccion)){
            /*Ocultamos los JPanel que no seran visibles*/                        
            view.panelOperacionesBasicas.setVisible(false);
            view.panelDecimalFraccion.setVisible(false);    
            view.panelFraccionDecimal.setVisible(false);
            view.panelMenu.setVisible(true);
            
            /*Agregamos el JPanel que deseamos mostrar, este sera agregado al contenedor*/            
            view.Contenedor.add(view.panelMenu, BorderLayout.CENTER);
            view.Contenedor.validate();
            
        }else if(evt.equals(view.btnSalir)){
            System.exit(0);
        }
        
    }
    
}
