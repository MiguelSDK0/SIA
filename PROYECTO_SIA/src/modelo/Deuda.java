/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Miguel
 */
public class Deuda {
    private int id_deuda;
    private int id_cliente;
    private double monto;
    private String nombre;

    public Deuda() {
    }

    public Deuda(int id_deuda, int id_cliente, double monto, String nombre) {
        this.id_deuda = id_deuda;
        this.id_cliente = id_cliente;
        this.monto = monto;
        this.nombre = nombre;
    }

    public int getId_deuda() {
        return id_deuda;
    }

    public void setId_deuda(int id_deuda) {
        this.id_deuda = id_deuda;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
