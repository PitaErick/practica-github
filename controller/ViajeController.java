package controller;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.table.DefaultTableModel;

import model.DataModel;
import model.Viaje;
import view.RegistroViaje;
import view.ReporteViajes;

public class ViajeController {
    private RegistroViaje registroViaje;

    public ViajeController(RegistroViaje viajeView) {
        this.registroViaje = viajeView;
        // Manejar eventos de los botones
    }

    // public String registrarViaje() {
    // String smgValidate = validateForm();
    // if (smgValidate == "OK") {

    // }
    // return smgValidate;
    // }

    public String registrarViaje() {
        /*
         * private JTextField destinoField;
         * private JTextField precioField;
         * private JTextField nroPlazasField;
         * private JSpinner fechaSalidaSpinner;
         * private JSpinner fechaRegresoSpinner;
         * private JButton registrarButton;
         */
        String destino = registroViaje.getDestinoField().getText().trim();
        float precio;
        int nroPlaza;
        LocalDate fechaSalida = getFecha((Date) registroViaje.getFechaSalidaSpinner().getValue());
        LocalDate fechaRegreso = getFecha((Date) registroViaje.getFechaRegresoSpinner().getValue());

        if (registroViaje.getNroPlazasField().getText().trim().isEmpty() || destino.isEmpty()
                || registroViaje.getNroPlazasField().getText().trim().isEmpty()) {
            return "Todos los campos son obligatorios.";
        }
        if (!destino.matches("[a-zA-Z ]+")) {
            return "El destino solo puede contener letras y espacios.";
        }
        try {
            precio = Float.parseFloat(registroViaje.getPrecioField().getText().trim());
            if (precio < 0) {
                return "Ingrese precio mayor a 0";
            }
        } catch (NumberFormatException e) {
            return "El formato del precio es incorrecto."; // Valor de error
        }
        try {
            nroPlaza = Integer.parseInt(registroViaje.getNroPlazasField().getText().trim());
            if (nroPlaza < 0) {
                return "Ingrese numero de plazas mayor a 0";
            }
        } catch (NumberFormatException e) {
            return "El formato del numero de plazas es incorrecto."; // Valor de error
        }

        if (!fechaRegreso.isAfter(fechaSalida)) {
            return "La fecha de regreso debe ser posterior a la fecha de salida.";
        }

        Viaje viaje = new Viaje(destino, fechaSalida, fechaRegreso, precio, nroPlaza);
        DataModel.getInstance().getViajes().add(viaje);
        clearForm();
        return "OK";

    }

    public LocalDate getFecha(Date spnFecha) {
        return spnFecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private void clearForm() {
        registroViaje.getDestinoField().setText("");
        registroViaje.getNroPlazasField().setText("");
        registroViaje.getPrecioField().setText("");

    }

    public static void generarReporteViajes() {
        DefaultTableModel modeloTabla = ReporteViajes.getModeloTabla();
        System.out.println(modeloTabla.getRowCount());
        modeloTabla.setRowCount(0); // Limpiar la tabla
        for (Viaje viaje : DataModel.getInstance().getViajes()) {
            Object[] fila = {
                    viaje.getCodViaje(),
                    viaje.getDestino(),
                    viaje.getPlazasDisponibles(),
                    viaje.getPrecio(),
                    viaje.getFechaSalida(),
                    viaje.getFechaRegreso(),
            };
            modeloTabla.addRow(fila);
        }
    }

    // private void generarReporteViajes() {
    // // Implementar lógica para generar reporte de viajes
    // }
}
