package campominado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControleJogo implements ActionListener {

	public static final int FACIL = 1;
	public static final int MEDIO = 2;
	public static final int DIFICIL = 3;
	
	private final double PCT_FACIL = 0.1;
	private final double PCT_MEDIO = 0.15;
	private final double PCT_DIFICIL = 0.25;

	private final int NROWS_FACIL = 8;
	private final int NCOLS_FACIL = 10;

	private final int NROWS_MEDIO = 12;
	private final int NCOLS_MEDIO = 14;

	private final int NROWS_DIFICIL = 16;
	private final int NCOLS_DIFICIL = 18;
	
	public static final int QTD_CAMPOS_FACIL = 80;
	public static final int QTD_CAMPOS_MEDIO = 168;
	public static final int QTD_CAMPOS_DIFICIL = 288;

	private int nRows;
	private int nCols;
	private int nRowsCols;
	
	private int nBombas;
	private int dificuldade;

	private List<Posicao> campo;
	
	private TelaInicial tela;
	
	private ControleHistorico controleHistorico;
	private boolean iniciouContagem = false;

	public ControleJogo(TelaInicial tela, int dificuldade) {
		this.tela = tela;
		
		this.dificuldade = dificuldade;
		
		String sDificuldade = "";
		
		switch (dificuldade) {
		case FACIL: {
			nRows = NROWS_FACIL;
			nCols = NCOLS_FACIL;
			sDificuldade = "Facil";
		}
			break;

		case MEDIO: {
			nRows = NROWS_MEDIO;
			nCols = NCOLS_MEDIO;
			sDificuldade = "Medio";
		}
			break;

		case DIFICIL: {
			nRows = NROWS_DIFICIL;
			nCols = NCOLS_DIFICIL;
			sDificuldade = "Dificil";
		}
			break;
		}

		nRowsCols = nRows * nCols;

		campo = new ArrayList<Posicao>(nRowsCols);
		
		controleHistorico = new ControleHistorico(sDificuldade);
	}

	private void demarcarProximidas(Posicao pos) {

		Posicao verifica = null;

		// esquerda superior
		{
			verifica = procurarPor(pos.row - 1, pos.col - 1);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		// superior
		{
			verifica = procurarPor(pos.row - 1, pos.col);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		// direita superior
		{
			verifica = procurarPor(pos.row - 1, pos.col + 1);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		// esquerda
		{
			verifica = procurarPor(pos.row, pos.col - 1);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		// direita
		{
			verifica = procurarPor(pos.row, pos.col + 1);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		// esquerda inferior
		{
			verifica = procurarPor(pos.row + 1, pos.col - 1);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		// inferior
		{
			verifica = procurarPor(pos.row + 1, pos.col);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		// direita inferior
		{
			verifica = procurarPor(pos.row + 1, pos.col + 1);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}
	}

	private void gerarBombas() {
		List<Posicao> bombas = new ArrayList<Posicao>();

		Random rand = new Random();

		switch (dificuldade) {
		case FACIL: {
			nBombas = (int) (((double) nRowsCols) * PCT_FACIL);
		}
			break;

		case MEDIO: {
			nBombas = (int) (((double) nRowsCols) * PCT_MEDIO);
		}
			break;

		case DIFICIL: {
			nBombas = (int) (((double) nRowsCols) * PCT_DIFICIL);
		}
			break;
		}
		
		System.out.println(nBombas);
		
		while (bombas.size() < nBombas) {
			int id = rand.nextInt(nRowsCols + 1);

			if (id == 0)
				continue;

			Posicao pos = new Posicao(id, false, true);

			if (!bombas.contains(pos))
				bombas.add(pos);
		}

		for (Posicao posicao : bombas) {
			posicao.getRow(nCols);
			posicao.getCol(nCols);

			campo.set(posicao.id - 1, posicao);
		}
		
		for (Posicao posicao : campo)
		{
			if (posicao.isBomb)
				demarcarProximidas(posicao);
		}
	}

	public void preencherCampo() {
		for ( int id = 1; id <= nRowsCols; id++) {
			Posicao posicao = new Posicao(id, false, false);
			posicao.getRow(nCols);
			posicao.getCol(nCols);

			campo.add(posicao);
		}
		
		gerarBombas();
	}

	private Posicao procurarPor(int row, int col) {
		for (Posicao posicao : campo) {
			if (posicao.row == row && posicao.col == col)
				return posicao;
		}

		return null;
	}
	
	private Posicao tratarDiagonaisBordaNumeros(Posicao pos, char operacao) {
		
		Posicao verifica = null;
		
		switch (operacao) {
		
			case '-':
			{
				//esquerda superior
				{
					verifica = procurarPor(pos.row - 1, pos.col - 1);
					if (verifica != null && verifica.isBomb) {
						
						Posicao posicaoCanto = procurarPor(pos.row, pos.col - 1);  //esquerda (faz o canto)
						if (posicaoCanto != null && !posicaoCanto.isBomb)
							return posicaoCanto;
							
						return null;
					}
				}
				
				//esquerda inferior
				{
					verifica = procurarPor(pos.row + 1, pos.col - 1);
					if (verifica != null && verifica.isBomb) {
						
						Posicao posicaoCanto = procurarPor(pos.row, pos.col - 1); //esquerda (faz o canto)
						if (posicaoCanto != null && !posicaoCanto.isBomb)
							return posicaoCanto;
							
						return null;
					}
				}
			}
			break;

			case '+':
			{
				//direita superior
				{
					verifica = procurarPor(pos.row - 1, pos.col + 1);
					if (verifica != null && verifica.isBomb) {
						
						Posicao posicaoCanto = procurarPor(pos.row, pos.col + 1); //direita (faz o canto)
						if (posicaoCanto != null && !posicaoCanto.isBomb)
							return posicaoCanto;
								
						return null; 
					}
				}
				
				//direita inferior
				{
					verifica = procurarPor(pos.row + 1, pos.col + 1);
					if (verifica != null && verifica.isBomb) {
						Posicao posicaoCanto = procurarPor(pos.row, pos.col + 1); //direita (faz o canto)
						if (posicaoCanto != null && !posicaoCanto.isBomb)
							return posicaoCanto;
								
						return null;
					}
				}
			}
			break;
		}
		
		return null;
	}

	private void liberarEspacoLinhas(Posicao pos) {
		
		pos.isRevealed = true;
		
		boolean encontrouBorbaNumero = false;
		
		// esquerda
		for (int idx = pos.col - 1; (idx >= 0) && !encontrouBorbaNumero; idx--)
		{
			Posicao verifica = procurarPor(pos.row, idx);
			if (verifica != null) {
				if (verifica.isBomb)
					encontrouBorbaNumero = true;
				else if (verifica.bombCount != 0)
				{
					Posicao posDiagonalComBomba = tratarDiagonaisBordaNumeros(verifica, '-');
					if (posDiagonalComBomba != null)
					{
						posDiagonalComBomba.isRevealed = true;
						encontrouBorbaNumero = true;
					}
					
					verifica.isRevealed = true;
				}
				else
					verifica.isRevealed = true;
			}
		}
		
		encontrouBorbaNumero = false;
		
		// direita
		for (int idx = pos.col + 1; (idx < nCols) && !encontrouBorbaNumero; idx++)
		{
			Posicao verifica = procurarPor(pos.row, idx);
			if (verifica != null) {
				if (verifica.isBomb)
					encontrouBorbaNumero = true;
				else if (verifica.bombCount != 0)
				{
					Posicao posDiagonalComBomba = tratarDiagonaisBordaNumeros(verifica, '+');
					if (posDiagonalComBomba != null)
					{
						posDiagonalComBomba.isRevealed = true;
						encontrouBorbaNumero = true;
					}
					
					verifica.isRevealed = true;
				}
				else
					verifica.isRevealed = true;
			}
		}
		
		// para cima
		{
			Posicao verifica = procurarPor(pos.row - 1, pos.col);
			if (verifica != null && !verifica.isBomb && !verifica.isRevealed)
			{
				liberarEspacoLinhas(verifica);
			}
		}
		
		// para baixo
		{
			Posicao verifica = procurarPor(pos.row + 1, pos.col);
			if (verifica != null && !verifica.isBomb && !verifica.isRevealed)
			{
				liberarEspacoLinhas(verifica);
			}
		}
		
	}
	
	private boolean ehBomba(Posicao pos) {
		if (pos.isBomb)
		{
			pos.isRevealed = true;
			return true;
		}
		
		if (pos.bombCount == 0) {
			liberarEspacoLinhas(pos);
		}
		
		pos.isRevealed = true;

		return false;
	}
	
	private boolean ganhou() {
		int nBombasNaoReveladas = 0;
		
		for (Posicao posicao : campo) {
			if (posicao.isBomb && !posicao.isRevealed)
				nBombasNaoReveladas++;
			
			if(!posicao.isBomb && !posicao.isRevealed)
				return false;
		}
		
		return nBombasNaoReveladas == nBombas;
	}
	
	private void mostrarTudo()
	{
		for (Posicao posicao : campo) {
			posicao.isRevealed = true;
		}
	}
	
	private void atualizarBotoes()
	{
		for (JButton btn : tela.buttons) {
			Integer id = Integer.parseInt(btn.getActionCommand());
			
			Posicao pos = campo.get(id - 1);
			
			if (pos.isRevealed) {
				if (pos.isBomb)
					btn.setIcon(new ImageIcon("img/mina.png"));
				else if (pos.bombCount != 0)
					btn.setText(pos.bombCount + "");
				else
					btn.setText("");
				
				btn.setEnabled(false);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!iniciouContagem)
		{
			controleHistorico.iniciar();
			
			iniciouContagem = true;
		}
		
		Integer id = Integer.parseInt(e.getActionCommand());
		
		Posicao pos = campo.get(id - 1);
		
		if (ehBomba(pos))
		{
			mostrarTudo();
			
			atualizarBotoes();
			
			controleHistorico.finalizar();
			
			JOptionPane.showMessageDialog(null, "Perdeu :(");
		}
		
		if (ganhou())
		{
			mostrarTudo();
			
			atualizarBotoes();
			
			controleHistorico.finalizar();
			controleHistorico.salvar();
			
			JOptionPane.showMessageDialog(null, "Parab?ns!");
		}
		
		atualizarBotoes();
	}

}
