package view;

import javax.swing.*;

import controller.ViajeController;
import model.DataModel;

import java.awt.*;

public class RegistroViaje extends JPanel {
    private JTextField destinoField;
    private JTextField precioField;
    private JTextField nroPlazasField;
    private JSpinner fechaSalidaSpinner;
    private JSpinner fechaRegresoSpinner;
    private JButton registrarButton;

    public RegistroViaje() {
        initComponents();
    }

    private void initComponents() {
        // Crear los componentes de la interfaz
        JLabel tit = new JLabel("Registro de Reserva:");
        JLabel destinoLabel = new JLabel("Destino:");
        destinoField = new JTextField(20);

        JLabel precioLabel = new JLabel("Precio:");
        precioField = new JTextField(20);

        JLabel nroPlazasLabel = new JLabel("PLazas Disponibles:");
        nroPlazasField = new JTextField(20);

        JLabel fechaSalidaLabel = new JLabel("Fecha de salida:");
        fechaSalidaSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor fechaSalidaEditor = new JSpinner.DateEditor(fechaSalidaSpinner, "dd/MM/yyyy");
        fechaSalidaSpinner.setEditor(fechaSalidaEditor);

        JLabel fechaRetornoLabel = new JLabel("Fecha de retorno:");
        fechaRegresoSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor fechaRegresoEditor = new JSpinner.DateEditor(fechaRegresoSpinner, "dd/MM/yyyy");
        fechaRegresoSpinner.setEditor(fechaRegresoEditor);
        add(fechaRegresoSpinner);

        registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(e -> registroViaje());

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
        add(destinoLabel, gbc);
        gbc.gridx++;
        add(destinoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(precioLabel, gbc);
        gbc.gridx++;
        add(precioField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(nroPlazasLabel, gbc);
        gbc.gridx++;
        add(nroPlazasField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(fechaSalidaLabel, gbc);
        gbc.gridx++;
        add(fechaSalidaSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(fechaRetornoLabel, gbc);
        gbc.gridx++;
        add(fechaRegresoSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registrarButton, gbc);
    }

    private void registroViaje() {
        ViajeController ctrlCliente = new ViajeController(this);
        String res = ctrlCliente.registrarViaje();
        if (res == "OK") {
            JOptionPane.showMessageDialog(this, "Datos guardados satisfactoriamente.");
            System.out.println(DataModel.getInstance().getClientes().toString());
        } else {
            JOptionPane.showMessageDialog(this, res);
        }
    }

    public JTextField getDestinoField() {
        return this.destinoField;
    }

    public JTextField getPrecioField() {
        return this.precioField;
    }

    public JTextField getNroPlazasField() {
        return this.nroPlazasField;
    }

    public JSpinner getFechaSalidaSpinner() {
        return this.fechaSalidaSpinner;
    }

    public JSpinner getFechaRegresoSpinner() {
        return this.fechaRegresoSpinner;
    }

    public JButton getRegistrarButton() {
        return this.registrarButton;
    }

}
