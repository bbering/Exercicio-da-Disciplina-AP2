package modelo;

public class SeguroDeVida implements Tributavel {
    private double valor;
    private int numeroApolice;

    public SeguroDeVida(double valor, int numeroApolice){
        this.valor = valor;
        this.numeroApolice = numeroApolice;
    }

    public String getTipo(){
        return "Seguro de vida";
    }

    @Override
    public double getValorImposto() {
        return (valor*0.2)+42;
    }

    public int getNumeroApolice() {
        return numeroApolice;
    }

}
