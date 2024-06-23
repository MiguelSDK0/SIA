/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Miguel
 */
public class Recibo {
    private int codRecibo;
    private int codDeuda;
    private int codCliente;
    private int codDocumento;
    private int codTipoPago;
    private String fecha;
    private String fechaExp;
    private double monto;

    public Recibo() {
    }

    public Recibo(int codRecibo, int codDeuda, int codCliente, int codDocumento, int codTipoPago, String fecha, String fechaExp, double deuda, double monto) {
        this.codRecibo = codRecibo;
        this.codDeuda = codDeuda;
        this.codCliente = codCliente;
        this.codDocumento = codDocumento;
        this.codTipoPago = codTipoPago;
        this.fecha = fecha;
        this.fechaExp = fechaExp;
        this.monto = monto;
    }

    public int getCodRecibo() {
        return codRecibo;
    }

    public void setCodRecibo(int codRecibo) {
        this.codRecibo = codRecibo;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodDeuda() {
        return codDeuda;
    }

    public void setCodDeuda(int codDeuda) {
        this.codDeuda = codDeuda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }

    public int getCodDocumento() {
        return codDocumento;
    }

    public void setCodDocumento(int codDocumento) {
        this.codDocumento = codDocumento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getCodTipoPago() {
        return codTipoPago;
    }

    public void setCodTipoPago(int codTipoPago) {
        this.codTipoPago = codTipoPago;
    }
}
