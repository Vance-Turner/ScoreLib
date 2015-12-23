/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scorelib;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Vance
 */
public class BasicScore {
    
    private StringProperty title = new SimpleStringProperty("Music");
    private ObservableList<IntervalMeasure> measures 
            = new SimpleListProperty<>(FXCollections.observableArrayList());

    public ObservableList<IntervalMeasure> getMeasures() {
        return measures;
    }

    public IntervalMeasure getMeasure(int index) {
        return measures.get(index);
    }

    public void addMeasure(IntervalMeasure measure, int position) {
        measures.add(position, measure);
    }

    public void removeMeasure(UUID id) {
        for(int i=0; i<measures.size(); i++){
            if(measures.get(i).getID().compareTo(id)==0){
                measures.remove(i);
                break;
            }
        }
    }

    public void removeMeasure(int index) {
        measures.remove(index);
    }

    public String getScoreTitle() {
        return title.get();
    }

    public void setScoreTitle(String title) {
        this.title.set(title);    
    }
    
    public StringProperty getScoreTitleProperty(){
        return title;
    }
}
