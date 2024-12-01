package model;

import java.time.LocalDate;

public class Viaje {
    private String id;
    private String destino;
    private LocalDate fechaSalida;
    private LocalDate fechaRegreso;
    private float precio;
    private int plazasDisponibles;

    // Constructor, getters y setters
    // ...

    public Viaje(String destino, LocalDate fechaSalida, LocalDate fechaRegreso, float precio, int nroPlaza) {
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.precio = precio;
        this.plazasDisponibles = nroPlaza;
        this.id = getIDViaje();
    }

    private String getIDViaje() {
        return getDestino().toLowerCase() + fechaSalida;
    }

    public String getCodViaje() {
        return this.id;
    }

    public String getDestino() {
        return this.destino;
    }

    public LocalDate getFechaSalida() {
        return this.fechaSalida;
    }

    public LocalDate getFechaRegreso() {
        return this.fechaRegreso;
    }

    public float getPrecio() {
        return this.precio;
    }

    public int getPlazasDisponibles() {
        return this.plazasDisponibles;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getCodViaje() + "'" +
                ", destino='" + getDestino() + "'" +
                ", fechaSalida='" + getFechaSalida() + "'" +
                ", fechaRegreso='" + getFechaRegreso() + "'" +
                ", precio='" + getPrecio() + "'" +
                ", plazasDisponibles='" + getPlazasDisponibles() + "'" +
                "}";
    }

}
