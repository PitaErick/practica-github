package view;

import javax.swing.*;
import java.awt.*;

public class ViajeView extends JPanel {
    private JTextField idField, destinoField, fechaSalidaField, fechaRegresoField, precioField, plazasDisponiblesField;
    private JButton registrarButton, editarButton, reporteButton;

    public ViajeView() {
        setLayout(new GridLayout(7, 2));

        add(new JLabel("ID:"));
        idField = new JTextField(10);
        add(idField);

        add(new JLabel("Destino:"));
        destinoField = new JTextField(50);
        add(destinoField);

        add(new JLabel("Fecha de Salida:"));
        fechaSalidaField = new JTextField(20);
        add(fechaSalidaField);

        add(new JLabel("Fecha de Regreso:"));
        fechaRegresoField = new JTextField(20);
        add(fechaRegresoField);

        add(new JLabel("Precio:"));
        precioField = new JTextField(10);
        add(precioField);

        add(new JLabel("Plazas Disponibles:"));
        plazasDisponiblesField = new JTextField(10);
        add(plazasDisponiblesField);

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

    public JTextField getDestinoField() {
        return this.destinoField;
    }

    public void setDestinoField(JTextField destinoField) {
        this.destinoField = destinoField;
    }

    public JTextField getFechaSalidaField() {
        return this.fechaSalidaField;
    }

    public void setFechaSalidaField(JTextField fechaSalidaField) {
        this.fechaSalidaField = fechaSalidaField;
    }

    public JTextField getFechaRegresoField() {
        return this.fechaRegresoField;
    }

    public void setFechaRegresoField(JTextField fechaRegresoField) {
        this.fechaRegresoField = fechaRegresoField;
    }

    public JTextField getPrecioField() {
        return this.precioField;
    }

    public void setPrecioField(JTextField precioField) {
        this.precioField = precioField;
    }

    public JTextField getPlazasDisponiblesField() {
        return this.plazasDisponiblesField;
    }

    public void setPlazasDisponiblesField(JTextField plazasDisponiblesField) {
        this.plazasDisponiblesField = plazasDisponiblesField;
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
