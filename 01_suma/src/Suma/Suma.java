/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suma;

import Funciones.IOBinFile;
import Funciones.MyListArgs;
import Funciones.MySintaxis;

/**
 *
 * @author miguel
 */
public class Suma {

    /**
     * @param args the command line arguments
     */
    String   OUT  = "";
    int      op1  =  0;
    int      op2  =  0;
    int      suma =  0;
    
    
    Suma(String[] args) {
        // TODO code application logic here
        String        ConfigFile = "";
        
        
        MyListArgs    Param         ;
        
        Param      = new MyListArgs(args)                  ;
        ConfigFile = Param.ValueArgsAsString("-CONFIG", "");
        
        if (!ConfigFile.equals("")) 
        {
            Param.AddArgsFromFile(ConfigFile);
           }//fin if
        
        String Sintaxis   = "-OP1:int -OP2:int -OUT:str";
        MySintaxis Review = new MySintaxis(Sintaxis, Param);
        //PARAMETROS FORZOSOS                  
        
        op1     = Param.ValueArgsAsInteger("-OP1", 0 );
        op2     = Param.ValueArgsAsInteger("-OP2", 0 );
        OUT     = Param.ValueArgsAsString ("-OUT", "");
    }
    
    public void Suma()
    {
        this.suma = this.op1+this.op2;      
    }
    public void saveSuma(){
        IOBinFile.WriteBinFloatFileIEEE754(OUT, new float[]{suma}); 
    }
    
}
