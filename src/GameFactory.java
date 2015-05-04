/**
 * Created by Nicole on 04/05/2015.
 */
public class GameFactory {


    public Game createGame(int sizeX, int sizeY){
        Game g = new Game();

        //
        //  Creation of track,segments and their Views
        //
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
            }
        }
        Track track = new Track(sizeX,sizeY);
        track.setTabSeg(tabSeg);
        TrackView trView = new TrackView(track,sizeX,sizeY);
        track.setView(trView);
        g.setTrack(track);



        // add a car
        Car c = new Car(g,2,2,0);
        CarView crv = new CarView(c);
        c.setView(crv);


        return g;

    }
}
