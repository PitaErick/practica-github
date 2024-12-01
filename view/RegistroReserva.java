package view;

import javax.swing.*;

import java.awt.*;

public class RegistroReserva extends JPanel {
    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField dniField;
    private JTextField correoField;
    private JTextField telefonoField;
    private JTextField direccionField;
    private JComboBox<String> sexoBox;
    private JButton registrarButton;

    public RegistroReserva() {
        initComponents();
    }

    private void initComponents() {
        // Crear los componentes de la interfaz
        JLabel tit = new JLabel("Registro de Reserva:");
        JLabel nombreLabel = new JLabel("Codigo Reserva:");
        nombreField = new JTextField(20);

        JLabel apellidosLabel = new JLabel("Fecha de Reserva:");
        apellidosField = new JTextField(20);

        JLabel dniLabel = new JLabel("Estado:");
        dniField = new JTextField(20);

        JLabel correoLabel = new JLabel("Cedula del cliente:");
        correoField = new JTextField(20);

        JLabel telefonoLabel = new JLabel("Codigo del Viaje:");
        telefonoField = new JTextField(20);

        registrarButton = new JButton("Registrar");
        // registrarButton.addActionListener(e -> registroCliente());

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
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registrarButton, gbc);
    }

    /*
     * private void registroCliente() {
     * ClienteController ctrlCliente = new ClienteController(this);
     * String res = ctrlCliente.registrarCliente();
     * if (res == "OK") {
     * JOptionPane.showMessageDialog(this, "Datos guardados satisfactoriamente.");
     * System.out.println(DataModel.getInstance().getClientes().toString());
     * } else {
     * JOptionPane.showMessageDialog(this, res);
     * }
     * }
     */

    public JTextField getNombreField() {
        return this.nombreField;
    }

    public JTextField getApellidosField() {
        return this.apellidosField;
    }

    public JTextField getCedulaField() {
        return this.dniField;
    }

    public JTextField getCorreoField() {
        return this.correoField;
    }

    public JTextField getTelefonoField() {
        return this.telefonoField;
    }

    public JTextField getDireccionField() {
        return this.direccionField;
    }

    public JComboBox<String> getSexoBox() {
        return this.sexoBox;
    }

    public JButton getRegistrarButton() {
        return this.registrarButton;
    }

}
