package br.ufpb.dcx.aps.strategy.form;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Formulario {
    private String titulo;
    private Map<String, ItemFormulario> itensForm = new LinkedHashMap<>();

    public Formulario(){

        this.titulo = "";
    }
    public Formulario(String titulo){

        this.titulo = titulo;
    }
    public String getTitulo(){

        return titulo;
    }
    public void setTitulo(String titulo){

        this.titulo = titulo;
    }
    public ItemFormulario getItemFormulario(String id) {
        if (itensForm.containsKey(id)) {
            return itensForm.get(id);
        }
        throw new IllegalArgumentException("Não existe campo com esse id");


    }
    public void addItemFormulario(ItemFormulario item) {
        if (itensForm.containsKey(item.getId())){
            throw new RuntimeException("'" + item.getId() + "' já existe");
        }
        itensForm.put(item.getId(),item);
    }

    public Collection<ItemFormulario> getItemFormulario() {

        return itensForm.values();
    }

    public Resultado validar(){
        Resultado r = new Resultado();
        for (ItemFormulario i: itensForm.values()){
            if (i.validar().isErro()){
                r.setErro(true);
                r.addMensagem(i.getId()+ ": "+i.validar().getMsg());
            }
        }
        return r;
    }

}
