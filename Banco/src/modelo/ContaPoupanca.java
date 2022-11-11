package modelo;
public class ContaPoupanca extends Conta{
    private double rendimento;
    
    public ContaPoupanca (int n, double s, double rendimento){
        super(n, s);
        this.rendimento=rendimento;
    }
    
    public double calcularRendimento(){
        return getSaldo()*getRendimento();
    }
    
    @Override
    public String getTipo(){
        return "Conta Poupança"; 
    }

    public double getRendimento() {
        return rendimento;
    }    
}
