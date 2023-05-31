package entities.exception;

import javax.swing.JOptionPane;

/**
 * CLASSE CRIADA PARA USAR E TRATAR EXCESSÕES DE FORMA PERSONALIZADA.
 */
public class ExcessaoConta extends Exception{ 
	
	public ExcessaoConta(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1L;
	
}
