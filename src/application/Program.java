package application;

import java.util.Scanner;

import services.LoginConfirmacao;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---BEM VINDO AO BANCO4U---");
		int op, limiteTentativas = 0;
		String cadastroUser = "", cadastroSenha = "", confirmacaoSenha;
		
		do {
			System.out.println("\n---LOGIN/CADASTRO---");
	        System.out.println("(1) - Login ");
	        System.out.println("(2) - Cadastro");
	        System.out.println("(0) - Sair");
	        System.out.println("----------------");
	        System.out.print("Digite aqui -->: ");
	        op = sc.nextInt();
	        
	        String nick = "Admin";
	        String senha = "Admin";
	        
	        
	        
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
		        		if(LoginConfirmacao.login(nickUser, senhaUser, nick, senha) 
		        				|| LoginConfirmacao.login(nickUser, senhaUser, cadastroUser, cadastroSenha) ){	
		        			
		        			System.out.println("LOGIN!");
		        			
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
		        		cadastroUser = sc.next();
		        		
		        		System.out.println("Entre com a sua senha");
		        		System.out.print("Digite aqui -->: ");
		        		cadastroSenha = sc.next();
		        		
		        		System.out.println("Confirme sua senha");
		        		System.out.print("Digite aqui -->: ");
		        		confirmacaoSenha = sc.next();
		        		
		        		if(!cadastroSenha.equals(confirmacaoSenha)) {
		        			System.out.println("Senhas não coincidem! Realiza o cadastro novamento.");
		        		}
	        		}while(!cadastroSenha.equals(confirmacaoSenha));
	        		
	        		System.out.println("Usuário cadastrado com sucesso!");
		        break;
	        	case 0 :
	        		
		        break;
		        default:
		        	
	        }
	        
		}
		while(op != 0);

		
		
		sc.close();
	}
}
