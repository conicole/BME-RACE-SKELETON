import javax.swing.*;
import java.awt.*;

/**
 * Created by Nicole on 02/05/2015.
 */
public class TrackView extends JPanel implements IView  {

    private Track track;
    private SegView[][] segTab;


    int taillex = 10;
    int tailley = 5;

    public TrackView(Track tr, int sizeX,int sizeY){
        track = tr;
        GridLayout grid = new GridLayout(sizeX,sizeY);
        this.setLayout(grid);
    }

    public void setSegTab(SegView[][] tabSegV){
        segTab = tabSegV;
    }


    // constructor for test, to delete
    public TrackView(){
        //this.setSize(100000,200000);
        GridLayout grid = new GridLayout(taillex,tailley);
        this.segTab = new SegView[taillex][tailley];
        this.setLayout(grid);
        for(int i = 0; i < taillex; i++){
            for(int j=0; j < tailley; j++){
                if((i==2) && (j==2)){
                    segTab[i][j] = new SegView(1);
                    }
               else {
                    segTab[i][j] = new SegView();

                }
                this.add(segTab[i][j]);
            }
        }


    }




}
