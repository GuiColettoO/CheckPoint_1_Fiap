package br.com.fiap.exception;

@SuppressWarnings("all")
public class EntidadeNaoEcontradaException extends Exception{
	
	public EntidadeNaoEcontradaException() {
		super("Entidade não encontrada");
	}
	
	public EntidadeNaoEcontradaException(String msg) {
		super(msg);
	}
}
