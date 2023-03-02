package LogicaDeNegocio;

import Conexion.ConexionClientes;

public class Clientes {
    private int codigoCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String correoCliente;
    public String CrearCliente() {
        ConexionClientes objmod = new ConexionClientes();
        String cad = "insert into clientes values('"
                + getCodigoCliente() + "','" + this.getNombreCliente()
                + "','" + this.getApellidoCliente() + "','" + this.getCorreoCliente()
                + "')";
        return objmod.Ejecutar(cad);
    }
    public String ModificarCliente() {
        ConexionClientes objmod = new ConexionClientes();
        String cad = "update clientes set art_nom='"
                + this.getNombreCliente() + "', cli_apl='"
                + this.getApellidoCliente() + "', cli_cre='"
                + this.getCorreoCliente() + "' where cod_cli='"
                + this.getCodigoCliente() + "'";
        return objmod.Ejecutar(cad);
    }
    public String BuscarCliente() {
        ConexionClientes objmod = new ConexionClientes();
        String cad = "select * from clientes where cli_cod='"
                + this.getCodigoCliente() + "'";
        return objmod.Ejecutar(cad);
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
