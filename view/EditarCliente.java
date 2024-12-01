package view;

import javax.swing.*;

import controller.ClienteController;
import model.Cliente;
import model.DataModel;

import java.awt.*;

public class EditarCliente extends JPanel {
    private static JTextField nombreField;
    private static JTextField apellidosField;
    private static JTextField dniField;
    private static JTextField correoField;
    private static JTextField telefonoField;
    private static JTextField direccionField;
    private static JComboBox<String> sexoBox;
    private static Cliente clienteID;
    private JButton registrarButton;

    public EditarCliente() {
        initComponents();
    }

    private void initComponents() {
        // Crear los componentes de la interfaz
        JLabel tit = new JLabel("Registro de Cliente:");
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(20);

        JLabel apellidosLabel = new JLabel("Apellidos:");
        apellidosField = new JTextField(20);

        JLabel dniLabel = new JLabel("Cedula:");
        dniField = new JTextField(20);

        JLabel correoLabel = new JLabel("Correo Electrónico:");
        correoField = new JTextField(20);

        JLabel telefonoLabel = new JLabel("Número de Teléfono:");
        telefonoField = new JTextField(20);

        JLabel direccionLabel = new JLabel("Dirección:");
        direccionField = new JTextField(20);

        JLabel sexoLabel = new JLabel("Sexo:");
        String[] sexos = { "Masculino", "Femenino", "Otro" };
        sexoBox = new JComboBox<>(sexos);

        registrarButton = new JButton("Editar");
        registrarButton.addActionListener(e -> editarCliente());

        // Configurar el layout de la interfaz
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Añadir componentes al layout
        add(new JLabel(), gbc);
        gbc.gridx++;
        add(tit, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(nombreLabel, gbc);
        gbc.gridx++;
        add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(apellidosLabel, gbc);
        gbc.gridx++;
        add(apellidosField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(dniLabel, gbc);
        gbc.gridx++;
        add(dniField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(correoLabel, gbc);
        gbc.gridx++;
        add(correoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(telefonoLabel, gbc);
        gbc.gridx++;
        add(telefonoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(direccionLabel, gbc);
        gbc.gridx++;
        add(direccionField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(sexoLabel, gbc);
        gbc.gridx++;
        add(sexoBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registrarButton, gbc);
    }

    /*
     * private void registroCliente() {
     * String res = ctrlCliente.registrarCliente();
     * if (res == "OK") {
     * JOptionPane.showMessageDialog(this, "Datos guardados satisfactoriamente.");
     * System.out.println(DataModel.getInstance().getClientes().toString());
     * } else {
     * JOptionPane.showMessageDialog(this, res);
     * }
     * }
     */

    private void editarCliente() {
        String res = ClienteController.editarCliente();
        if (res == "OK") {
            JOptionPane.showMessageDialog(this, "Datos editados satisfactoriamente.");
            System.out.println(DataModel.getInstance().getClientes().toString());
        } else {
            JOptionPane.showMessageDialog(this, res);
        }
    }

    public static JTextField getNombreField() {
        return EditarCliente.nombreField;
    }

    public static JTextField getApellidosField() {
        return EditarCliente.apellidosField;
    }

    public static JTextField getCedulaField() {
        return EditarCliente.dniField;
    }

    public static JTextField getCorreoField() {
        return EditarCliente.correoField;
    }

    public static JTextField getTelefonoField() {
        return EditarCliente.telefonoField;
    }

    public static JTextField getDireccionField() {
        return EditarCliente.direccionField;
    }

    public static JComboBox<String> getSexoBox() {
        return EditarCliente.sexoBox;
    }

    public JButton getRegistrarButton() {
        return this.registrarButton;
    }

    public static void setClienteID(Cliente item) {
        clienteID = item;
    }

    public static Cliente getClienteID() {
        return clienteID;
    }

}
