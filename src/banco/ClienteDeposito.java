/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.concurrent.Semaphore;

/**
 *
 * @author ROMULO-NOTEBOOK
 */
public class ClienteDeposito extends Thread {

    private final Semaphore semaforo;
    private static final Banco banco = new Banco();
    private Conta conta = null;
    private double valorDeposito = 0;

    public ClienteDeposito(Semaphore semaforo, Conta conta, double valorDeposito) {
        this.semaforo = semaforo;
        this.valorDeposito = valorDeposito;
        this.conta = conta;
    }

    @Override
    public void run() {
        banco.deposito(conta, valorDeposito);
        System.out.println("Saldo da conta é R$: " + conta.getSaldo() + "");
        semaforo.release();
    }

}
