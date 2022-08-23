package meujogo;

import javax.swing.JFrame; // importa biblioteca para renderizacao da imagem

import meujogo.Modelo.Fase;

public class Container  extends JFrame{
	
	public Container() {
		add(new Fase());
		setTitle("Meu Jogo"); // Titulo do jogo
		setSize(1024,728); // tamanho da janela do jogo 1024 de largura e 728 de altura
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ao clicar no x o jogo fecha
		setLocationRelativeTo(null);// ponto da tela assim que o jogo inciar no caso null no centro+
		this.setResizable(false); // controlar quando a pessoa vai poder maximizar o deixar menor quando em false em nenhum momento a pessoa podera alterar o tamanho da tela
		setVisible(true);//define que serie de comando anterior seja visivel
	}
	
	public static void main (String[] args) {
		new Container(); // instancia a classe container
	}
}
