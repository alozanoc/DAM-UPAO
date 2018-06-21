package com.proyectos.khanakat.tienda.Administrador;

public class AdmincpProduct {

    private String Name;
    private String Price;
    private int Photo;

    public AdmincpProduct() {
    }

    public AdmincpProduct(String name, String price, int photo) {
        Name = name;
        Price = price;
        Photo = photo;
    }

    //getter
    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public int getPhoto() {
        return Photo;
    }

    //setter
    public void setName(String name) {
        Name = name;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
