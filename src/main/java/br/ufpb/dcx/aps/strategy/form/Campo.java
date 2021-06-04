package br.ufpb.dcx.aps.strategy.form;
import br.ufpb.dcx.aps.strategy.form.validador.ValidadorTextoSimples;

public class Campo implements ItemFormulario {
    private String nome;
    private String id;
    private String valor;
    private  boolean obrigatorio;
    private ValidadorCampo validador;
    private boolean preenchido;


    public Campo(String id){
        this.id = id;
        this.nome = "";
        this.valor = "";
        this.obrigatorio = false;
        this.preenchido = false;
        this.validador = new ValidadorTextoSimples();
    }
    public Campo(ValidadorCampo validador, boolean obrigatorio){
        this.validador = validador;
        this.obrigatorio = obrigatorio;
    }

    public Campo(String id, String nome){
        this(id);
        this.nome = nome;
        this.valor = "";
        this.obrigatorio = false;
        this.validador = new ValidadorTextoSimples();
        this.preenchido = false;
    }
    public Campo(String id, boolean obrigatorio, String nome){
        this(id);
        this.obrigatorio = obrigatorio;
        this.nome = nome;
        this.valor = "";
        this.validador = new ValidadorTextoSimples();
        this.preenchido = false;

    }

    public Campo(String id, boolean obrigatorio) {
        this.id = id;
        this.obrigatorio = obrigatorio;

    }


    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getId() {

        return id;
    }

    public String getValor() {

        return valor;
    }

    public void setValor(String valor) {

        this.valor = valor;
    }
    public String getLabel(){

        return getNome();
    }

    public boolean isPreenchido(){
        if (getValor() == ""){
            return false;
        }
        return true;
    }

    public  boolean isObrigatorio(){
        if (obrigatorio == false){
            return false;
        }
        return true;
    }

    public Resultado validar(){
        if (this.obrigatorio == true && !this.isPreenchido()){
            return new Resultado(true, this.getId()+" é obrigatório e não foi preenchido");
        }
        if (!this.isPreenchido()){
            return new Resultado();
        }
        return this.validador.validarCampo(this.valor);

    }

    public void setObrigatorio(boolean obrigatorio) {

        this.obrigatorio = obrigatorio;
    }


    public void setValidador(ValidadorCampo validador) {

        this.validador = validador;
    }
}
