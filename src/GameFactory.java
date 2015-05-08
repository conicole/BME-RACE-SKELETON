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




		// add  car 1
		Car c = new Car(g,29,4,0);
		CarView crv = new CarView(c);
		c.setView(crv);
		g.add_car(c);

		//adds car 2
		Car c2 = new Car(g,29,7,1);
		CarView crv2 = new CarView(c2);
		c2.setView(crv2);
		g.add_car(c2);



		// Update track according element on.
		track.updateview();



		// Sow grass to a given pattern
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
				g.sow_grass(i,j);//grass
			}
		}

		for(int j = 10; j < 15; j++){
			for(int i = 10; i < 30; i++){
				g.sow_grass(i,j);//grass
			}
		}

		for(int j = 22; j < 28; j++){
			for(int i = 0; i < 21; i++){
				g.sow_grass(i,j);//grass
			}
		}


		for(int j = 35; j < 40; j++){
			for(int i = 10; i < 30; i++){
				g.sow_grass(i,j);//grass
			}
		}

		//finish line
		for (int i=sizeX-2;i<sizeX;i++)
			for(int j=40;j<48;j++)
				g.set_finish_line(i, j);

		//adds obstacles to the track randomly
		int t=Game.rand(0, 10);
		while(t!=0){
			int rndX=Game.rand(0, sizeX-1);
			int rndY =Game.rand(0, sizeY-1);
			if(!track.getSegment(rndX, rndY).isOutOfTrack && !track.getSegment(rndX, rndY).isFinishLine){
				if(!g.containsRaceCarOrRepairCar(track.getSegment(rndX, rndY)))
				g.init_add_obs(rndX, rndY);
				t--;
				}
		} 
		

		// Update track according element on.
				track.updateview();
		//return
		return g;

	}



}
