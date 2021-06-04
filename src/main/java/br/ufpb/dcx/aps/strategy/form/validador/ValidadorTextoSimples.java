package br.ufpb.dcx.aps.strategy.form.validador;

import br.ufpb.dcx.aps.strategy.form.Resultado;
import br.ufpb.dcx.aps.strategy.form.ValidadorCampo;

public class ValidadorTextoSimples implements ValidadorCampo {
    private int max;
    private int min;

    public ValidadorTextoSimples(int min, int max){
        this.min = min;
        this.max = max;
        if (min < 0 || max < 0){
            throw new IllegalArgumentException("invalido min="+min + ", max="+max);
        }
    }
    public ValidadorTextoSimples(){
        this.max = Integer.MAX_VALUE;
        this.min = Integer.MIN_VALUE;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public Resultado validarCampo(String valor){
        if(valor == null){
            return new Resultado(true, "valor: "+valor);
        }

        int a = valor.length();
        Resultado b = new Resultado();
        if(a > max){
            return new Resultado (true,"ERRO: tamanho do valor > "+getMax()+": '" +valor +"'");
        }
        if(a < min){
            return new Resultado (true,"ERRO: tamanho do valor < "+getMin()+": '" +valor +"'");
        }
        return b;
    }
}
