package controle;

import modelo.*;
import java.util.ArrayList;

public class ControleTributavel {
    ArrayList<Tributavel> tributavel = new ArrayList<Tributavel>();

    public void cadastraSeguro(Tributavel t) {
       tributavel.add(t);
    }

    public void cadastraCorrente(ContaCorrente c) {
        tributavel.add(c);
    }
    
    public double calculaImposto(){
        double impostoPagar = 0;
        for(int i = 0; i < tributavel.size(); i++){
            impostoPagar += tributavel.get(i).getValorImposto();
        }
        return impostoPagar;
    }
}
