package com.example.app_stock.beans;


public class Producto {
    private Long CODPRODUCTO;
    private String NOMBRE;
    private Double PRECIO;
    private Integer STOCK;
    private String FOTO;


    public Producto() {
    }

    public Producto(String NOMBRE, Double PRECIO, Integer STOCK, String FOTO) {
        this.NOMBRE = NOMBRE;
        this.PRECIO = PRECIO;
        this.STOCK = STOCK;
        this.FOTO = FOTO;
    }

    public Long getCODPRODUCTO() {
        return CODPRODUCTO;
    }

    public void setCODPRODUCTO(Long CODPRODUCTO) {
        this.CODPRODUCTO = CODPRODUCTO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public Double getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(Double PRECIO) {
        this.PRECIO = PRECIO;
    }

    public Integer getSTOCK() {
        return STOCK;
    }

    public void setSTOCK(Integer STOCK) {
        this.STOCK = STOCK;
    }

    public String getFOTO() {
        return FOTO;
    }

    public void setFOTO(String FOTO) {
        this.FOTO = FOTO;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "CODPRODUCTO=" + CODPRODUCTO +
                ", NOMBRE='" + NOMBRE + '\'' +
                ", PRECIO=" + PRECIO +
                ", STOCK=" + STOCK +
                ", FOTO='" + FOTO + '\'' +
                '}';
    }
}
