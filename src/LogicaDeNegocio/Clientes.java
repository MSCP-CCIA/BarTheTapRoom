package LogicaDeNegocio;

import Conexion.ConexionClientes;

public class Clientes {
    private int codigoCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String correoCliente;
    public String CrearCliente() {
        ConexionClientes objmod = new ConexionClientes();
        String cad = "insert into articulo values('"
                + getCodigoCliente() + "','" + this.getNombreCliente()
                + "','" + this.getApellidoCliente() + "','" + this.getCorreoCliente()
                + "')";
        return objmod.Ejecutar(cad);
    }
    public String ModificarCliente() {
        ConexionClientes objmod = new ConexionClientes();
        String cad = "update articulo set art_nom='"
                + this.getNombreCliente() + "', cli_nom='"
                + this.getApellidoCliente() + "', cli_apl='"
                + this.getCodigoCliente() + "'where cli_cre='"
                + this.getCodigoCliente() + "'";
        return objmod.Ejecutar(cad);
    }
    public String BuscarCliente() {
        ConexionClientes objmod = new ConexionClientes();
        String cad = "select * ='"
                + this.getNombreCliente() + "', cli_nom='"
                + this.getApellidoCliente() + "', cli_apl='"
                + this.getCodigoCliente() + "'where cli_cre='"
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
