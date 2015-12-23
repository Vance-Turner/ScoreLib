/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scorelib;

import java.util.UUID;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Vance
 */
public class IntervalNote {

    private final IntegerProperty interval =  new SimpleIntegerProperty(0);
    private final IntegerProperty duration = new SimpleIntegerProperty(0);
    private final UUID id = UUID.randomUUID();
    
    public int getInterval() {
        return interval.get();
    }

    public int getDuration() {
        return duration.get();
    }

    public UUID getID() {
        return id;
    }

    public void setInterval(int interval) {
        this.interval.set(interval);
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }
    
    public IntegerProperty getIntervalProperty(){
        return interval;
    }
    
    public IntegerProperty getDurationProperty(){
        return duration;
    }
}
