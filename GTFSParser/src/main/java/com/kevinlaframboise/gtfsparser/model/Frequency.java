/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package com.kevinlaframboise.gtfsparser.model;
import java.sql.Time;

// line 156 "../../../../GTFSModel.ump"
// line 237 "../../../../GTFSModel.ump"
public class Frequency
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Frequency Attributes
  private Time startTime;
  private Time endTime;
  private int headwaySecs;
  private boolean exactTimes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Frequency(Time aStartTime, Time aEndTime, int aHeadwaySecs)
  {
    startTime = aStartTime;
    endTime = aEndTime;
    headwaySecs = aHeadwaySecs;
    resetExactTimes();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartTime(Time aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(Time aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setHeadwaySecs(int aHeadwaySecs)
  {
    boolean wasSet = false;
    headwaySecs = aHeadwaySecs;
    wasSet = true;
    return wasSet;
  }

  public boolean setExactTimes(boolean aExactTimes)
  {
    boolean wasSet = false;
    exactTimes = aExactTimes;
    wasSet = true;
    return wasSet;
  }

  public boolean resetExactTimes()
  {
    boolean wasReset = false;
    exactTimes = getDefaultExactTimes();
    wasReset = true;
    return wasReset;
  }

  public Time getStartTime()
  {
    return startTime;
  }

  public Time getEndTime()
  {
    return endTime;
  }

  public int getHeadwaySecs()
  {
    return headwaySecs;
  }

  public boolean getExactTimes()
  {
    return exactTimes;
  }

  public boolean getDefaultExactTimes()
  {
    return false;
  }

  public boolean isExactTimes()
  {
    return exactTimes;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "headwaySecs" + ":" + getHeadwaySecs()+ "," +
            "exactTimes" + ":" + getExactTimes()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startTime" + "=" + (getStartTime() != null ? !getStartTime().equals(this)  ? getStartTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endTime" + "=" + (getEndTime() != null ? !getEndTime().equals(this)  ? getEndTime().toString().replaceAll("  ","    ") : "this" : "null");
  }
}