package Conexion;

import java.sql.*;

public class ConexionVenta {
    //Establecer conexion con base de datos
    private final String url = "jdbc:mysql://localhost:3306/venta";
    private final String user = "root";
    private final String pwd = "";

    //Constructor
    public ConexionVenta() {
    }

    public ResultSet Listar(String Cad) {
        try {
            Connection cn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement da = cn.prepareStatement(Cad);
            ResultSet tbl = da.executeQuery();
            return tbl;
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public String Ejecutar(String Cad) {
        try {
            Connection cn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement da = cn.prepareStatement(Cad);
            int r = da.executeUpdate();
            if (r == 0) return "0";
            return "Se afectaron " + r + " filas";
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return "Error" + e.getMessage();
        }
    }
}
