package ap2;

public class Main {
    public static void main(String[] args) {
        // 1. Criar o banco
        Banco bancoUlbra = new Banco();

        // 2. Criar uma conta de cada tipo
        Conta conta1 = new Conta(120, "Ana");
        ContaPoupanca poupanca = new ContaPoupanca(121, "Bruno", 0.05);
        ContaCorrente corrente = new ContaCorrente(122, "Carla", 500.0);

        // 3. Adicionar as três ao banco
        bancoUlbra.adicionarConta(conta1);
        bancoUlbra.adicionarConta(poupanca);
        bancoUlbra.adicionarConta(corrente);

        // 4. Depósitos e saques
        System.out.println("=== DEPÓSITOS E SAQUES ===");
        conta1.depositar(3000.0);
        poupanca.depositar(100.0);
        corrente.depositar(150.0);

        boolean saqueOk = conta1.sacar(500.0);
        System.out.println("Saque de R$ 500,00 na conta 120: " + saqueOk);
        conta1.exibir();

        // 5. Saque que falha por saldo insuficiente
        System.out.println();
        System.out.println("=== SAQUE QUE FALHA ===");
        boolean saqueFalhou = poupanca.sacar(1000.0);
        System.out.println("Saque de R$ 1.000,00 na conta 121: " + saqueFalhou);
        poupanca.exibir();

        // 6. Aplicar rendimento na poupança
        System.out.println();
        System.out.println("=== RENDIMENTO DA POUPANÇA ===");
        System.out.printf("Saldo antes do rendimento: R$ %.2f%n", poupanca.getSaldo());
        poupanca.aplicarRendimento();
        System.out.printf("Taxa de rendimento: %.2f%%%n", poupanca.getTaxaRendimento() * 100);
        System.out.printf("Saldo depois do rendimento: R$ %.2f%n", poupanca.getSaldo());

        // 7. Saque usando o limite (cheque especial)
        System.out.println();
        System.out.println("=== SAQUE COM LIMITE ===");
        System.out.printf("Saldo antes: R$ %.2f | Limite: R$ %.2f%n", corrente.getSaldo(), corrente.getLimite());
        boolean saqueComLimite = corrente.sacarComLimite(400.0);
        System.out.println("Saque de R$ 400,00 na conta 122: " + saqueComLimite);
        corrente.exibir();

        boolean acimaDoLimite = corrente.sacarComLimite(1000.0);
        System.out.println("Saque de R$ 1.000,00 (acima do limite) na conta 122: " + acimaDoLimite);

        // 8. Listar todas as contas e mostrar o saldo total
        System.out.println();
        System.out.println("=== CONTAS DO BANCO ===");
        bancoUlbra.listarContas();
        System.out.printf("Saldo total do banco: R$ %.2f%n", bancoUlbra.saldoTotal());

        // Busca por número: uma conta que existe e outra que não existe
        System.out.println();
        System.out.println("=== BUSCA POR NÚMERO ===");
        Conta contaEncontrada = bancoUlbra.buscarPorNumero(121);
        contaEncontrada.exibir();
        System.out.println("Busca pela conta 999: " + bancoUlbra.buscarPorNumero(999));
    }
}
