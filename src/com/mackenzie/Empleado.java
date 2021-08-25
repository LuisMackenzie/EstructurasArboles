package com.mackenzie;

import java.util.Objects;

public class Empleado implements Comparable<Empleado>{

    private int id;
    private String name;
    private String puesto;
    private String despacho;

    public Empleado(int id, String name, String puesto, String despacho) {
        this.id = id;
        this.name = name;
        this.puesto = puesto;
        this.despacho = despacho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", puesto='" + puesto + '\'' +
                ", despacho='" + despacho + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return id == empleado.id && Objects.equals(name, empleado.name) && Objects.equals(puesto, empleado.puesto) && Objects.equals(despacho, empleado.despacho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, puesto, despacho);
    }

    @Override
    public int compareTo(Empleado o) {
        if (id == o.id) {
            return 0;
        } else if (id < o.id) {
            return -1;
        } else {
            return 1;
        }
    }
}
