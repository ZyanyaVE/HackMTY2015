package itesm.mx.hackmty2015;

import android.os.Parcelable;

/**
 * Created by ZyanyaVE on 3/21/15.
 */
public class Articulo{
    private int id;
    private String nombre;
    private int cantidad;
    private int precio;

    public Articulo(int id, String nombre, int cantidad, int precio) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() { return cantidad; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public int getPrecio() { return precio; }

    public void setPrecio(int precio) { this.precio = precio; }
}
