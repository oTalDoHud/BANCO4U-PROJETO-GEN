package application;

import java.util.Scanner;

import entities.Usuario;
import services.Emprestimo;
import services.LoginConfirmacao;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---BEM VINDO AO BANCO4U---");
		int op, limiteTentativas = 0, menuOp, depoOp, empreOp, totalParcelas = 0;
		String confirmacaoSenha;
		Usuario newUser = new Usuario(null, null, 200);
		
		do {
			System.out.println("\n---LOGIN/CADASTRO---");
	        System.out.println("(1) - Login ");
	        System.out.println("(2) - Cadastro");
	        System.out.println("(0) - Sair");
	        System.out.println("----------------");
	        System.out.print("Digite aqui -->: ");
	        op = sc.nextInt();
	       
	        Usuario admin = new Usuario("Admin", "Admin");
	        
	        switch(op){
	        	case 1 ://Login
	        		do {
	        			System.out.println("\n---LOGIN---");
	        			System.out.println("Entre com o seu usuario");
		        		System.out.print("Digite aqui -->: ");
		        		String nickUser = sc.next();
		        		
		        		System.out.println("Entre com a sua senha");
		        		System.out.print("Digite aqui -->: ");
		        		String senhaUser = sc.next();
		        		//if(nickUser.equals(nick) && senhaUser.equals(senha) || nickUser.equals(cadastroUser) && senhaUser.equals(cadastroSenha)){
		        		if(LoginConfirmacao.login(nickUser, senhaUser, admin.getName(), admin.getSenha()) 
		        				|| LoginConfirmacao.login(nickUser, senhaUser, newUser.getName(), newUser.getSenha()) ){
		        			System.out.println("\n---LOGIN EFETUADO--- ");
		        			do {
			        			System.out.println("\n---MENU BANCO4U--- ");
			        	        System.out.println("(1) - DEPOSITO/SAQUE/EXTRATO ");
			        	        System.out.println("(2) - EMPRESTIMO");
			        	        System.out.println("(3) - IMPOSTO DE RENDA FÁCIL");
			        	        System.out.println("(4) - PAGAMENTOS");
			        	        System.out.println("(0) - Sair");
			        	        System.out.println("----------------");
			        	        System.out.print("Digite aqui -->: ");
			        	        
			        	        menuOp = sc.nextInt();
			        	        switch(menuOp){
			        	        case 1://depositar/sacar/extrato
			        	        	
			        	        		System.out.println("\n---SAQUE/DEPOSITO/EXTRATO--- ");
			        	        	do {
			        	        		System.out.println("(1) - Saque");
					        	        System.out.println("(2) - Deposito");
					        	        System.out.println("(3) - Extrato");
					        	        System.out.println("(0) - Sair");
					        	        System.out.println("----------------");
					        	        System.out.print("Digite aqui -->: ");
					        	        depoOp = sc.nextInt();
					        	        
					        	        switch(depoOp){
					        	        case 1://saque
					        	        	System.out.println("\nQuanto deseja sacar? ");
						        	        System.out.println("----------------");
						        	        System.out.print("Digite aqui -->: ");
						        	        double valorSacado = sc.nextDouble();
						        	        newUser.saque(valorSacado);
						        	        System.out.println("\nValor sacado, seu saldo atual é de: " + newUser.getSaldo());
					        	        	break;
					        	        case 2://deposito
					        	        	System.out.println("\nQuanto deseja depositar? ");
						        	        System.out.println("----------------");
						        	        System.out.print("Digite aqui -->: ");
						        	        double valorDepositado = sc.nextDouble();
						        	        newUser.deposito(valorDepositado);
						        	        System.out.println("\nValor depositado, seu saldo atual é de: " + newUser.getSaldo());
					        	        	break;
					        	        case 3:
					        	        	 System.out.println("\nSeu saldo atual é de: " + newUser.getSaldo());
					        	        	break;
					        	        case 0:
					        	        	System.out.println("\nVoltando a menu");
					        	        	break;
					        	        default:
					        	        	System.out.println("Entre um valor válido entre 1, 2, 3 ou 0");
					        	        }
					        	        
			        	        	}while(depoOp != 0);
			        	        	
			        	        	break;
			        	        case 2://EMPRESTIMO
			        	        	System.out.println("\n---EMPRESTIMO--- ");
			        	        	do {
			        	        		System.out.println("Digite um valor para simulação de emprestimo ou 0 para sair");
			        	        		System.out.println("----------------");
					        	        System.out.print("Digite aqui -->: ");
			        	        		empreOp = sc.nextInt();
			        	        		
			        	        		if(empreOp == 0) {
			        	        			break;
			        	        		}
			        	        		
			        	        		if(empreOp != 0) {
			        	        			System.out.println("Digite em quantas parcelas deseja pagar");
				        	        		System.out.println("----------------");
						        	        System.out.print("Digite aqui -->: ");
						        	        totalParcelas = sc.nextInt();
			        	        		}
			        	        		
			        	        		if(empreOp <= 5000 && totalParcelas >= 12 && totalParcelas <= 60) {
			        	        			System.out.println(Emprestimo.parcelas(empreOp, totalParcelas));
			        	        			break;
			        	        		}else {
			        	        			System.out.println("Valor excede R$: 5000,00 ou o número de parcelas não é válido, por favor procure uma agência");
			        	        		}
			        	        		
			        	        		if(empreOp == 0) {
			        	        			System.out.println("Voltando ao menu");
			        	        		}
			        	        	}while(empreOp != 0);
			        	        	
			        	        	break;
			        	        default:
			        	        	
			        	        }
		        			}while(menuOp != 0);
		        			break;
		        		}
		        		else {
		        			System.out.println("\nSenha ou usuário incorretos !!! (tentativa(" + (2 - limiteTentativas) + "))");
		        			limiteTentativas++;
		        		}
		        		
		        		if(limiteTentativas >= 3) {
		        			System.out.println("Limite de tentativas atingido, conta bloqueada");
		        			System.exit(0);
		        		}
	        		}while(limiteTentativas <= 3);
	        		
	        	break;
	        	case 2 ://cadastro
	        		do {
	        			System.out.println("\n---CADASTRO---");
		        		System.out.println("Entre com o seu usuario");
		        		System.out.print("Digite aqui -->: ");
		        		newUser.setName(sc.next());
		        		
		        		System.out.println("Entre com a sua senha");
		        		System.out.print("Digite aqui -->: ");
		        		newUser.setSenha(sc.next());
		        		
		        		System.out.println("Confirme sua senha");
		        		System.out.print("Digite aqui -->: ");
		        		confirmacaoSenha = sc.next();
		        		
		        		if(!confirmacaoSenha.equals(newUser.getSenha())) {
		        			System.out.println("Senhas não coincidem! Realiza o cadastro novamento.");
		        		}
	        		}while(!confirmacaoSenha.equals(newUser.getSenha()));
	        		
	        		System.out.println("Usuário cadastrado com sucesso!");
		        break;
	        	case 0 :
	        		System.out.println("Obrigado por utilizar o BANCO4U");
		        break;
		        default:
		        	System.out.println("\nOpção inválida, por favor digite: 1, 2 ou 0");
	        }
	        
		}
		while(op != 0);

		
		
		sc.close();
	}
}