package banco;

/**
 *
 * @author ROMULO-NOTEBOOK
 */
public class Conta {

    public double saldo = 0;

    public Conta(double saldo) {
        this.saldo = saldo;
        System.out.println("Conta criada. Saldo inicial: R$" + saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
