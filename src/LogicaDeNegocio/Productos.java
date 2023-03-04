package LogicaDeNegocio;

import Conexion.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Productos {
    private int codigoProducto;
    private String descripcionProducto;
    private int cantidad;
    private int precio;
    private String tipo;

    public Productos BuscarProducto(int codigoProducto) {
        Productos producto = new Productos();
        try {
            Conexion objmod = new Conexion();
            ResultSet objeto = objmod.Listar("select * from productos where prc_cod='"
                    + codigoProducto + "'");
            while (objeto.next()){
                producto.setDescripcionProducto(objeto.getString("prc_des"));
                producto.setPrecio(Integer.valueOf(objeto.getString("prc_pre")));
            }
        }
        catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return producto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
