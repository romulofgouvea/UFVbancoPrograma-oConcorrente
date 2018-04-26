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
public class ClienteSaque extends Thread {

    private final Semaphore semaforo;
    private static final Banco banco = new Banco();
    private Conta conta = null;
    private double valorSaque = 0;

    public ClienteSaque(Semaphore semaforo, Conta conta, double valorSaque) {
        this.semaforo = semaforo;
        this.valorSaque = valorSaque;
        this.conta = conta;
    }

    @Override
    public void run() {
        
        try {
            boolean x = banco.saque(conta, valorSaque);
            if (!x) {
                semaforo.acquire();//wait
            }

        } catch (InterruptedException e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            semaforo.release();
            System.out.println("Saldo da conta é R$: " + conta.getSaldo() + "");
            System.out.println("FILA SAQUE: " + semaforo.getQueueLength());
        }
    }

}
