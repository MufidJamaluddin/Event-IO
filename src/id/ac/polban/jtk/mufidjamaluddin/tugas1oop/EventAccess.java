package id.ac.polban.jtk.mufidjamaluddin.tugas1oop;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Mufid Jamaluddin
 * NIM 161511019
 * Kelas 1A D3 Teknik Informatika
 * Politeknik Negeri Bandung
 */
public class EventAccess {
    
    private final Scanner input;
    private final ParseDate parsedt;
    private int sumEvent;
    private Event[] myevent;
    
        
    /* Constructor */
    public EventAccess()
    {
        /**
         * Instantiation
         */
        this.input = new Scanner(System.in);
        this.parsedt = new ParseDate();
        this.myevent = null;
    }
    
    protected void setSumEvent()
    {
        System.out.println("Masukkan Jml Event : ");
        this.sumEvent = this.input.nextInt();
        /* Instantiation */
        this.myevent = new Event[this.getSumEvent()];
    }
    
    /**
     * @return the sumEvent
     */
    protected int getSumEvent() {
        return sumEvent;
    }
    
    /**
     *
     * @param indexArr
     * @throws ParseException
     */
    protected void setEventData(int indexArr) throws ParseException
    {

        /* Instansiasi Isi Objek Array */
        this.myevent[indexArr] = new Event();
        /* The solution bug nextLine method, this input will be skipped */
        this.input.nextLine();
            
        System.out.println("\nEnter a Event Title : ");
            
        myevent[indexArr].setTittleEvent(this.input.nextLine());
            
        /**
         * If the date and time are incorrect then the date and time input will be repeated
         */
        do{
            System.out.println("Set Event Arrival Date and Time\nDate (Format dd-MM-yyyy): ");
        } 
        while(!this.parsedt.setDateValue(this.input.next())); 
            
        do{
            System.out.println("Time (Format HH.mm.ss)");
        } 
        while(!this.parsedt.setTimeValStr(this.input.next()));
            
        /**
         * Entering Date Parsing Results
         */
        this.myevent[indexArr].setArrivalTime(this.parsedt.getDateValue());
            
        /**
         * If the date and time are incorrect then the date and time input will be repeated
         */
        do{
            System.out.println("Set Event Depature Date and Time\nDate (Format dd-MM-yyyy): ");
        } while(!this.parsedt.setDateValue(this.input.next()));
        do{
            System.out.println("Waktu (Format HH.mm.ss)");
        } while(!this.parsedt.setTimeValStr(this.input.next()));
            
        /**
         * Entering Date Parsing Results
         */
        this.myevent[indexArr].setDepatureTime(this.parsedt.getDateValue());
        
    }
    
    /**
     *
     * @param indexArr
     */
    protected void showEventInfo(int indexArr)
    {
        this.myevent[indexArr].getEventInfo();
    }
    
    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException 
    {
        /* Instantiation */
        EventAccess eventObj = new EventAccess();
        
        eventObj.setSumEvent();
        /* Set all data to array */
        for(int i=0; i<eventObj.getSumEvent(); i++)
            eventObj.setEventData(i);
        
        System.out.println("Anda Memasukkan : ");
        /* Show all data in array */
        for(int i=0; i<eventObj.getSumEvent(); i++)
            eventObj.showEventInfo(i);
    
    }

}