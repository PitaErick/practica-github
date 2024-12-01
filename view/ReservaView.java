package view;

import javax.swing.*;
import java.awt.*;

public class ReservaView extends JPanel {
    private JTextField idField, fechaReservaField, estadoField, clienteIdField, viajeIdField;
    private JButton registrarButton, editarButton, reporteButton;

    public ReservaView() {
        setLayout(new GridLayout(6, 2));

        add(new JLabel("ID:"));
        idField = new JTextField(10);
        add(idField);

        add(new JLabel("Fecha de Reserva:"));
        fechaReservaField = new JTextField(20);
        add(fechaReservaField);

        add(new JLabel("Estado:"));
        estadoField = new JTextField(20);
        add(estadoField);

        add(new JLabel("ID del Cliente:"));
        clienteIdField = new JTextField(10);
        add(clienteIdField);

        add(new JLabel("ID del Viaje:"));
        viajeIdField = new JTextField(10);
        add(viajeIdField);

        registrarButton = new JButton("Registrar");
        add(registrarButton);

        editarButton = new JButton("Editar");
        add(editarButton);

        reporteButton = new JButton("Reporte");
        add(reporteButton);
    }

    // Getters para los campos y botones
    // ...

    public JTextField getIdField() {
        return this.idField;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public JTextField getFechaReservaField() {
        return this.fechaReservaField;
    }

    public void setFechaReservaField(JTextField fechaReservaField) {
        this.fechaReservaField = fechaReservaField;
    }

    public JTextField getEstadoField() {
        return this.estadoField;
    }

    public void setEstadoField(JTextField estadoField) {
        this.estadoField = estadoField;
    }

    public JTextField getClienteIdField() {
        return this.clienteIdField;
    }

    public void setClienteIdField(JTextField clienteIdField) {
        this.clienteIdField = clienteIdField;
    }

    public JTextField getViajeIdField() {
        return this.viajeIdField;
    }

    public void setViajeIdField(JTextField viajeIdField) {
        this.viajeIdField = viajeIdField;
    }

    public JButton getRegistrarButton() {
        return this.registrarButton;
    }

    public void setRegistrarButton(JButton registrarButton) {
        this.registrarButton = registrarButton;
    }

    public JButton getEditarButton() {
        return this.editarButton;
    }

    public void setEditarButton(JButton editarButton) {
        this.editarButton = editarButton;
    }

    public JButton getReporteButton() {
        return this.reporteButton;
    }

    public void setReporteButton(JButton reporteButton) {
        this.reporteButton = reporteButton;
    }

}
