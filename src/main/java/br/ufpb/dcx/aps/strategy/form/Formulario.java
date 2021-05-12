package br.ufpb.dcx.aps.strategy.form;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Formulario  {
    private String titulo;
    private Map<String, Campo> intensForm = new LinkedHashMap<>();

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

        return intensForm.get(id);
    }
    public void intemFormulario(ItemFormulario item) {
        if (intensForm.containsKey(item.getId())){
            throw new RuntimeException("Já existe um item com este id:'"+item.getId()+"'");
        }
        intensForm.put(item.getId(),item);
    }

    public Collection<Campo> getIntensForm() {

        return intensForm.values();
    }

    public Resultado validar(){
        Resultado r = new Resultado();
        for (Campo c: intensForm.values()){
            if (c.validar().isErro()){
                r.setErro(true);
                for (String msg: c.validar().getMensagens()){
                    r.addMensagem("Campo " + c.getId() + ": " +msg);
                }
            }
        }
        return r;
    }

}
