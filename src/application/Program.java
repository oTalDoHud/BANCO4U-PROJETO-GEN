package application;

import java.util.Scanner;

import entities.Usuario;
import services.LoginConfirmacao;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---BEM VINDO AO BANCO4U---");
		int op, limiteTentativas = 0, menuOp;
		String confirmacaoSenha;
		Usuario newUser = new Usuario(null, null);
		
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
		        			
		        			do {
		        				System.out.println("\n---LOGIN EFETUADO--- ");
			        			System.out.println("\n---MENU BANCO4U--- ");
			        	        System.out.println("(1) - DEPOSITO/SAQUE/EXTRATO ");
			        	        System.out.println("(2) - EMPRESTIMO");
			        	        System.out.println("(3) - IMPOSTO DE RENDA FÁCIL");
			        	        System.out.println("(0) - Sair");
			        	        System.out.println("----------------");
			        	        System.out.print("Digite aqui -->: ");
			        	        
			        	        menuOp = sc.nextInt();
			        	        switch(menuOp){
			        	        case 1:
			        	        	break;
			        	        case 2:
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
