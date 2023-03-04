package LogicaDeNegocio;

import Conexion.Conexion;

public class Empleados {

    private int codigoEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String correoEmpleado;
    private String contraseñaEmpleado;
    private String cargoEmpleado;

    public String BuscarEmpleado(){
        Conexion objmod = new Conexion();
        String cad = "select * from empleados where emp_cod='"
                + this.getCodigoEmpleado() + "'";

        return objmod.Ejecutar(cad);
    }
    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public void setContraseñaEmpleado(String contraseñaEmpleado) {
        this.contraseñaEmpleado = contraseñaEmpleado;
    }

    public void setCargoEmpleado(String cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public String getContraseñaEmpleado() {
        return contraseñaEmpleado;
    }

    public String getCargoEmpleado() {
        return cargoEmpleado;
    }



}
