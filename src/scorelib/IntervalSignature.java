/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scorelib;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Vance
 */
public class IntervalSignature{

    private IntegerProperty baseUnit = new SimpleIntegerProperty(0);
    private IntegerProperty beatCount = new SimpleIntegerProperty(0);
    private IntegerProperty key = new SimpleIntegerProperty(0);
    
    public int getBaseUnit() {
        return baseUnit.get();
    }

    public int getBeatCount() {
        return beatCount.get();
    }

    public void setBaseUnit(int baseUnit) {
        this.baseUnit.set(baseUnit);
    }

    public void setBeatCount(int beatCount) {
        this.beatCount.set(beatCount);
    }

    public int getKey() {
        return key.get();
    }

    public void setKey(int key) {
        this.key.set(key);
    }
    
    public IntegerProperty getBaseUnitProperty(){
        return baseUnit;
    }
    
    public IntegerProperty getBeatCountProperty(){
        return beatCount;
    }
    
    public IntegerProperty getKeyProperty(){
        return key;
    }
    
}
