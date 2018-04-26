package banco;

public class Banco{

    public boolean saque(Conta conta, double valor) {
        double saldo = conta.getSaldo();
        if (saldo < valor) {
            System.out.println("Saldo insuficiente para o saque de "+valor+".");
            return false;
        }
        double novoSaldo = saldo - valor;
        System.out.println(Thread.currentThread().getName()
                + " sacou R$" + valor + ". Saldo após saque: R$" + novoSaldo);
        conta.setSaldo(novoSaldo);
        return true;
    }

    public boolean deposito(Conta conta, double valor) {
        double saldo = conta.getSaldo();

        saldo = saldo + valor;
        System.out.println(Thread.currentThread().getName() + " -  Depositou R$" + valor + ". Saldo após deposito: R$" + saldo);
        conta.setSaldo(saldo);
        return true;
    }
    
}
