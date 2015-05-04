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


        // add a car
        Car c = new Car(g,0,0,0);
        CarView crv = new CarView(c);
        c.setView(crv);
        g.add_car(c);






        return g;

    }
}
