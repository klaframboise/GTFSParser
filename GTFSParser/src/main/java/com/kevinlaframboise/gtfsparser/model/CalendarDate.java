/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package com.kevinlaframboise.gtfsparser.model;
import java.sql.Date;

// line 153 "../../../../GTFSModel.ump"
// line 237 "../../../../GTFSModel.ump"
public class CalendarDate extends ServiceIndicator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CalendarDate Attributes
  private Date date;
  private int exceptionType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CalendarDate(String aId, Date aDate, int aExceptionType)
  {
    super(aId);
    date = aDate;
    exceptionType = aExceptionType;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setExceptionType(int aExceptionType)
  {
    boolean wasSet = false;
    exceptionType = aExceptionType;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public int getExceptionType()
  {
    return exceptionType;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "exceptionType" + ":" + getExceptionType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null");
  }
}