/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package com.kevinlaframboise.gtfsparser.model;
import java.sql.Date;

// line 127 "../../../../GTFSModel.ump"
// line 222 "../../../../GTFSModel.ump"
public class Calendar
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Calendar Attributes
  private String id;
  private boolean monday;
  private boolean tuesday;
  private boolean wednesday;
  private boolean thursday;
  private boolean friday;
  private boolean saturday;
  private boolean sunday;
  private Date startDate;
  private Date endDate;

  //Calendar Associations
  private Agency agency;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Calendar(String aId, boolean aMonday, boolean aTuesday, boolean aWednesday, boolean aThursday, boolean aFriday, boolean aSaturday, boolean aSunday, Date aStartDate, Date aEndDate, Agency aAgency)
  {
    id = aId;
    monday = aMonday;
    tuesday = aTuesday;
    wednesday = aWednesday;
    thursday = aThursday;
    friday = aFriday;
    saturday = aSaturday;
    sunday = aSunday;
    startDate = aStartDate;
    endDate = aEndDate;
    if (!setAgency(aAgency))
    {
      throw new RuntimeException("Unable to create Calendar due to aAgency");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setMonday(boolean aMonday)
  {
    boolean wasSet = false;
    monday = aMonday;
    wasSet = true;
    return wasSet;
  }

  public boolean setTuesday(boolean aTuesday)
  {
    boolean wasSet = false;
    tuesday = aTuesday;
    wasSet = true;
    return wasSet;
  }

  public boolean setWednesday(boolean aWednesday)
  {
    boolean wasSet = false;
    wednesday = aWednesday;
    wasSet = true;
    return wasSet;
  }

  public boolean setThursday(boolean aThursday)
  {
    boolean wasSet = false;
    thursday = aThursday;
    wasSet = true;
    return wasSet;
  }

  public boolean setFriday(boolean aFriday)
  {
    boolean wasSet = false;
    friday = aFriday;
    wasSet = true;
    return wasSet;
  }

  public boolean setSaturday(boolean aSaturday)
  {
    boolean wasSet = false;
    saturday = aSaturday;
    wasSet = true;
    return wasSet;
  }

  public boolean setSunday(boolean aSunday)
  {
    boolean wasSet = false;
    sunday = aSunday;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartDate(Date aStartDate)
  {
    boolean wasSet = false;
    startDate = aStartDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndDate(Date aEndDate)
  {
    boolean wasSet = false;
    endDate = aEndDate;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public boolean getMonday()
  {
    return monday;
  }

  public boolean getTuesday()
  {
    return tuesday;
  }

  public boolean getWednesday()
  {
    return wednesday;
  }

  public boolean getThursday()
  {
    return thursday;
  }

  public boolean getFriday()
  {
    return friday;
  }

  public boolean getSaturday()
  {
    return saturday;
  }

  public boolean getSunday()
  {
    return sunday;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public Date getEndDate()
  {
    return endDate;
  }

  public boolean isMonday()
  {
    return monday;
  }

  public boolean isTuesday()
  {
    return tuesday;
  }

  public boolean isWednesday()
  {
    return wednesday;
  }

  public boolean isThursday()
  {
    return thursday;
  }

  public boolean isFriday()
  {
    return friday;
  }

  public boolean isSaturday()
  {
    return saturday;
  }

  public boolean isSunday()
  {
    return sunday;
  }

  public Agency getAgency()
  {
    return agency;
  }

  public boolean setAgency(Agency aNewAgency)
  {
    boolean wasSet = false;
    if (aNewAgency != null)
    {
      agency = aNewAgency;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    agency = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "monday" + ":" + getMonday()+ "," +
            "tuesday" + ":" + getTuesday()+ "," +
            "wednesday" + ":" + getWednesday()+ "," +
            "thursday" + ":" + getThursday()+ "," +
            "friday" + ":" + getFriday()+ "," +
            "saturday" + ":" + getSaturday()+ "," +
            "sunday" + ":" + getSunday()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startDate" + "=" + (getStartDate() != null ? !getStartDate().equals(this)  ? getStartDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endDate" + "=" + (getEndDate() != null ? !getEndDate().equals(this)  ? getEndDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "agency = "+(getAgency()!=null?Integer.toHexString(System.identityHashCode(getAgency())):"null");
  }
}