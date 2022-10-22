/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LojaDeInformatica.model;

/**
 *
 * @author Fujimura
 */
public class Computador {

    public static void main(String[] args) {

    }

    //Construtor vazio
    public Computador() {

    }

    //atributos
    private int id;
    private static String marca = "LeonardoFujimura";
    private String hd;
    private String processador;

    //construtor
    public Computador(int id, String hd, String processador) {
        this.id = id;
        this.hd = hd;
        this.processador = processador;
    }

    //métodos acessores
    //ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //marca
    public static String getMarca() {
        return marca;
    }

    public static void setMarca(String marca) {
        Computador.marca = marca;
    }

    //HD
    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    //Processador
    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }
}
