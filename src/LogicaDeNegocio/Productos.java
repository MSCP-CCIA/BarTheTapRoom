package LogicaDeNegocio;
import Conexion.ConexionProductos;
public class Productos {
    private  int id_producto;
    private String NombreProducto;
    private double Grado_Alcohol;
    private String Marca;
    private int Stock;
    private int precio;

    public String ModificarProducto(){
        ConexionProductos objmod = new ConexionProductos();
        String cad = "select * from productos where prod_cod='"
                + this.getId_producto() + "'";
        return objmod.Ejecutar(cad);
    }
    public String BuscarProducto(){
        ConexionProductos objmod = new ConexionProductos();
        String cad = "select * from productos where prod_cod='"
                + this.getId_producto()+"'";
        return objmod.Ejecutar(cad);
    }
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public double getGrado_Alcohol() {
        return Grado_Alcohol;
    }

    public void setGrado_Alcohol(double Grado_Alcohol) {
        this.Grado_Alcohol = Grado_Alcohol;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
