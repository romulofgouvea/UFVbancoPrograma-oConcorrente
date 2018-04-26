/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

/**
 *
 * @author ROMULO-NOTEBOOK
 */
public class Semaforo {
    private int counter;
    
    private int valor;	//valor do semaforo
    private int esperando = 0;	//quantidade de processos bloqueados por UM DETERMINADO semaforo
    
    public Semaforo() {
        this(0);
    }
    public Semaforo(int i) {
        if (i < 0) throw new IllegalArgumentException(i + " < 0");
        valor = i;
    }
    
    public synchronized void release() {
        if (esperando > 0){ //se tem processo na fila de espera
            notify(); //tira processo da fila de espera
        } else {
            valor++;	//senao, incrementa o valor do semaforo
        }
    }
    
    public synchronized void acquire(){
        if (valor > 0){ //verifica o valor do semaforo
            valor--; //se semaforo maior que zero, decrementa o valor do do semaforo
        } else {
            esperando++;	//senao, incrementa o numero de threads suspensas
            try {
                wait();
            } catch (InterruptedException e) {
            } //senao o processo que executou a operacao P (ou DOWN) e' suspenso
            esperando--;
        }	//fim do else/if
    }
    
    public int mostraFila(){
       return esperando;
    }
}
