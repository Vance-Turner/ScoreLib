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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Vance
 */
public class IntervalMeasure{

    private final UUID id = UUID.randomUUID();
    private IntervalSignature signature = new IntervalSignature();

    public void setSignature(IntervalSignature signature) {
        this.signature = signature;
    }

    public IntervalSignature getSignature() {
        return signature;
    }
    
    private class MeasureNote extends IntervalNote{
        
        private IntervalNote innerNote;
        
        public MeasureNote(IntervalNote note,int position){
            innerNote = note;
            this.position = position;
        }
        
        @Override
        public UUID getID(){
            return innerNote.getID();
        }
        
        @Override
        public int getDuration(){
            return innerNote.getDuration();
        }
        
        @Override
        public int getInterval(){
            return innerNote.getInterval();
        }
        
        public int position;
    }
    
    /**
     * Actually contains MeasureNotes
     */
    private ObservableList<IntervalNote> notes 
            = new SimpleListProperty<IntervalNote>(FXCollections.observableArrayList()) ;
    
    public ObservableList<IntervalNote> getNotesProperty() {
        return notes;
    }

    public List<IntervalNote> getNotesByPosition(int timePosition) {
        ArrayList<IntervalNote> tempnotes = new ArrayList<>();
        for(int i=0; i<notes.size(); i++){
            MeasureNote note = (MeasureNote) notes.get(i);
            if(note.position == timePosition){
                tempnotes.add(note);
            }
        }
        return tempnotes;
    }

    public List<IntervalNote> getNotesByInterval(int interval) {
        ArrayList<IntervalNote> tempnotes = new ArrayList<>();
        for(int i=0; i<notes.size(); i++){
            if(notes.get(i).getInterval() == interval){
                tempnotes.add(notes.get(i));
            }
        }
        return tempnotes;
    }
    
    public int getNotePosition(IntervalNote note){
        for(int i=0; i<notes.size(); i++){
            MeasureNote note2 = (MeasureNote)notes.get(i);
            if(note2.getID().compareTo(note.getID())==0){
                return note2.position;
            }
        }
        return -1;
    }

    public void addNote(IntervalNote note, int position) {
        notes.add(new MeasureNote(note,position));
    }

    public void removeNote(UUID noteID) {
        for(int i=0; i<notes.size(); i++){
            if(notes.get(i).getID().compareTo(noteID)==0){
                notes.remove(i);
                break;
            }
        }
    }

    public UUID getID() {
        return id;
    }
    
}
