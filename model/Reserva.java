package model;

import java.util.Date;

public class Reserva {
    private int id;
    private Date fechaReserva;
    private String estado;
    private int clienteId;
    private int viajeId;

    // Constructor, getters y setters
    // ...

    public Reserva(int id, Date fechaReserva, String estado, int clienteId, int viajeId) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.estado = estado;
        this.clienteId = clienteId;
        this.viajeId = viajeId;
    }

    public int getId() {
        return this.id;
    }

    public Date getFechaReserva() {
        return this.fechaReserva;
    }

    public String getEstado() {
        return this.estado;
    }

    public int getClienteId() {
        return this.clienteId;
    }

    public int getViajeId() {
        return this.viajeId;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", fechaReserva='" + getFechaReserva() + "'" +
                ", estado='" + getEstado() + "'" +
                ", clienteId='" + getClienteId() + "'" +
                ", viajeId='" + getViajeId() + "'" +
                "}";
    }

}
