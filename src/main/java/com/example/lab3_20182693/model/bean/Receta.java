package com.example.lab3_20182693.model.bean;

public class Receta {

    private int recetaId;

    private String nombre;

    private String instrucciones;
    private String dificultad;
    private String tiempo_preparacion;

    private Categoria categoria;
    private Ingrediente ingrediente;
    private Nutricion nutricion;

    public Nutricion getNutricion() {
        return nutricion;
    }

    public void setNutricion(Nutricion nutricion) {
        this.nutricion = nutricion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(int recetaId) {
        this.recetaId = recetaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getTiempo_preparacion() {
        return tiempo_preparacion;
    }

    public void setTiempo_preparacion(String tiempo_preparacion) {
        this.tiempo_preparacion = tiempo_preparacion;
    }
}
