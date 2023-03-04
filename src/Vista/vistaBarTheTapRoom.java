package Vista;

import LogicaDeNegocio.Clientes;
import LogicaDeNegocio.Productos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaBarTheTapRoom extends javax.swing.JFrame {
    private JButton crearCliente;
    private JButton buscarCliente;
    private JButton modificarCliente;
    private JButton buacarVenta;
    private JButton adicionarVenta;
    private JButton corregirVenta;
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

    public vistaBarTheTapRoom() {
        setContentPane(vistaBarTheTapRoom);
        setTitle("BarTheTapRoom");
        setSize(1100, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        nombreEmpleado.setEnabled(false);
        codigoEmpleado.setEnabled(false);
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

    public void createTable() {
        tblDetalleVenta.setModel(new DefaultTableModel(new Object[][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
        },
                new String[] {
                        "Codigo de producto", "Descripcion", "Cantidad", "Precio unitario"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

    }
    public void buscarClienteActionPerformed(java.awt.event.ActionEvent evt){
        Clientes cliente =new Clientes();
        Clientes clienteBuscado =new Clientes();
        int id = Integer.valueOf(idCliente.getText());
        clienteBuscado=cliente.BuscarCliente(id);
        nombreCliente.setText(clienteBuscado.getNombreCliente());
        apellidoCliente.setText(clienteBuscado.getApellidoCliente());
        correoCliente.setText(clienteBuscado.getCorreoCliente());
    }
    public void buscarProductoActionPerformed(java.awt.event.ActionEvent evt){
        Productos producto =new Productos();
        Productos productoBuscado =new Productos();
        int CodigoProducto = Integer.valueOf(codigoProducto.getText());
        productoBuscado=producto.BuscarProducto(CodigoProducto);
        descripcionProducto.setText(productoBuscado.getDescripcionProducto());
        precioProducto.setText(String.valueOf(productoBuscado.getPrecio()));
    }
    public void CrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtGrabarActionPerformed
        Clientes objart = new Clientes();
        objart.setCodigoCliente(Integer.valueOf(this.idCliente.getText()));
        objart.setNombreCliente(this.nombreCliente.getText());
        objart.setApellidoCliente(this.apellidoCliente.getText());
        objart.setCorreoCliente(this.correoCliente.getText());;
        JOptionPane.showMessageDialog(null, objart.CrearCliente());
    }
    public void ModificarClienteActionPerformed(java.awt.event.ActionEvent evt){
        Clientes objart = new Clientes();
        objart.setCodigoCliente(Integer.valueOf(this.idCliente.getText()));
        objart.setNombreCliente(this.nombreCliente.getText());
        objart.setApellidoCliente(this.apellidoCliente.getText());
        objart.setCorreoCliente(this.correoCliente.getText());
        JOptionPane.showMessageDialog(null, objart.ModificarCliente());
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