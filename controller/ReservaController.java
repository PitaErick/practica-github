package controller;

import view.ReservaView;

public class ReservaController {

    public ReservaController(ReservaView reservaView) {
        // Manejar eventos de los botones
        reservaView.getRegistrarButton().addActionListener(e -> registrarReserva());
        reservaView.getEditarButton().addActionListener(e -> editarReserva());
        reservaView.getReporteButton().addActionListener(e -> generarReporteReservas());
    }

    private void registrarReserva() {
        // Implementar lógica para registrar reserva
    }

    private void editarReserva() {
        // Implementar lógica para editar reserva
    }

    private void generarReporteReservas() {
        // Implementar lógica para generar reporte de reservas
    }
}
