package Vista;

import LogicaDeNegocio.Empleados;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends javax.swing.JFrame{
    private JTextField usuario;
    private JPasswordField contraseña;
    private JButton entrarButton;
    private JPanel login;

    public Login() {
        setContentPane(login);
        setTitle("BarTheTapRoom");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginActionPerformed(e);
            }
        });
    }
    public void loginActionPerformed(java.awt.event.ActionEvent evt) {
        Empleados empleado = new Empleados();
        Empleados empleadoBuscar = new Empleados();
        String correo = usuario.getText();
        empleadoBuscar = empleado.logearse(correo);
        if(empleadoBuscar.getCorreoEmpleado().equals(usuario.getText())){
            if (empleadoBuscar.getContraseñaEmpleado().equals(String.valueOf(contraseña.getPassword()))){
                vistaBarTheTapRoom vistaBarTheTapRoom =new vistaBarTheTapRoom();
                vistaBarTheTapRoom.accionarEmpleado(empleadoBuscar.getCodigoEmpleado(),empleadoBuscar.getNombreEmpleado());
                this.dispose();

            }
            else {
                JOptionPane.showMessageDialog(null, "USUARIO INCORRECTO");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "USUARIO INCORRECTO");
        }
    }

        public static void main (String[] args) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Login();
                }
            });
        }



}
