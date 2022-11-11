package modelo;

public abstract class Conta implements Tributavel {
    private int numero;
    private double saldo;

    public Conta(int n, double s) {
        this.numero = n;
        this.saldo = s;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double valor) {
        saldo = valor;
    }

    public abstract String getTipo();

    public double getValorImposto() {
        return this.getSaldo() * 0.01;
    }

    public int getNumero() {
        return numero;
    }
}
