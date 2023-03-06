package Conexion;
import java.sql.*;
public class Conexion {
    //Establecer conexion con base de datos
    private final String url = "jdbc:mysql://localhost:3306/barthetaproom";
    private final String user = "root";
    private final String pwd = "";

    //Constructor
    public Conexion() {
    }

    public ResultSet Listar(String Cad) {
        try {
            //DriverManager es una clase que gestiona el conjunto de controladores Java Database Connectivity (JDBC)
            //getConnection es un método de la clase DriverManager que permite establecer una conexión con la base de datos especificada
            Connection cn = DriverManager.getConnection(url, user, pwd); //Connection es una clase que permite realizar modificaciones y consultas en una DB
            PreparedStatement da = cn.prepareStatement(Cad); //PreparedStatement es una clase que permite compilar y ejecutar código SQL
            ResultSet tbl = da.executeQuery(); //executeQuery devuelve una tabla que queda almacenada dentro del objeto ResultSet
            //ResultSet es una clase que permite contener los resultados de una consulta SQL que contiene una lista de filas obtenidas desde una DB
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
