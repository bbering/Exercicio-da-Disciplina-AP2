package visao;

import controle.*;
import modelo.*;
import javax.swing.JOptionPane;

//A referencia t chama getValorImposto que tenta acessar getSaldo, o que não é possivel já que a interface é limitada a acessar apenas getValorImposto

public class TestaTributavel {
    public static String menu() {
        return "Menu de opcoes: " + "\n" +
                "1 - Adicionar tributavel" + "\n" +
                "2 - Imposto a ser pago" + "\n" +
                "0 - Sair";
    }

    public static void main(String[] args) {
        int op = 0;
        op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        ControleTributavel ct = new ControleTributavel();
        while (op != 0) {
            switch (op) {
                case 1: {
                    int tipoConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Tipos de tributaveis:" + "\n"
                            + "1 - Conta Poupanca" + "\n" + "2 - Conta Corrente" + "\n" + "3 - Seguro de vida"));
                    if (tipoConta == 1) {
                        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero da conta: "));
                        double s = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o saldo da conta: "));
                        double rendimento = Double
                                .parseDouble(JOptionPane.showInputDialog(null, "Qual o rendimento da conta? "));
                        ContaPoupanca cP = new ContaPoupanca(n, s, rendimento);
                        JOptionPane.showMessageDialog(null, "A conta poupanca não gera imposto a ser pago!");
                        break;
                    }
                    if (tipoConta == 2) {
                        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero da conta: "));
                        double s = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o saldo da conta: "));
                        double limite = Double
                                .parseDouble(JOptionPane.showInputDialog(null, "Qual o limite da conta? "));
                        ContaCorrente c = new ContaCorrente(n, s, limite);
                        ct.cadastraCorrente(c);
                        JOptionPane.showMessageDialog(null,
                                "O imposto a ser pago sera de: " + "\n" + c.getValorImposto());
                        break;
                    }
                    if(tipoConta == 3){
                        double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor do seguro: "));
                        int numeroApolice = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero de apolice da conta: "));
                        SeguroDeVida s = new SeguroDeVida(valor, numeroApolice);
                        ct.cadastraSeguro(s);
                        JOptionPane.showMessageDialog(null, "Imposto a ser pago: " + "\n" + s.getValorImposto());
                    }
                }
                case 2: {
                    JOptionPane.showMessageDialog(null, "Imposto total a ser pago até então: " + ct.calculaImposto());
                    break;
                }
            }
        }
    }
}
