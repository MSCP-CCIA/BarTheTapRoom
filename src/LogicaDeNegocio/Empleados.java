package LogicaDeNegocio;

import Conexion.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Empleados {

    private int codigoEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String correoEmpleado;
    private String contraseñaEmpleado;
    private String cargoEmpleado;

    public Empleados logearse(String correoEmpleado) {
        Empleados empleado = new Empleados();
        try {
            Conexion objmod = new Conexion();
            ResultSet objeto = objmod.Listar("select * from empleados where emp_cre='"
                    + correoEmpleado + "'");
            while (objeto.next()){
                empleado.setCodigoEmpleado(Integer.valueOf(objeto.getString("emp_cod")));
                empleado.setNombreEmpleado(objeto.getString("emp_nom"));
                empleado.setContraseñaEmpleado(objeto.getString("emp_pass"));
                empleado.setCorreoEmpleado(objeto.getString("emp_cre"));
            }

        }
        catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return empleado;
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
