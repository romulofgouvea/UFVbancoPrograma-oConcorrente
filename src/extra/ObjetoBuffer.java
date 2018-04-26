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
// Classe ObjetoBuffer.java
public class ObjetoBuffer {

    private int memoria;

    // metodo de escrita de dados na memoria
    public void escreveBuffer(int valor) {
        System.err.println(Thread.currentThread().getName()
                + " prodizindo o valor: " + valor);

        this.memoria = valor;
    }

    // metodo de leitura de dados na memoria
    public int lerBuffer() {
        System.err.println(Thread.currentThread().getName()
                + " consumindo o valor: " + this.memoria);

        return this.memoria;
    }

} 

// fim da classe ObjetoBuffer
