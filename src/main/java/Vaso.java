/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author raula
 */
class Vaso {
    private int cantidadVasos;
    private int contenido;
        
       public Vaso(int cantidad, int contenido) {
        this.cantidadVasos = cantidad;  
        this.contenido = contenido;
    }

    public void setCantidadVasos(int cantidadVasos) {
        this.cantidadVasos = cantidadVasos;
    }

    public int getCantidadVasos() {
        return cantidadVasos;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public int getContenido() {
        return contenido;
    }

    public boolean hasVasos(int cantidadVasos) {
        return this.cantidadVasos >= cantidadVasos;
    }

    public void giveVasos(int cantidadVasos) {
        if (hasVasos(cantidadVasos)) {
            this.cantidadVasos -= cantidadVasos;
        }
    }
}


