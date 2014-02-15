import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	public static final Dimension d = new Dimension(Tile.size,Tile.size);
	public static final Dimension scaledDim = new Dimension(Tile.scaledSize,Tile.scaledSize);
	
	private JPanel topPanel = new JPanel();
	private JPanel placementPanel = new JPanel();
	
	private JLabel[] xAxisRadarLabel = new JLabel[10];
	private JLabel[] yAxisRadarLabel = new JLabel[10];
	private JLabel[][] radarLabel = new JLabel[10][10];
	private JPanel radarPanel = new JPanel();
	
	private JLabel[] xAxisMyShipsLabel = new JLabel[10];
	private JLabel[] yAxisMyShipsLabel = new JLabel[10];
	private ImagePanel[][] myShipsPanel = new ImagePanel[10][10];
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
		placementPanel.setLayout(new GridBagLayout());
		grid.gridy = 0;
		grid.gridx = 0;		
		GridBagConstraints shipGrid = new GridBagConstraints();

		for(int i = 0;i<p.shipList.size();i++) {
			JPanel shipWhole = new JPanel();
			shipWhole.setLayout(new GridBagLayout());
			shipWhole.addMouseListener(new MouseListener() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					//TODO: this.setBorder, however, you may have to access this statically (ie make shipWhole static)
				}
				@Override
				public void mouseClicked(MouseEvent arg0) {}
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				@Override
				public void mouseExited(MouseEvent arg0) {}
				@Override
				public void mouseReleased(MouseEvent arg0) {}
			});
			shipGrid.gridx = 0;
			shipGrid.gridy = 0;
			
			ImagePanel shipPart = new ImagePanel(Tile.images.get("SHIPFRONT"));
			shipPart.setPreferredSize(scaledDim);
			//placementPanel.add(shipPart, grid);
			shipWhole.add(shipPart, shipGrid);
			for(int j = 1;j<p.shipList.get(i).hitsLeft-1;j++) {
				//grid.gridx++;
				shipGrid.gridx++;
				shipPart = new ImagePanel(Tile.images.get("SHIPBODY"));
				shipPart.setPreferredSize(scaledDim);
				//placementPanel.add(shipPart, grid);
				shipWhole.add(shipPart, shipGrid);
			}
			//grid.gridx++;
			shipGrid.gridx++;
			shipPart = new ImagePanel(Tile.images.get("SHIPBACK"));
			shipPart.setPreferredSize(scaledDim);
			shipWhole.add(shipPart, shipGrid);
			
			//placementPanel.add(shipPart, grid);
			grid.gridwidth = shipGrid.gridx;
			placementPanel.add(shipWhole, grid);
			grid.gridy++;
			grid.gridx = 0;
		}
		
		JButton finishedPlacing = new JButton();
		finishedPlacing.setText("Place Ships");
		finishedPlacing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) topPanel.getLayout()).show(topPanel, "RADAR");
				self.send(Move.LOSE);//TODO: send Player instead
			}
		});
		grid.gridwidth = 6;
		placementPanel.add(finishedPlacing, grid);
		grid.gridwidth = 1;
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
			xAxisMyShipsLabel[i] = new JLabel();
			xAxisMyShipsLabel[i].setText(String.valueOf((char) (65+i)));
			grid.gridx = i+1;
			myShipPanel.add(xAxisMyShipsLabel[i],grid);
		}
		for(int i = 0;i<10;i++) {
			yAxisMyShipsLabel[i] = new JLabel();
			yAxisMyShipsLabel[i].setText(String.valueOf(i+1));
			
			grid.gridx = 0;
			grid.gridy = i+1;
			myShipPanel.add(yAxisMyShipsLabel[i],grid);
			for(int j = 0;j<10;j++) {
				myShipsPanel[i][j] = new ImagePanel(Tile.images.get("WATER"), Tile.scaledSize, Tile.scaleStyle);
				myShipsPanel[i][j].setPreferredSize(scaledDim);//necessary to prevent the resizing onClick (adds border)
				grid.gridx = j+1;
				grid.gridy = i+1;
				myShipPanel.add(myShipsPanel[i][j],grid);
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
					//radarLabel[s.x][s.y+i].setIcon(Tile.images.get("B"));
					//radarLabel[s.x][s.y+i].setImage(Tile.images.get("B"));
				}
			}
		}
	}
}
