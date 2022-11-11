package modelo;

public class ContaPoupanca implements Conta{
    private double rendimento;
    private int numero;
    private double saldo;
    
    public ContaPoupanca (int n, double s, double rendimento){
        setSaldo(s);
        this.numero = numero;
        this.rendimento=rendimento;
    }
    
    public double calcularRendimento(){
        return getSaldo()*getRendimento();
    }
    
    public boolean deposita(double valor){
        double saldo = getSaldo();
         if(valor > 0){
            setSaldo(saldo + valor);
            return true;
         }
         return false;
    }

    public boolean saca(double valor){
        double saldo = getSaldo();
        if(saldo >= valor && valor > 0){
            setSaldo(saldo - (valor * 0.1));
            return true;
        }
        return false;
    }

    public void atualiza(double taxaselic){
       setSaldo(getSaldo() - getSaldo()*taxaselic);
    }

    public String getTipo(){
        return "Conta Poupança"; 
    }

    public double getRendimento() {
        return rendimento;
    }    

    @Override
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
