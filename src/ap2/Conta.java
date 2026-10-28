package ap2;

public class Conta {
    private int numero;
    private String titular;
    protected double saldo;

    public Conta(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Depósito inválido: o valor deve ser maior que zero.");
            return;
        }
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void exibir() {
        System.out.printf("Conta %d | Titular: %-8s | Saldo: R$ %.2f%n", numero, titular, saldo);
    }
}
