import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nicole on 02/05/2015.
 */
public class TrackView extends JPanel implements IView  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SegView[][] segTab;

    private GridLayout grid;
    private static BufferedImage grassimg;
	private static BufferedImage roadimg;

    int taillex;
    int tailley;

    public TrackView(Track tr, int sizeX,int sizeY){
        taillex = sizeX;
        tailley = sizeY;
        grid = new GridLayout(sizeX,sizeY);
        this.setLayout(grid);
        
        try {
			loadGrassImg();
			loadRoadImg() ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void setSegTab(SegView[][] tabSegV){
        segTab = tabSegV;
    }

    public void addToLayout(Component c){
        this.add(c);
    }


    public void updateView(){
        for(int i=0; i< taillex; i++){
            for(int j=0; j< tailley; j++){
                segTab[i][j].updateComponent();
                segTab[i][j].repaint();
            }
        }
    }

	public static BufferedImage getGrassImg(){
		return grassimg;
		
	};
	public static BufferedImage getRoadImg(){
		return roadimg;
	};
    private void loadGrassImg() throws IOException{
    	File img = new File("grass.jpg");
        BufferedImage image = ImageIO.read(img);
        grassimg= image;
    }
    
    private void loadRoadImg() throws IOException{
    	File img = new File("road.jpg");
        BufferedImage image = ImageIO.read(img);
        roadimg= image;
    }




}
