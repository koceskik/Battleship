import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class GameHolder {
	private volatile Battleship.ClientHandler self = null;
	
	private static GridBagConstraints grid = new GridBagConstraints();
	public static final Border selectedBorder = BorderFactory.createLineBorder(Color.red);
	public static final Border legalMoveBorder = BorderFactory.createLineBorder(Color.blue);
	public static final Border nullBorder = BorderFactory.createEmptyBorder();
	
	private JPanel topPanel = new JPanel();
	private JPanel placementPanel = new JPanel();
	
	private JLabel[] xAxisRadarLabel = new JLabel[10];
	private JLabel[] yAxisRadarLabel = new JLabel[10];
	private JLabel[][] radarLabel = new JLabel[10][10];
	private JPanel radarPanel = new JPanel();
	
	private JLabel[] xAxisMyShipsLabel = new JLabel[10];
	private JLabel[] yAxisMyShipsLabel = new JLabel[10];
	private JLabel[][] myShipsLabel = new JLabel[10][10];
	private JPanel myShipPanel = new JPanel();
	
	private Player p;
	public GameHolder(Player p, Battleship.ClientHandler self, JPanel location) {
		this.p = p;
		this.self = self;
		topPanel.setLayout(new CardLayout());
		topPanel.add(placementPanel, "PLACE");
		topPanel.add(radarPanel, "RADAR");
		((CardLayout) topPanel.getLayout()).show(topPanel, "PLACE");
		
		location.add(topPanel);
		location.add(myShipPanel);
		initPlacementPanel();
		initRadarPanel();
		initMyShipPanel();
	}
	
	private void initPlacementPanel() {
		JLabel text = new JLabel();
		text.setText("Place Your Ships");
		placementPanel.add(text);
		
		JButton finishedPlacing = new JButton();
		finishedPlacing.setText("Place Ships");
		finishedPlacing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) topPanel.getLayout()).show(topPanel, "RADAR");
			}
		});
		placementPanel.add(finishedPlacing);
		JLabel s1 = new JLabel();
		//s1.setIcon(Tile.images.get("BWPs"));
		s1.setBackground(Color.BLUE);
		s1.setSize(new Dimension(16, 16));
		placementPanel.add(s1);

		JLabel s2 = new JLabel();
		s2.setIcon(Tile.images.get("BWNs"));
		placementPanel.add(s2);
		
		JLabel s3 = new JLabel();
		s3.setIcon(Tile.images.get("BWBs"));
		placementPanel.add(s3);
		
		JLabel s4 = new JLabel();
		s4.setIcon(Tile.images.get("BWRs"));
		placementPanel.add(s4);
		
		JLabel s5 = new JLabel();
		s5.setIcon(Tile.images.get("BWKs"));
		placementPanel.add(s5);
		
	}
	
	private void initRadarPanel() {
		radarPanel.setLayout(new GridBagLayout());
		grid.gridy = 0;
		for(int i = 0;i<10;i++) {
			xAxisRadarLabel[i] = new JLabel();
			xAxisRadarLabel[i].setText(String.valueOf((char) (65+i)));
			grid.gridx = i+1;
			radarPanel.add(xAxisRadarLabel[i],grid);
		}
		for(int i = 0;i<10;i++) {
			yAxisRadarLabel[i] = new JLabel();
			yAxisRadarLabel[i].setText(String.valueOf(i+1));
			
			grid.gridx = 0;
			grid.gridy = i+1;
			radarPanel.add(yAxisRadarLabel[i],grid);
			for(int j = 0;j<10;j++) {
				radarLabel[i][j] = new JLabel();
				//label[i][j].setPreferredSize(d);//necessary to prevent the resizing onClick (adds border)
				grid.gridx = j+1;
				grid.gridy = i+1;
				radarPanel.add(radarLabel[i][j],grid);
			}
		}
	}
	
	private void initMyShipPanel() {
		myShipPanel.setLayout(new GridBagLayout());
		grid.gridy = 0;
		for(int i = 0;i<10;i++) {
			xAxisRadarLabel[i] = new JLabel();
			xAxisRadarLabel[i].setText(String.valueOf((char) (65+i)));
			grid.gridx = i+1;
			myShipPanel.add(xAxisRadarLabel[i],grid);
		}
		for(int i = 0;i<10;i++) {
			yAxisRadarLabel[i] = new JLabel();
			yAxisRadarLabel[i].setText(String.valueOf(i+1));
			
			grid.gridx = 0;
			grid.gridy = i+1;
			myShipPanel.add(yAxisRadarLabel[i],grid);
			for(int j = 0;j<10;j++) {
				radarLabel[i][j] = new JLabel();
				//label[i][j].setPreferredSize(d);//necessary to prevent the resizing onClick (adds border)
				grid.gridx = j+1;
				grid.gridy = i+1;
				myShipPanel.add(radarLabel[i][j],grid);
			}
		}
	}
	
	public void updateGame(Game game) {
		//TODO
	}
	
	public void initLabelClick() {
		
	}
	
	public void drawMyShips() {
		for(Ship s : p.shipList) {
			for(int i = 0;i<s.hits.length;i++) {
				if(s.isVert) {
					radarLabel[s.x][s.y+i].setIcon(Tile.images.get("B"));
				}
			}
		}
	}
}
