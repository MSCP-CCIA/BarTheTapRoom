package Vista;

import LogicaDeNegocio.Clientes;
import LogicaDeNegocio.DetalleFactura;
import LogicaDeNegocio.Productos;
import LogicaDeNegocio.Venta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class vistaBarTheTapRoom extends javax.swing.JFrame {
    private JButton crearCliente;
    private JButton buscarCliente;
    private JButton modificarCliente;
    private JButton buscarVenta;
    private JButton pagar;
    private JButton buscarProducto;
    private JTable tblDetalleVenta;
    private JTextField codigoProducto;
    private JTextField idCliente;
    private JTextField nombreCliente;
    private JTextField apellidoCliente;
    private JTextField correoCliente;
    private JTextField codigoVenta;
    private JTextField fechaVenta;
    private JTextField subTotal;
    private JTextField total;
    private JTextField codigoEmpleado;
    private JTextField nombreEmpleado;
    private JTextField descripcionProducto;
    private JTextField precioProducto;
    private JPanel vistaBarTheTapRoom;
    private JButton limpiarCliente;
    private JButton agregarAlaFactura;
    private JButton limpiarProducto;
    private JTextField cantidadDeCompra;
    private JButton limpiarVenta;

    public vistaBarTheTapRoom() {
        setContentPane(vistaBarTheTapRoom);
        setTitle("BarTheTapRoom");
        setSize(2000, 800);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);


        ListarArticulos();
        tblDetalleVenta.setAutoCreateRowSorter(true);

        tblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {},
                        {},
                        {},
                        {}
                },
                new String[]{

                }
        ));


        nombreEmpleado.setEnabled(false);
        codigoEmpleado.setEnabled(false);
        fechaVenta.setEnabled(false);
        subTotal.setEnabled(false);
        total.setEnabled(false);
        descripcionProducto.setEnabled(false);
        precioProducto.setEnabled(false);

        buscarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarClienteActionPerformed(e);
            }
        });
        crearCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearClienteActionPerformed(e);
            }
        });
        limpiarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCajasClientes();
            }
        });
        modificarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificarClienteActionPerformed(e);
            }
        });
        buscarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductoActionPerformed(e);
            }
        });
        agregarAlaFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAFacturaActionPerformed(e);

            }
        });
        pagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagarActionPerformed(e);
            }
        });
        limpiarVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCajasVentas();
            }
        });
        buscarVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarVentaActionPerformed(e);
            }
        });
        limpiarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCajasProductos();
            }
        });
    }

    public void limpiarCajasClientes() {
        this.idCliente.setText("");
        this.nombreCliente.setText("");
        this.apellidoCliente.setText("");
        this.correoCliente.setText("");
    }

    public void limpiarCajasVentas() {
        this.codigoVenta.setText("");
        this.fechaVenta.setText("");
        this.subTotal.setText("");
        this.total.setText("");
    }

    public void limpiarCajasProductos() {
        this.codigoProducto.setText("");
        this.descripcionProducto.setText("");
        this.precioProducto.setText("");
    }




    public void buscarClienteActionPerformed(java.awt.event.ActionEvent evt){
        Clientes cliente =new Clientes();
        Clientes clienteBuscado =new Clientes();
        if(idCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "INGRESE UN ID VALIDO");
        }
        else {
            int id = Integer.valueOf(idCliente.getText());
            clienteBuscado = cliente.BuscarCliente(id);
            if(clienteBuscado.getCodigoCliente()==0){
                JOptionPane.showMessageDialog(null, "INGRESE UN ID VALIDO");
            }
            else {
                nombreCliente.setText(clienteBuscado.getNombreCliente());
                apellidoCliente.setText(clienteBuscado.getApellidoCliente());
                correoCliente.setText(clienteBuscado.getCorreoCliente());
            }
        }
    }
    public void buscarProductoActionPerformed(java.awt.event.ActionEvent evt){
        Productos producto =new Productos();
        Productos productoBuscado =new Productos();
        if(codigoProducto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "INGRESE UN CODIGO VALIDOFFFF");
        }
        else {
            int CodigoProducto = Integer.valueOf(codigoProducto.getText());
            productoBuscado = producto.BuscarProducto(CodigoProducto);
            if(productoBuscado.getCodigoProducto()==0){
                JOptionPane.showMessageDialog(null, "INGRESE UN ID VALIDO");
            }else {
                descripcionProducto.setText(productoBuscado.getDescripcionProducto());
                precioProducto.setText(String.valueOf(productoBuscado.getPrecio()));
            }

        }
    }
    public void buscarVentaActionPerformed(java.awt.event.ActionEvent evt){
        Venta venta =new Venta();
        Venta ventaBuscar =new Venta();
        if(codigoVenta.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "INGRESE UN CODIGO VALIDO");
        }
        else {
            int CodigoVenta = Integer.valueOf(codigoVenta.getText());
            ventaBuscar = venta.BuscarVenta(CodigoVenta);
            if(ventaBuscar.getCodigoVenta()==0){
                JOptionPane.showMessageDialog(null, "INGRESE UN ID VALIDO");
            }else {
                fechaVenta.setText(ventaBuscar.getFecha());
                subTotal.setText(String.valueOf(ventaBuscar.getSubtotal()));
                total.setText(String.valueOf(ventaBuscar.getTotal()));
            }

        }
    }
    public void accionarEmpleado(int CodigoEmpleado, String NombreEmpleado){
        codigoEmpleado.setText(String.valueOf(CodigoEmpleado));
        nombreEmpleado.setText(NombreEmpleado);
    }
    public void CrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtGrabarActionPerformed
        if(idCliente.getText().isEmpty()&&nombreCliente.getText().isEmpty()&&apellidoCliente.getText().isEmpty()&&correoCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS");
        }
        else {

            Clientes objart = new Clientes();
            objart.setCodigoCliente(Integer.valueOf(this.idCliente.getText()));
            objart.setNombreCliente(this.nombreCliente.getText());
            objart.setApellidoCliente(this.apellidoCliente.getText());
            objart.setCorreoCliente(this.correoCliente.getText());
            ;
            JOptionPane.showMessageDialog(null, objart.CrearCliente());
        }
    }
    public void ModificarClienteActionPerformed(java.awt.event.ActionEvent evt){
        if(idCliente.getText().isEmpty()&&nombreCliente.getText().isEmpty()&&apellidoCliente.getText().isEmpty()&&correoCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS");
        }
        else {

            Clientes objart = new Clientes();
            objart.setCodigoCliente(Integer.valueOf(this.idCliente.getText()));
            objart.setNombreCliente(this.nombreCliente.getText());
            objart.setApellidoCliente(this.apellidoCliente.getText());
            objart.setCorreoCliente(this.correoCliente.getText());
            JOptionPane.showMessageDialog(null, objart.ModificarCliente());
        }
    }
    public void agregarAFacturaActionPerformed(java.awt.event.ActionEvent evt){
        if(cantidadDeCompra.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "COLOQUE UNA CANTIDAD VALIDA");
        }
        else {
            DetalleFactura detalleFactura = new DetalleFactura();
            Productos productos = new Productos();
            Productos productosABuscar = new Productos();
            productosABuscar = productos.BuscarProducto(Integer.valueOf(codigoProducto.getText()));
            if (Integer.valueOf(cantidadDeCompra.getText())>productosABuscar.getCantidad()){
                JOptionPane.showMessageDialog(null, "NO HAY SUFICIENTE STOCK");
            }
            else {

                detalleFactura.setCodigoProducto(Integer.valueOf(codigoProducto.getText()));
                detalleFactura.setDescripcion(productosABuscar.getDescripcionProducto());
                detalleFactura.setCantidadCompra(Integer.valueOf(cantidadDeCompra.getText()));
                detalleFactura.setPrecio(productosABuscar.getPrecio());
                JOptionPane.showMessageDialog(null, detalleFactura.agregarProductoFactura());

            }
        }
    }
    public void pagarActionPerformed(java.awt.event.ActionEvent evt){
        Venta venta = new Venta();
        DetalleFactura detalleFactura =new DetalleFactura();
        Productos productos = new Productos();
        Productos productosABuscar = new Productos();
        productosABuscar = productos.BuscarProducto(Integer.valueOf(codigoProducto.getText()));
        if(detalleFactura.detalleFactura().isEmpty()){
            JOptionPane.showMessageDialog(null, "NO HA COMPRADO");
        }
        else {

            venta.setCodigoVenta((int) (Math.random() * 100000 + 999999));
            codigoVenta.setText(String.valueOf(venta.getCodigoVenta()));
            LocalDate fechaDeVenta = LocalDate.now();
            venta.setFecha(String.valueOf(fechaDeVenta));
            fechaVenta.setText(String.valueOf(venta.getFecha()));
            venta.setSubtotal(venta.subTotal());
            subTotal.setText(String.valueOf(venta.getSubtotal()));
            venta.setTotal(venta.total());
            total.setText(String.valueOf(venta.getTotal()));
            JOptionPane.showMessageDialog(null, venta.CrearVenta());
            detalleFactura.eliminarFactura();
            int reducir=productosABuscar.getCantidad()-Integer.valueOf(cantidadDeCompra.getText());
            productosABuscar.setCantidad(reducir);
            JOptionPane.showMessageDialog(null, productosABuscar.ModificarStock());
            limpiarCajasClientes();
            limpiarCajasProductos();
            ListarArticulos();
        }
    }





    public void ListarArticulos() {
        DefaultTableModel tabla = new DefaultTableModel();
        DetalleFactura objart = new DetalleFactura();
        ArrayList<DetalleFactura> lista2 = new ArrayList();
        lista2 = objart.detalleFactura();
        tabla.addColumn("Codigo");
        tabla.addColumn("Descripción");
        tabla.addColumn("Unidades compradas");
        tabla.addColumn("Precio");

        tabla.setRowCount(lista2.size());
        int i = 0;
        for (DetalleFactura x : lista2) {
            tabla.setValueAt(x.getCodigoProducto(), i, 0);
            tabla.setValueAt(x.getDescripcion(), i, 1);
            tabla.setValueAt(x.getCantidadCompra(), i, 2);
            tabla.setValueAt(x.getPrecio(), i, 3);

            i++;

        }
        this.tblDetalleVenta.setModel(tabla);
    }


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaBarTheTapRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaBarTheTapRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaBarTheTapRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaBarTheTapRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaBarTheTapRoom();
            }
        });
    }
}