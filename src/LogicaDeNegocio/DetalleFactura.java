package LogicaDeNegocio;

import Conexion.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetalleFactura {
    private int codigoProducto;
    private String descripcion;
    private int precio;
    private int cantidadCompra;

    public String agregarProductoFactura(){
        Conexion objmod = new Conexion();
        String cad = "insert into detalleFactura values('"
                + getCodigoProducto() + "','" + this.getDescripcion()
                + "','" + this.getCantidadCompra() + "','" + this.getPrecio()
                + "')";
        return objmod.Ejecutar(cad);

    }
    public String eliminarFactura(){
        Conexion objmod = new Conexion();
        String cad =" delete from detallefactura ";
        return objmod.Ejecutar(cad);
    }
    public ArrayList<DetalleFactura> detalleFactura() {
        ArrayList listaDetalleVenta = new ArrayList();
        try {
            Conexion objmod = new Conexion();
            ResultSet tabla = objmod.Listar("select * from detallefactura");
            DetalleFactura objart;
            while (tabla.next()) {
                objart = new DetalleFactura();
                objart.setCodigoProducto(tabla.getInt("dfc_prc_cod"));
                objart.setDescripcion(tabla.getString("dfc_prc_des"));
                objart.setCantidadCompra(tabla.getInt("dfc_prc_cnt"));
                objart.setPrecio(tabla.getInt("dfc_prc_pre"));

                listaDetalleVenta.add(objart);
            }
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listaDetalleVenta;
    }
    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(int cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }
}
