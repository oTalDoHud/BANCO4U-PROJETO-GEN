package entities;

public class Usuario {

	private String name;
	
	private String senha;

	public Usuario(String name, String senha) {
		super();
		this.name = name;
		this.senha = senha;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
