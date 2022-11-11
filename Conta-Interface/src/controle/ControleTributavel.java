package controle;
import modelo.*;
import java.util.ArrayList;

public class ControleTributavel {
    ArrayList <Tributavel> Tributaveis = new ArrayList<>();
    private ContaCorrente cc;
    private ContaPoupanca cp;
    //Metodos

    //Adicionar Tributável:
    public void addTributavel(Tributavel t){
    Tributaveis.add(t);
    }

    //Adicionar Contas
    public void addCorrente(ContaCorrente c){
    this.cc=c;
    }
    public void addPoupanca(ContaPoupanca p){
    this.cp=p;
    }

    // Selic Poupança & Poupança
    public void selicCorrente(double selic){
    cc.atualiza(selic);
    }
    public void selicPoupanca( double selic){
    cp.atualiza(selic);
    }

    //Sacar
    public boolean sacaPoupanca(double valor){

        if(cp.saca(valor)==true){
        return true;
        }
        return false;
        }

    public boolean sacaCorrente(double valor){

        if(cc.saca(valor)==true){
        return true;
        }
        return false;
        }

    //Depositar
    public void depositaPoupanca( double valor){
        cp.deposita(valor);
        }
        public void depositaCorrente( double valor){
        cc.deposita(valor);
        }
}
