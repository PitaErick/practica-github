package model;

import java.util.ArrayList;
import java.util.List;

public class DataModel {
    private static DataModel instance;
    private List<Cliente> clientes;
    private List<Reserva> reservas;
    private List<Viaje> viajes;

    private DataModel() {
        clientes = new ArrayList<>();
        reservas = new ArrayList<>();
        viajes = new ArrayList<>();
    }

    public static synchronized DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }
}
