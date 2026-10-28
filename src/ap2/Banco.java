package ap2;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public Conta buscarPorNumero(int numero) {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumero() == numero) {
                return contas.get(i);
            }
        }
        return null;
    }

    public void listarContas() {
        for (Conta conta : contas) {
            conta.exibir();
        }
    }

    public double saldoTotal() {
        double total = 0.0;

        for (int i = 0; i < contas.size(); i++) {
            total += contas.get(i).getSaldo();
        }
        return total;
    }
}
