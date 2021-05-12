package br.ufpb.dcx.aps.strategy.form.validadores;

import br.ufpb.dcx.aps.strategy.form.Resultado;

public class ValidadorTextoSimples {
    private int max;
    private int min;

    public ValidadorTextoSimples(int max, int min){
        this.max = max;
        this.min = min;
    }
    public ValidadorTextoSimples(){
        this.max = -1;
        this.min = -1;
    }

    public Resultado validarCampo(String valor){
        if(valor == null){
            return new Resultado(true,"Valor nulo")
        }
        if (min == -1 && max == -1){
            return new Resultado();
        }
        int t = valor.length();
        Resultado r = new Resultado();
        if (t > max){
            r.setErro(true);
            r.addMensagem("Valor é maior que"+max);
        }
        if(t < min){
            r.setErro(true);
            r.addMensagem("Valor é menor que"+min);
        }
        return r;

    }
}
