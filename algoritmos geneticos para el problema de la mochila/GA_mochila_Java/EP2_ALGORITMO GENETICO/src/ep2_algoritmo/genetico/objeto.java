/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2_algoritmo.genetico;

/**
 *
 * @author HUGO
 */
public class objeto {

    public objeto() {
    }

  
    
    private String nombre;
    private int peso;
    private int beneficio;
    
      public objeto(String nombre, int peso, int beneficio) {
        this.nombre = nombre;
        this.peso = peso;
        this.beneficio = beneficio;
    }
      
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }
    
    
    
}
