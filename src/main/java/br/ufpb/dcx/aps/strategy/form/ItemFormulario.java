package br.ufpb.dcx.aps.strategy.form;

public interface ItemFormulario {
    public String getId();
    public String getLabel();
    public void setValor(String valor);
    public Resultado validar();
    public void setObrigatorio(boolean obrigatorio);
    public boolean isObrigatorio();
    public boolean isPreenchido();
    public String getNome();
}
