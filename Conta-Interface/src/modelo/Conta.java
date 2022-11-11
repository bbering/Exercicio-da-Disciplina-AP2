package modelo;

public interface Conta {
    public double getSaldo();

    public boolean deposita(double valor);

    public boolean saca(double valor);

    public void atualiza(double taxaSelic);

}
