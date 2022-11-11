package visao;

import controle.*;
import modelo.*;
import javax.swing.JOptionPane;

public class TestaTributavel {

    public static String menu() {
        return "Menu de opcoes: " + "\n" +
                "1 - Adicionar tributavel" + "\n" +
                "2 - Rendimento da selic" + "\n" +
                "3 - Saque" + "\n" +
                "4 - Deposito" + "\n" +
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
                            + "1 - Conta Poupanca" + "\n" + "2 - Conta Corrente"));
                    if (tipoConta == 1) {
                        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero da conta: "));
                        double s = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o saldo da conta: "));
                        double rendimento = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o rendimento da conta? "));
                        ContaPoupanca cP = new ContaPoupanca(n, s, rendimento);
                        ct.addPoupanca(cP);
                        JOptionPane.showMessageDialog(null, "A conta poupanca não gera imposto a ser pago!");
                        break;
                    }
                    if (tipoConta == 2) {
                        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero da conta: "));
                        double s = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o saldo da conta: "));
                        double limite = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o limite da conta? "));
                        ContaCorrente cC = new ContaCorrente(n, s, limite);
                        ct.addCorrente(cC);
                        break;
                    }
                }
                case 2: {
                    int tipoConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Tipos de tributaveis:" + "\n"
                            + "1 - Conta Poupanca" + "\n" + "2 - Conta Corrente"));
                    if (tipoConta == 1) {
                        double selic = Double.parseDouble(JOptionPane.showInputDialog("Informe a taxa selic:"));
                        ct.selicPoupanca(selic);
                        break;
                    }
                    if (tipoConta == 2) {
                        double selic = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe a taxa selic:"));
                        ct.selicCorrente(selic);
                        break;
                    }
                }
                case 3: {
                    int tipo = Integer.parseInt(JOptionPane.showInputDialog(
                            "Qual o tipo da conta?" + "\n" + "1 - Conta Poupanca" + "\n" + "2 - Conta Corrente"));
                    if (tipo == 1) {
                        double valor = Double
                                .parseDouble(JOptionPane.showInputDialog(null, "Digite o valor a ser sacado: "));
                        if (ct.sacaPoupanca(valor) == true) {
                            JOptionPane.showMessageDialog(null, "Saque realizado!");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o saque!");
                        }
                    }
                    if (tipo == 2) {
                        double valor = Double
                                .parseDouble(JOptionPane.showInputDialog(null, "Digite o valor a ser sacado: "));
                        if (ct.sacaCorrente(valor) == true) {
                            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o saque!");
                        }
                    }
                    break;
                }
                case 4: {
                    int tipo = Integer.parseInt(JOptionPane.showInputDialog(
                            "Qual o tipo da conta?" + "\n" + "1 - Conta Poupanca" + "\n" + "2 - Conta Corrente"));
                    if (tipo == 1) {
                        double valor = Double
                                .parseDouble(JOptionPane.showInputDialog("Digite o valor a Ser Depositado:"));
                        ct.depositaPoupanca(valor);
                    }
                    if (tipo == 2) {
                        double valor = Double
                                .parseDouble(JOptionPane.showInputDialog("Digite o valor a Ser Depositado:"));
                        ct.depositaCorrente(valor);
                    }
                }
            }
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        }
    }

}
