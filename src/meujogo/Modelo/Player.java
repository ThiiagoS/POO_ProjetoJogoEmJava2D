package meujogo.Modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {
	
	private int x,y;
	private int dx,dy;
	private Image imagem;
	private int altura, largura;
	private List <Tiro> tiros; // cria uma lista dinamicamente que vai alocando infinitos tiros
	
	public Player(){
		this.x = 100; // definindo o ponto da tela em que o player vai aparecer
		this.y = 100;
		
		tiros = new ArrayList<Tiro>();
	}
	
	public void load() { //esse metoda vai servir para definir a imagem do player
		ImageIcon referencia = new ImageIcon("res\\player.png");
		imagem = referencia.getImage(); // imagem recebe a imagem de referencia
		altura = imagem.getHeight(null); // altura imagem
		largura = imagem.getWidth(null); // largura imagem
	}
	
	public void update() {
		x += dx; //a imagem do player se mova no eixo x
		y += dy; //a imagem do player se mova no eixo x
	}
	
	public void tiroSimples() {
		this.tiros.add(new Tiro(x+largura, y+(altura/2)));
	}
	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode(); // ao pressionar uma tecla do teclado ele recebe na variavel codigo
		
		if(codigo == KeyEvent.VK_A) {
			tiroSimples();
		}
		
		if(codigo == KeyEvent.VK_UP) {
			dy = -3;
		}
		
		if(codigo == KeyEvent.VK_DOWN) {
			dy = +3;
		}
		
		if(codigo == KeyEvent.VK_LEFT) {
			dx = -3;
		}
		
		if(codigo == KeyEvent.VK_RIGHT) {
			dx = +3;
		}
	}
	
	public void keyRelease(KeyEvent tecla) { // ao parar de pressionar ele zera as variaveis
		int codigo = tecla.getKeyCode(); // ao pressionar uma tecla do teclado ele recebe na variavel codigo
		
		if(codigo == KeyEvent.VK_UP) {
			dy = 0;
		}
		
		if(codigo == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		
		if(codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		
		if(codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	public List<Tiro> getTiros() {
		return tiros;
	}
	
}
