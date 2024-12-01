package controller;

import view.MainView;

public class MainController {
    /// private MainView mainView;

    public MainController(MainView mainView) {
        // this.mainView = mainView;
        mainView.showView("MAIN_VIEW");
        // Manejar eventos del menú
        mainView.getRegistrarClienteMenuItem().addActionListener(e -> mainView.showView("REGISTRO_CLIENTE"));
        mainView.getEditarClienteMenuItem().addActionListener(e -> {
            if (ClienteController.checkData())
                mainView.showView("EDITAR_CLIENTE");
        });
        mainView.getReporteClienteMenuItem().addActionListener(e -> {
            ClienteController.generarReporteClientes();
            mainView.showView("REPORTE_CLIENTE");
        });

        //
        mainView.getRegistrarViajeMenuItem().addActionListener(e -> mainView.showView("REGISTRO_VIAJE"));
        mainView.getReporteViajeMenuItem().addActionListener(e -> {
            ViajeController.generarReporteViajes();
            mainView.showView("REPORTE_VIAJE");
        });
        // Reservas
        // mainView.getRegistrarReservaMenuItem().addActionListener(e ->
        // mainView.showView("REGISTRO_RESERVA"));

        /*
         * mainView.getRegistrarReservaMenuItem().addActionListener(e ->
         * mainView.showView("REGISTRO_RESERVA"));
         * mainView.getEditarReservaMenuItem().addActionListener(e ->
         * mainView.showView("EDITAR_RESERVA"));
         * mainView.getReporteReservaMenuItem().addActionListener(e ->
         * mainView.showView("REPORTE_RESERVA"));
         * 
         * mainView.getRegistrarViajeMenuItem().addActionListener(e ->
         * mainView.showView("REGISTRO_VIAJE"));
         * mainView.getEditarViajeMenuItem().addActionListener(e ->
         * mainView.showView("EDITAR_VIAJE"));
         * mainView.getReporteViajeMenuItem().addActionListener(e ->
         * mainView.showView("REPORTE_VIAJE"));
         */

        // Inicializar controladores específicos de cada módulo
    }
}
