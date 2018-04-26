package extra;

import alunosfesta.Conta;
import alunosfesta.ObjetoBuffer;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ROMULO-NOTEBOOK
 */
public class ClienteSaque extends Thread {

    //private final Banco banco = new Banco();
    private double valor = 0;
    private Conta conta = null;
    private ObjetoBuffer o_Buffer;
    private Semaphore s1, s2;

    public ClienteSaque(ObjetoBuffer dado) {
        super("ClienteSaque");
        this.o_Buffer = dado;
    }

    public ClienteSaque(ObjetoBuffer dado, Semaphore sem1, Semaphore sem2, Conta conta, double valor) {
        super("ClienteSaque");
        this.o_Buffer = dado;
        this.s1 = sem1;
        this.s2 = sem2;
        this.conta = conta;
        this.valor = valor;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 2; i++) {
            // dorme por um tempo aleatorio
            try {
                Thread.sleep(1000);
            } // tratamento de excecao
            catch (InterruptedException exception) {
                System.err.println(exception.toString());
            }

            try {
                // chama metodo do objeto buffer
//            s2.waitP();//wait clienteSaque
                s2.acquire();
                
                if (!conta.saque(conta, valor)) {
                    //s2.wait(1);
                }
                s1.release();
                //s1.notifyV();//notify clienteSaque
            } catch (InterruptedException ex) {
                Logger.getLogger(ClienteSaque.class.getName()).log(Level.SEVERE, null, ex);
            }
            //s1.fila();
            System.out.println("FILA: " + s2.getQueueLength());
            System.err.println("(saque v: " + valor + ")Saldo : R$" + conta.getSaldo());
        }
    }

}
