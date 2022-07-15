
package com.sofka.controlador;

import com.sofka.modelo.LogicaNave;
import com.sofka.modelo.ModeloNave;
import com.sofka.vista.Main;
import com.sofka.vista.VistaNave;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author 57321
 */
public class ControladorNave implements ActionListener{
    
    private ModeloNave modelo;
    private LogicaNave logica;
    private VistaNave view;

    public ControladorNave(ModeloNave modelo, LogicaNave logica, VistaNave view) {
        this.modelo = modelo;
        this.logica = logica;
        this.view = view;
        this.view.BtnGuardar.addActionListener(this);
        this.view.BtnActualizar.addActionListener(this);
        this.view.BtnEliminar.addActionListener(this);
        this.view.BtnFiltrar.addActionListener(this);
    }
    
    public void iniciar(){
    
        view.setTitle("Nave espaciales");
        view.setLocationRelativeTo(null);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==view.BtnGuardar){
            modelo.setTipo(view.txttiponave.getText());
            modelo.setColor(view.txtcolornave.getText());
            modelo.setPeso(Integer.parseInt(view.txtpesonave.getText()));
        
        
        
        if(logica.registroNave(modelo)){
        
            JOptionPane.showMessageDialog(null, "nave registrada");   
            vaciar();
        }else{
            JOptionPane.showMessageDialog(null, "error al registrar la nave");
             vaciar();
        }}
        
        //_______________________________________________________________
        if(e.getSource()==view.BtnActualizar){
            modelo.setId(Integer.parseInt( view.txtidnave.getText()));
            modelo.setTipo(view.txttiponave.getText());
            modelo.setColor(view.txtcolornave.getText());
            modelo.setPeso(Integer.parseInt(view.txtpesonave.getText()));
        
        
        
        if(logica.ActualizarNave(modelo)){
        
            JOptionPane.showMessageDialog(null, "actualizado");   
            vaciar();
        }else{
            JOptionPane.showMessageDialog(null, "error al actualizar");
             vaciar();
        }}
       
      //_________________________________________________________________________
      if(e.getSource()==view.BtnEliminar){
            modelo.setId(Integer.parseInt( view.txtidnave.getText()));       
        
        
        if(logica.EliminarNave(modelo)){
        
            JOptionPane.showMessageDialog(null, "eliminado");   
            vaciar();
        }else{
            JOptionPane.showMessageDialog(null, "error al eliminar");
             vaciar();
        }
      }
        //_____________________________________________________________
        if(e.getSource()==view.BtnFiltrar){
            modelo.setTipo(view.txttiponave.getText());      
        
        
        if(logica.filtrarNave(modelo)){
            
            if(logica.filtrarNave(modelo)){
            
            view.txtidnave.setText(String.valueOf( modelo.getId()));
            view.txttiponave.setText(modelo.getTipo());
            view.txtcolornave.setText(modelo.getColor());
            view.txtpesonave.setText(String.valueOf(modelo.getPeso()));
            }
        
        }else{
            JOptionPane.showMessageDialog(null, "error al buscar");
             vaciar();
        }}
        
        if(e.getSource()==view.BtnVaciar){
            vaciar();
        }
    }
    

    
    public void vaciar(){
        view.txttiponave.setText(null);
        view.txtcolornave.setText(null);
        view.txtpesonave.setText(null);
        view.txtidnave.setText(null);
    
    }
}
