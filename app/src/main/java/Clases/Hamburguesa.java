package Clases;

import java.io.Serializable;

//Serializable
public class Hamburguesa implements Serializable {
    private String tipo;
    private boolean cebolla;

    public Hamburguesa(String tipo, boolean cebolla){
        this.tipo = tipo;
        this.cebolla = cebolla;


    }
    public String getTipo() {return tipo;}
    public boolean getCebolla() {return cebolla;}
}
