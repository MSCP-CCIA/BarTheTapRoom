package LogicaDeNegocio;

import Conexion.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Clientes {
    private int codigoCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String correoCliente;
    public String CrearCliente() {
        Conexion objmod = new Conexion();
        String cad = "insert into clientes values('"
                + getCodigoCliente() + "','" + this.getNombreCliente()
                + "','" + this.getApellidoCliente() + "','" + this.getCorreoCliente()
                + "')";
        return objmod.Ejecutar(cad);
    }
    public String ModificarCliente() {
        Conexion objmod = new Conexion();
        String cad = "update clientes set cli_nom='"
                + this.getNombreCliente() + "', cli_apl='"
                + this.getApellidoCliente() + "', cli_cre='"
                + this.getCorreoCliente() + "' where cli_cod='"
                + this.getCodigoCliente() + "'";
        return objmod.Ejecutar(cad);
    }
    public Clientes BuscarCliente(int codigoClienteAbuscar) {
        Clientes cliente = new Clientes();
        try {
            Conexion objmod = new Conexion();
            ResultSet objeto = objmod.Listar("select * from clientes where cli_cod='"
                    + codigoClienteAbuscar + "'");
            while (objeto.next()){
                cliente.setNombreCliente(objeto.getString("cli_nom"));
                cliente.setApellidoCliente(objeto.getString("cli_apl"));
                cliente.setCorreoCliente(objeto.getString("cli_cre"));
            }

        }
        catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return cliente;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
}
