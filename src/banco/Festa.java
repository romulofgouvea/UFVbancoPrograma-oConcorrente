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
public class Festa {

    static Conta conta = new Conta(0);
    static Banco banco = new Banco();
    static int numeroDeProcessos = 120, dep = 60, saq = 60, valor = 0;
    static int countD100 = 20, countD200 = 20, countD300 = 20, countS100 = 20, countS200 = 20, countS300 = 20;

    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Criando Cliente");
        criarCliente();
        Thread.sleep(2000);
    }

    public static void criarCliente() {
        Semaphore semaphore = new Semaphore(1, true);

        for (int i = 0; i < numeroDeProcessos; i++) {
            int random = (int) (Math.random() * 2);

            if (random == 0 && dep > 0) {
                dep--;
                valor = 0;
                while (valor == 0) {
                    valorRandom(random);
                }
            } else if (random == 1 && saq > 0) {

                saq--;
                valor = 0;
                while (valor == 0) {
                    valorRandom(random);
                }

            } else {
                i--;//caso nao crie cliente, corrige o for para ser exatamente 120
            }

            System.out.print(i + " RANDOM: " + random);
            System.out.println(" valor: " + valor);
//            System.out.print("DEP: " + dep);
//            System.out.println(" SAQUE: " + saq);
            //System.out.println(Thread.currentThread().getName() + " Saldo R$" + conta.getSaldo());
        }
    }

    public static void valorRandom(int op) {
        int random = (int) (Math.random() * 3);

        switch (random) {
            case 0:
                valor = 100;
                if (op == 0 && countD100 > 0) {
                    countD100--;
                } else if (op == 1 && countS100 > 0) {
                    countS100--;
                } else {
                    valor = 0;
                }
                break;
            case 1:
                valor = 200;
                if (op == 0 && countD200 > 0) {
                    countD200--;
                } else if (op == 1 && countS200 > 0) {
                    countS200--;
                } else {
                    valor = 0;
                }
                break;
            case 2:
                valor = 300;
                if (op == 0 && countD300 > 0) {
                    countD300--;
                } else if (op == 1 && countS300 > 0) {
                    countS300--;
                } else {
                    valor = 0;
                }
                break;
        }
    }

}
