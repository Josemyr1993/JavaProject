package DTO;

public class UtilizadorDTO {
	
	// Declaração de variáveis advindos dos campos do modelo de fromulário de login (frmLoginView.java)
	private int id_usuario;
	private String Nome; 
	private String Password;
	private String Categoria;
	
	// Criamos automaticamente métodos get e set para cada um dos atributos para a classe Utilizador
    // Pelo processo de Emcapsulamento
	// Usamos o Set para determinar os valores inseridos pelo usuário e o get para recuperar os mesmos dados para visualização
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

}
