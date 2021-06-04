package br.ufpb.dcx.aps.strategy.form.validador;

import br.ufpb.dcx.aps.strategy.form.Resultado;
import br.ufpb.dcx.aps.strategy.form.ValidadorCampo;

public class ValidadorInteiro implements ValidadorCampo {

    private int min;
    private int max;

    public ValidadorInteiro(int min, int max){
        this.min = min;
        this.max = max;
    }

    public ValidadorInteiro(){
        this.min = Integer.MIN_VALUE;
        this.max = Integer.MAX_VALUE;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public Resultado validarCampo(String valor) {
        if (valor.matches("^[a-z]*")){
            return new Resultado(true, "valor não é um inteiro:'" + valor + "'");
        }
        int t = Integer.parseInt(valor);
        Resultado r = new Resultado();

        if (t > max){
            return new Resultado (true,"valor maior que "+max+":"+valor);
        }
        if(t < min){
            return new Resultado (true,"valor menor que "+min+":"+valor);
        }
        return r;

    }
}
