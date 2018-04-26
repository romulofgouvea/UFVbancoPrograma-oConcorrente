/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import alunosfesta.Conta;

/**
 *
 * @author ROMULO-NOTEBOOK
 */
public class Banco{

    public boolean saque(Conta conta, double valor) {
        double saldo = conta.getSaldo();
        if (saldo < valor) {
            System.out.println("Saldo insuficiente para o saque de "+valor+".");
            return false;
        }
        double novoSaldo = saldo - valor;
//        System.out.println(Thread.currentThread().getName()
//                + " sacou R$" + valor );
//                + "\nSaldo da conta após saque: R$" + novoSaldo +"\n");
        //System.err.println("(saque v: "+valor+") Saldo : R$" + conta.getSaldo());

        conta.setSaldo(novoSaldo);
        return true;
    }

    public boolean deposito(Conta conta, double valor) {
        double saldo = conta.getSaldo();

        saldo = saldo + valor;
//        System.out.println(Thread.currentThread().getName() + 
//                " -  Depositou R$" + valor);
//              + "\nSaldo da conta após deposito: R$" + saldo +"\n");
        //System.err.println("(Deposito v: "+ valor+") Saldo: R$" + conta.getSaldo());
        conta.setSaldo(saldo);
        return true;
    }
    
}

