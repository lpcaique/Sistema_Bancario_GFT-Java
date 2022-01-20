package projeto.banco;

//Importando Sub Classes e funções
import projeto.banco.tipoconta.ContaCorrente;
import projeto.banco.tipoconta.ContaPoupanca;

import java.util.Scanner;

public class Main extends Conta {

    public static void main(String[] args, Conta poupanca, Conta cc) {

        //Tela inicial com escolha para o cliente fazer
        Scanner scan = new Scanner(System.in);
        System.out.println("=-=-=-  BANCO CLP  -=-=-=");
        System.out.println("Selecione o serviço desejado:");
        System.out.println("1. Abrir Conta Corrente");
        System.out.println("2. Abrir Conta Poupança");
        System.out.println("3. Ver Saldo");
        System.out.println("4. Efetuar Saque");
        System.out.println("5. Efetuar Transferência");
        System.out.println("6. Efetuar Depósito");
        int servico = scan.nextInt();

        switch (servico) {

            //Abre uma nova Conta Corrente
            case 1:
                cc = new ContaCorrente();
            break;

            //Abre uma nova Conta Poupança
            case 2:
                poupanca = new ContaPoupanca();
            break;

            //Mostra o saldo atual e outras informações para o cliente
            case 3:
                System.out.println("Deseja ver o saldo de sua conta Poupança ou Corrente?");
                System.out.println("Digite CP para Poupança e CC para Corrente: ");
                String contaDestino = scan.next();
                if (contaDestino == "CC") {
                    System.out.println("-=-=-= Saldo Conta Corrente =-=-=-");
                    cc.imprimirInfos();
                } else if (contaDestino == "CP") {
                    System.out.println("-=-=-= Saldo Conta Poupança =-=-=-");
                    poupanca.imprimirInfos();
                } else System.out.println("Tipo de conta inválida, inicie a operação novamente.");
            break;

            //Realiza o processo de saque
            case 4:
                System.out.println("-=-=-=  SAQUE CLP  =-=-=-");
                System.out.println("Deseja realizar um saque de sua conta Poupança ou Corrente?");
                System.out.println("Digite CP para Poupança e CC para Corrente: ");
                contaDestino = scan.next();
                System.out.println("Digite o valor que você deseja sacar: ");
                int valor = scan.nextInt();
                if (contaDestino == "CP") {
                    if (poupanca.saque(valor)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else System.out.println("Saldo insuficiente, inicie a operacao novamente.");
                } else {
                    if (cc.saque(valor)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else System.out.println("Saldo insuficiente, inicie a operacao novamente.");
                }
            break;

            //Realiza o processo de transferencia entre contas
            case 5:
                System.out.println("-=-=-=  TRANSFERENCIA CLP  =-=-=-");
                System.out.println("Deseja transferir de sua conta Poupança ou Corrente?");
                System.out.println("Digite CP para Poupança e CC para Corrente: ");
                String contaOrigem = scan.next();
                System.out.println("Você irá transferir o dinheiro para uma conta Poupança ou Corrente?");
                System.out.println("Digite CP para Poupança e CC para Corrente: ");
                contaDestino = scan.next();
                System.out.println("Qual valor voce deseja transferir: ");
                valor = scan.nextInt();
                if (contaOrigem == "CP" && contaDestino == "CP") {
                    if (poupanca.transferir(valor, poupanca)) {
                        System.out.println("Transferencia realizada com sucesso");
                    } else System.out.println("Saldo insuficiente, inicie a operacao novamente.");
                } else if (contaOrigem == "CP" && contaDestino == "CC") {
                    if (poupanca.transferir(valor, cc)) {
                        System.out.println("Transferencia realizada com sucesso");
                    } else System.out.println("Saldo insuficiente, inicie a operacao novamente.");
                } else if (contaOrigem == "CC" && contaDestino == "CP") {
                    if (cc.transferir(valor, poupanca)) {
                        System.out.println("Transferencia realizada com sucesso");
                    } else System.out.println("Saldo insuficiente, inicie a operacao novamente.");
                } else {
                    if (cc.transferir(valor, cc)) {
                        System.out.println("Transferencia realizada com sucesso");
                    } else System.out.println("Saldo insuficiente, inicie a operacao novamente.");
                }
            break;

            //Realiza o processo de depósito
            case 6:
                System.out.println("-=-=-=  DEPOSITO CLP  =-=-=-");
                System.out.println("Você deseja DEPOSITAR para uma conta POUPANÇA ou CORRENTE? ");
                System.out.println("Digite CC para CORRENTE e CP para POUPANÇA: ");
                contaDestino = scan.next();
                System.out.println("Digite o valor que deseja depositar: ");
                int valorDeposito = scan.nextInt();
                if (contaDestino=="CC") {
                    if (cc.depositar(valorDeposito)) {
                        System.out.println("Deposito realizado com sucesso!");
                    } else System.out.println("Deposito não realizado, tente novamente.");
                }
                else {
                    if (poupanca.depositar(valorDeposito)) {
                        System.out.println("Deposito realizado com sucesso!");
                    } else System.out.println("Deposito não realizado, tente novamente.");
                }
            break;
            default:
                System.out.println("Número de operação inválido, inicie novamente");
        }
    }
}
