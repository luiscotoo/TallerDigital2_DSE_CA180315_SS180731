/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.IngenierosDao;
import modelo.entidad.Ingenieros;


/**
 *
 * @author elcon
 */
@ManagedBean
@ViewScoped
public class IngenierosControl {

    /**
     * Creates a new instance of ingenierosControl
     */
    private List<Ingenieros> listaIngenieros;
    private Ingenieros banco;

    public IngenierosControl() {
        banco = new Ingenieros();
    }

    public List<Ingenieros> getListaIngenieros() {
        IngenierosDao ad = new IngenierosDao();
        listaIngenieros = ad.listarIngenieros();
        return listaIngenieros;
    }

    public void setListaIngenieros(List<Ingenieros> listaIngenieros) {
        this.listaIngenieros = listaIngenieros;
    }

    public Ingenieros getIngenieros() {
        return banco;
    }

    public void setIngenieros(Ingenieros banco) {
        this.banco = banco;
    }

    public void limpiarIngenieros() {
        banco = new Ingenieros();
    }

    public void agregarIngenieros() {
        IngenierosDao ad = new IngenierosDao();
        ad.agregar(banco);
    }

    public void modificarIngenieros() {
        IngenierosDao ad = new IngenierosDao();
        ad.modificar(banco);
        limpiarIngenieros();
    }

    public void eliminarIngenieros() {
        IngenierosDao ad = new IngenierosDao();
        ad.eliminar(banco);
        limpiarIngenieros();
    }
}
