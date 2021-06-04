/*package br.ufpb.dcx.aps.strategy.form.validador;

import br.ufpb.dcx.aps.strategy.form.Resultado;
import br.ufpb.dcx.aps.strategy.form.ValidadorCampo;

import java.util.Calendar;

public class ValidadorData implements ValidadorCampo {

    private Calendar dataMinima;
    private Calendar dataMaxima;

    public ValidadorData(){
        this.dataMaxima
    }
    @Override
    public Resultado validarCampo(String valor) {
        if (valor == null){
            return new Resultado(true, "Valor nulo");
        }
        if (min == -1 && max == -1){
            return new Resultado();
        }
        int t = valor.length();
        Resultado r = new Resultado();
        if (t > max){
            r.setErro(true);
            r.addMensagem("Valor é maior que:"+max);
        }
        if(t < min){
            r.setErro(true);
            r.addMensagem("Valor é menor que:"+min);
        }
        return r;
    }
}*/
