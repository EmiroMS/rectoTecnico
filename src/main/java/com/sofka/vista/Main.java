package com.sofka.vista;

import com.sofka.controlador.ControladorNave;
import com.sofka.modelo.LogicaNave;
import com.sofka.modelo.ModeloNave;

/**
 *
 * @author 57321
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        ModeloNave modelo= new ModeloNave();
        LogicaNave logica = new LogicaNave();
        VistaNave vista = new VistaNave();
        ControladorNave controlador = new ControladorNave(modelo,logica,vista);
        vista.setVisible(true);
        
    }
    
}
