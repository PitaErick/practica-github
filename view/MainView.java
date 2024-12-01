package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JMenuBar menuBar;
    private JMenu clienteMenu, viajeMenu;// reservaMenu;
    private JMenuItem registrarClienteMenuItem, editarClienteMenuItem, reporteClienteMenuItem;
    private JMenuItem registrarReservaMenuItem, editarReservaMenuItem, reporteReservaMenuItem;
    private JMenuItem registrarViajeMenuItem, editarViajeMenuItem, reporteViajeMenuItem;

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private MainMenuView menuMainView;

    public MainView() {
        setTitle("Sistema de Reserva de Viajes");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el menú
        menuBar = new JMenuBar();

        clienteMenu = new JMenu("Clientes");
        // reservaMenu = new JMenu("Reservas");
        viajeMenu = new JMenu("Viajes");

        registrarClienteMenuItem = new JMenuItem("Registrar Cliente");
        editarClienteMenuItem = new JMenuItem("Editar Cliente");
        reporteClienteMenuItem = new JMenuItem("Reporte de Clientes");

        // registrarReservaMenuItem = new JMenuItem("Registrar Reserva");
        // editarReservaMenuItem = new JMenuItem("Editar Reserva");
        // reporteReservaMenuItem = new JMenuItem("Reporte de Reservas");

        registrarViajeMenuItem = new JMenuItem("Registrar Viaje");
        editarViajeMenuItem = new JMenuItem("Editar Viaje");
        reporteViajeMenuItem = new JMenuItem("Reporte de Viajes");

        clienteMenu.add(registrarClienteMenuItem);
        clienteMenu.add(editarClienteMenuItem);
        clienteMenu.add(reporteClienteMenuItem);

        // reservaMenu.add(registrarReservaMenuItem);
        // reservaMenu.add(editarReservaMenuItem);
        // reservaMenu.add(reporteReservaMenuItem);

        viajeMenu.add(registrarViajeMenuItem);
        viajeMenu.add(editarViajeMenuItem);
        viajeMenu.add(reporteViajeMenuItem);

        menuBar.add(clienteMenu);
        // menuBar.add(reservaMenu);
        menuBar.add(viajeMenu);

        setJMenuBar(menuBar);

        // Crear panel principal con CardLayout
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        menuMainView = new MainMenuView();
        mainPanel.add(menuMainView, "MAIN_VIEW");
        // CLIENTES
        mainPanel.add(new RegistroCliente(), "REGISTRO_CLIENTE");
        mainPanel.add(new EditarCliente(), "EDITAR_CLIENTE");
        mainPanel.add(new ReporteCliente(), "REPORTE_CLIENTE");
        // RESERVAS
        // mainPanel.add(new RegistroReserva(), "REGISTRO_RESERVA");
        // mainPanel.add(new EditarCliente(), "EDITAR_RESERVA");
        // mainPanel.add(new ReporteCliente(), "REPORTE_RESERVA");
        // VIAJES
        mainPanel.add(new RegistroViaje(), "REGISTRO_VIAJE");
        // mainPanel.add(new EditarCliente(), "EDITAR_VIAJE");
        mainPanel.add(new ReporteViajes(), "REPORTE_VIAJE");
        add(mainPanel);
        setVisible(true);
    }

    public JMenuItem getRegistrarClienteMenuItem() {
        return registrarClienteMenuItem;
    }

    public JMenuItem getEditarClienteMenuItem() {
        return editarClienteMenuItem;
    }

    public JMenuItem getReporteClienteMenuItem() {
        return reporteClienteMenuItem;
    }

    public JMenuItem getRegistrarReservaMenuItem() {
        return registrarReservaMenuItem;
    }

    public JMenuItem getEditarReservaMenuItem() {
        return editarReservaMenuItem;
    }

    public JMenuItem getReporteReservaMenuItem() {
        return reporteReservaMenuItem;
    }

    public JMenuItem getRegistrarViajeMenuItem() {
        return registrarViajeMenuItem;
    }

    public JMenuItem getEditarViajeMenuItem() {
        return editarViajeMenuItem;
    }

    public JMenuItem getReporteViajeMenuItem() {
        return reporteViajeMenuItem;
    }

    public void showView(String viewName) {
        cardLayout.show(mainPanel, viewName);
    }
}
