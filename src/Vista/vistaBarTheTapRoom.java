package Vista;

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

    public vistaBarTheTapRoom() {
        setContentPane(vistaBarTheTapRoom);
        setTitle("BarTheTapRoom");
        setSize(1100, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        nombreEmpleado.setEnabled(false);
        codigoEmpleado.setEnabled(false);
        buacarVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        crearCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        private void buscarClienteActionPerformed(ActionEvent evt) {
            
        }
}