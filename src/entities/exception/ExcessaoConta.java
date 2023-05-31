package entities.exception;

public class ExcessaoConta extends Exception{ //Criação da classe de excessão personalizada.
	private static final long serialVersionUID = 1L;
	
	public ExcessaoConta(String msg){
		super(msg);
	}
	
}
