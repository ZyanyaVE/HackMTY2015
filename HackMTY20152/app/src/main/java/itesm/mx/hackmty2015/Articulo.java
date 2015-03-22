package itesm.mx.hackmty2015;

import android.os.Parcelable;

/**
 * Created by ZyanyaVE on 3/21/15.
 */
public class Articulo{
    private int id;
    private String nombre;
    private int cantidad;

    public Articulo(int id, String nombre, int cantidad) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
