package com.example.lab3_20182693.model.bean;

public class Categoria {

    private int categoriaId;

    private String categoriaNombre;

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = Integer.parseInt(categoriaId);
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }
}
