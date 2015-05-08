import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Created by Nicole on 04/05/2015.
 */
public class GameFactory {

    public Game createGame(int sizeX, int sizeY){
        Game g = new Game();
        
        //
        //  Creation of track,segments and their Views
        //

        Track track = new Track(sizeX,sizeY);
        TrackView trView = new TrackView(track,sizeX,sizeY);

        SegView tmpSegV;
        Segment tmpSeg;
        Segment[][] tabSeg;
        SegView[][] tabSegView;
        tabSeg = new Segment[sizeX][sizeY];
        tabSegView = new SegView[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                tmpSeg = new Segment(i,j);
                tmpSegV = new SegView(tmpSeg);
                tmpSeg.setView(tmpSegV);
                tabSeg[i][j] = tmpSeg;
                tabSegView[i][j] = tmpSegV;
                trView.addToLayout(tmpSegV);
            }
        }
        track.setTabSeg(tabSeg);
        trView.setSegTab(tabSegView);
        track.setView(trView);
        g.setTrack(track);



   //     g.getTrack().tabSeg[0][10].updateView();
        // add a car
        Car c = new Car(g,29,4,0);
        CarView crv = new CarView(c);
        c.setView(crv);
        g.add_car(c);
        
        Car c2 = new Car(g,29,7,1);
        CarView crv2 = new CarView(c2);
        c2.setView(crv2);
        g.add_car(c2);
     //   c.getPosition().updateView();


        // Update track according element on.
        track.updateview();


//       // Sow grass
//        for(int i = 0; i < sizeX; i++){
//            for(int j = 0; j < 5; j++) {
//                g.sow_grass(i, j);
//            }
//            for(int j = 45; j < 50; j++) {
//                g.sow_grass(i, j);
//            }
//        }
//
//        for(int j = 0; j < sizeY; j++){
//            for(int i = 0; i < 2; i++){
//                g.sow_grass(i,j);
//            }
//        }
//        
//        for(int j = 20; j < 30; j++){
//            for(int i = 15; i < 30; i++){
//                g.sow_grass(i,j);
//            }
//        }
        
        // Sow grass
      
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < 2; j++) {
                g.sow_grass(i, j);
            }
            for(int j = 48; j < 50; j++) {
                g.sow_grass(i, j);
            }
        }

        for(int j = 0; j < sizeY; j++){
            for(int i = 0; i < 2; i++){
                g.sow_grass(i,j);
            }
        }
        
        for(int j = 15; j < 35; j++){
            for(int i = 28; i < 30; i++){
                g.sow_grass(i,j);
            }
        }
        
        for(int j = 10; j < 15; j++){
            for(int i = 10; i < 30; i++){
                g.sow_grass(i,j);
            }
        }
        
        for(int j = 22; j < 28; j++){
            for(int i = 0; i < 21; i++){
                g.sow_grass(i,j);
            }
        }
        
        
        for(int j = 35; j < 40; j++){
            for(int i = 10; i < 30; i++){
                g.sow_grass(i,j);
            }
        }
       
        //finish line
        for (int i=sizeX-2;i<sizeX;i++)
        	for(int j=40;j<48;j++)
        		g.set_finish_line(i, j);

      
        
        
        return g;

    }
    
	

}
