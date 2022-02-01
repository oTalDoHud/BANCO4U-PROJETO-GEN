package services;

import entities.Usuario;

public class Pagamentos {

	public static void testeSaldo(double valor, Usuario newUser) {
		if (valor > newUser.getSaldo()) {
			//System.out.println("\nSaldo insuficiente! (Finalizando sess�o...)\n");
			String erro = "Voc� tentou transferir/pagar um valor acima do seu saldo";
			throw new IllegalStateException(erro);
		} else {
			newUser.setSaldo(newUser.getSaldo() - valor);
			System.out.println("\nTransfer�ncia realizada com sucesso!!!");
		}
	}
}