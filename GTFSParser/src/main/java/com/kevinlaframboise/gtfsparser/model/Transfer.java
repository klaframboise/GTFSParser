/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package com.kevinlaframboise.gtfsparser.model;

// line 164 "../../../../GTFSModel.ump"
// line 242 "../../../../GTFSModel.ump"
public class Transfer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transfer Attributes
  private Stop from;
  private Stop to;
  private int type;
  private int minTransferTime;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transfer(Stop aFrom, Stop aTo)
  {
    from = aFrom;
    to = aTo;
    resetType();
    minTransferTime = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFrom(Stop aFrom)
  {
    boolean wasSet = false;
    from = aFrom;
    wasSet = true;
    return wasSet;
  }

  public boolean setTo(Stop aTo)
  {
    boolean wasSet = false;
    to = aTo;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(int aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean resetType()
  {
    boolean wasReset = false;
    type = getDefaultType();
    wasReset = true;
    return wasReset;
  }

  public boolean setMinTransferTime(int aMinTransferTime)
  {
    boolean wasSet = false;
    minTransferTime = aMinTransferTime;
    wasSet = true;
    return wasSet;
  }

  public Stop getFrom()
  {
    return from;
  }

  public Stop getTo()
  {
    return to;
  }

  public int getType()
  {
    return type;
  }

  public int getDefaultType()
  {
    return 0;
  }

  public int getMinTransferTime()
  {
    return minTransferTime;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "type" + ":" + getType()+ "," +
            "minTransferTime" + ":" + getMinTransferTime()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "from" + "=" + (getFrom() != null ? !getFrom().equals(this)  ? getFrom().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "to" + "=" + (getTo() != null ? !getTo().equals(this)  ? getTo().toString().replaceAll("  ","    ") : "this" : "null");
  }
}