package meujogo.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
	private Image fundo; // criando um objeto do tipo imagem com o nome fundo
	private Player player;
	private Timer timer;
	private List<Enemy1> enemy1;

	public Fase() { // contrutor
		setFocusable(true);
		setDoubleBuffered(true);

		ImageIcon referencia = new ImageIcon("res\\background.png");
		fundo = referencia.getImage();

		player = new Player();
		player.load();

		addKeyListener(new TecaldoAdapter());

		timer = new Timer(5, this);
		timer.start();
		
		inicializaInimigos();
	}
	
	public void inicializaInimigos() {
		int condernadas [] = new int [40];
		enemy1 = new ArrayList<Enemy1>();
		
		for (int i=0; i< condernadas.length;i++) {
			int x = (int) (Math.random() * 8000+1024);
			int y = (int) (Math.random() * 650+3);
			enemy1.add(new Enemy1(x,y));
		}
	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null); //
		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

		List<Tiro> tiros = player.getTiros();
		for (int i = 0; i < tiros.size(); i++) {
			Tiro m = tiros.get(i);
			m.load();
			graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
		}

		for(int o=0;o < enemy1.size();o++) {
			Enemy1 in = enemy1.get(o);
			in.load();
			graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
		}
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();

		List<Tiro> tiros = player.getTiros();
		for (int i = 0; i < tiros.size(); i++) {
			Tiro m = tiros.get(i);
			if (m.isVisivel()) {
				m.update();
			} else {
				tiros.remove(i);
			}
		}
		
		for(int o=0;o < enemy1.size();o++) {
			Enemy1 in = enemy1.get(o);
			if(in.isVisivel()) {
				in.update();
			}else {
				enemy1.remove(o);
			}
		}
		repaint();
	}

	private class TecaldoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
		}
	}
}
