package LogicaDeNegocio;

import Conexion.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Venta implements CalcularTotalYSubTotal{

    private int codigoVenta;
    private String fecha;
    private double total;
    private double subtotal;

    public String CrearVenta() {
        Conexion objmod = new Conexion();
        String cad = "insert into venta values('"
                +  getCodigoVenta()+"','" + this.getFecha()
                + "','" + this.getSubtotal() + "','" + this.getTotal()
                + "')";
        return objmod.Ejecutar(cad);
    }

    public Venta BuscarVenta(int codigoVenta) {
        Venta venta= new Venta();
        try {
            Conexion objmod = new Conexion();
            ResultSet objeto = objmod.Listar("select * from venta where vnt_cod='"
                    + codigoVenta + "'");
            while (objeto.next()){
                venta.setCodigoVenta(Integer.valueOf(objeto.getString("vnt_cod")));
                venta.setFecha(objeto.getString("vnt_date"));
                venta.setSubtotal(Double.valueOf(objeto.getString("vnt_subt")));
                venta.setTotal(Double.valueOf(objeto.getString("vnt_total")));
            }

        }
        catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return venta;
    }
    @Override
    public double total() {
        total=subtotal+(subtotal*IVA);
        return total;
    }

    @Override
    public double subTotal() {
        DetalleFactura detalleFactura = new DetalleFactura();
        for (DetalleFactura index:detalleFactura.detalleFactura()) {
            subtotal= subtotal+(index.getCantidadCompra()*index.getPrecio());
        }
        return subtotal;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }



    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
