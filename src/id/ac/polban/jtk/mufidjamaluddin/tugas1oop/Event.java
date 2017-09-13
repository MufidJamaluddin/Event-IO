/**
 * This class aims to manage event data
 */
package id.ac.polban.jtk.mufidjamaluddin.tugas1oop;

import java.util.Date;

/**
 *
 * @author Mufid Jamaluddin
 * NIM 161511019
 * Kelas 1A D3 Teknik Informatika
 * Politeknik Negeri Bandung
 */
public class Event {
    private String tittleEvent;
    private Date arrivalTime;
    private Date depatureTime;
    
    /**
     * Constructor 
     */
    public Event()
    {
        tittleEvent = null;
        arrivalTime = null;
        depatureTime = null;
    }
    
    /**
     * Show Event  
     */
    void getEventInfo()
    {
        if(tittleEvent!=null || arrivalTime!=null || depatureTime!=null)
            System.out.println("\nTittle Event :\t" + this.tittleEvent + "\nArrival Time :\t" + this.arrivalTime +"\nDepature Time :\t" + this.depatureTime + "\n");
        else
            System.out.println("You have not filled out the data yet");
    }

    /**
     * @param tittleEvent the tittleEvent to set
     */
    public void setTittleEvent(String tittleEvent) {
        this.tittleEvent = tittleEvent;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @param depatureTimeEv
     */
    public void setDepatureTime(Date depatureTimeEv) {
        if(!depatureTimeEv.before(this.arrivalTime)) {
            this.depatureTime = depatureTimeEv;
        } else {
            System.out.println("Arrival time and departure time that you enter interchangeable, we will exchange it");
            this.depatureTime = this.arrivalTime;
            this.arrivalTime = depatureTimeEv;
        }
    }
    
}