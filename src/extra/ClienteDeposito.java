/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import alunosfesta.Conta;
import alunosfesta.ObjetoBuffer;
import java.util.concurrent.Semaphore;

/**
 *
 * @author ROMULO-NOTEBOOK
 */
public class ClienteDeposito extends Thread {

    //private final Banco banco = new Banco();
    private double valor = 0;
    private Conta conta = null;
    private ObjetoBuffer o_Buffer;
    private Semaphore s1, s2;

    public ClienteDeposito(ObjetoBuffer dado) {
        super("ClienteDeposito");
        this.o_Buffer = dado;
    }

    public ClienteDeposito(ObjetoBuffer dado, Semaphore sem1, Semaphore sem2, Conta conta, double valor) {
        super("ClienteDeposito");
        this.o_Buffer = dado;
        this.s1 = sem1;
        this.s2 = sem2;
        this.conta = conta;
        this.valor = valor;
    }

    @Override
    public void run() {
        //System.out.println("run() - ClienteDeposito");

//        for (int i = 1; i <= 3; i++) {
            // dorme por um tempo aleatorio
            try {
                Thread.sleep(1000);
            } // tratamento de excecao
            catch (InterruptedException exception) {
                System.err.println(exception.toString());
            }

            // chama metodo do objeto buffer 
            //s1.waitP();
            conta.deposito(conta, valor);
            //s1.notifyV();
            //s2.notify();
            s2.release();
            
           
            

            System.err.println("(Deposito v: "+ valor+")Saldo: R$" + conta.getSaldo());
//        }
    }

}
