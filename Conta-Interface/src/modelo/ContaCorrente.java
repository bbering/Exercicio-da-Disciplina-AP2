package modelo;

public class ContaCorrente implements Conta {
    private double limite;
    private int numero;
    private double saldo;

    public ContaCorrente(int n, double s, double limite) {
        this.numero = n;
        setSaldo(s);
        this.limite = limite;
    }

    public boolean saca(double valor) {
        double saldo = getSaldo();
        if (saldo >= valor && valor > 0) {
            setSaldo(saldo - (valor * 0.1));
            return true;
        }
        return false;
    }

    public boolean deposita(double valor) {
        double saldo = getSaldo();
        if (valor > 0) {
            setSaldo(saldo + valor);
            return true;
        }
        return false;
    }

    public String getTipo() {
        return "Conta Corrente";
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void atualiza(double taxaselic){
        setSaldo(getSaldo() - getSaldo()*taxaselic);
     }
}
