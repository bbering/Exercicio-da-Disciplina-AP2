package modelo;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(int n, double s, double limite) {
        super(n, s);
        this.limite = limite;
    }

    public boolean sacar(double valor) {
        if (getSaldo() >= valor && valor > 0) {
            setSaldo(getSaldo() - (valor + 0.10));
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
        }
    }

    @Override
    public String getTipo() {
        return "Conta Corrente";
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
