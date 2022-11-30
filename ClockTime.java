/**
 * Name: Nick Sikorski (sikorskn)
 * Course: CSCI 241 - Computer Science I
 * Section: 002
 * Assignment: 9
 * 
 * Project/Class Description:
 * 
 * This class simulates a clock, keeping track of the hours, minutes,
 * and seconds. Basic functionality includes getting the time, setting
 * the time, displaying the time, advancing the time, and comparing
 * two times.
 * 
 * Variables: 
 * (all private)
 * int hour, int minute, and int second.
 * They hold the hours, minutes, and seconds, respectively.
 * 
 * Methods:
 * 
 * Constructors:
 * 
 * ClockTime() leads to ClockTime(0,0,0).
 * 
 * ClockTime(int hour, int minute, int second) initializes the three variables
 * using the numbers provided.
 * 
 * Not Constructors:
 * 
 * Getters and Setters for all three variables
 * (Setters prevent underflow)
 * 
 * toString converts the time to a string format (24-hour)
 * ("hh:mm:ss")
 * 
 * toString12 coverts the time to a string format (12-hour)
 * ("hh:mm:ss A.M./P.M."
 * 
 * advance(int secondsToAdvance) increments the seconds by a specified amount
 * and runs the checkOverflow method.
 * 
 * equals compares two ClockTime objects and checks if they exactly equal
 * each other (hour = hour, minute = minute, and second = second).
 * 
 * Helper methods (all private):
 * 
 * formatClockNum formats a number with a leading zero if necessary.
 * 0  -> "00"
 * 9  -> "09"
 * 10 -> "10"
 * 
 * preventOverflow advances the minutes and hours depending on excess seconds
 * and minutes. Excess hours are removed (no day variable).
 * This evens out the clock numbers and allows them all to stay in bounds
 * after the method runs.
 * 
 * Known Bugs: 
 * 
 * None
 * 
 */

public class ClockTime{
    // Time vars
    private int hour;
    private int minute;
    private int second;
    
    // Default Constructor
    public ClockTime(){
        // Call the constructor that takes in the hour,
        // the minute, and the second to set all of them to zeros.
        this(0,0,0);
    }
    
    // Constructor that initializes the time using hour, minute, and second ints.
    public ClockTime(int hour, int minute, int second){
        // Short hand ifs check if input was negative. Negative inputs are converted to zero.
        this.hour = hour > 0 ? hour : 0;
        this.minute = minute > 0 ? minute : 0;
        this.second = second > 0 ? second : 0;
        preventOverflow();
    }
    
    /** Getters */
    public int getHour(){
        return hour;
    }
    public int getMinute(){
        return minute;
    }
    public int getSecond(){
        return second;
    }
    
    /** Setters */
    // Short hand ifs check if input was negative. Negative inputs are converted to zero.
    public void setHour(int hour){
        this.hour = hour > 0 ? hour : 0;
        preventOverflow();
    }
    public void setMinute(int minute){
        this.minute = minute > 0 ? minute : 0;
        preventOverflow();
    }
    public void setSecond(int second){
        this.second = second > 0 ? second : 0;
        preventOverflow();
    }
    
    /** toString methods */
    // Return the clock time formatted using 24-hour format
    public String toString(){
        // Format the clock numbers and separate them with colons
        return formatClockNum(hour) + ":" + formatClockNum(minute) + ":" + formatClockNum(second);
    }
    
    // Return the clock time formatted using 12-hour format
    public String toString12(){
        String ampm = "A.M.";
        if(hour >= 12) ampm = "P.M."; // If hour is at least 12 then it is P.M. Otherwise, it is A.M.
        int hourAdjusted = (hour % 12); // Adjusted hour
        if(hourAdjusted == 0) hourAdjusted = 12; // At hour = 0, it is midnight (12 A.M.) At hour = 12, it is noon (12 P.M.).
        return formatClockNum(hourAdjusted) + ":" + formatClockNum(minute) + ":" +
            formatClockNum(second) + " " + ampm;
    }
    
    // Advance the clock time a certain amount of seconds
    public void advance(int secondsToAdvance){
        if(secondsToAdvance > 0){ // Check for positive input
            second += secondsToAdvance;
            preventOverflow();
        }
    }
    
    // check if ClockTime c equals this ClockTime
    public boolean equals(ClockTime c){
        // All three must match for it to return true. Oterwise, it will return false.
        return hour == c.getHour() && minute == c.getMinute() && second == c.getSecond();
    }
    
    // Helper method that returns a clock number formatted with a leading zero if necessary
    private String formatClockNum(int num){
        // If num is less than 10 (a single digit from 0-9), a leading zero is needed.
        // Otherwise, an empty string is there to convert the int to a String.
        return (num < 10 ? "0" : "") + num;
    }
    
    // Helper method that checks for overflow
    private void preventOverflow(){
        // Add excess groups of 60 seconds to minute. 119/60 = 1 so 1 extra minute is added.
        // 120/60 = 2 so 2 extra minutes are added.
        minute += second / 60;
        // Add excess groups of 60 minutes to hour.
        hour += minute / 60;
        
        // Modulus everything to stop overflow
        hour = hour % 24;
        minute = minute % 60;
        second = second % 60;
    }
}

