/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package com.kevinlaframboise.gtfsparser.model;

// line 103 "../../../../GTFSModel.ump"
// line 257 "../../../../GTFSModel.ump"
public class FareRule
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FareRule Attributes
  private FareAttribute attribute;
  private String originId;
  private String destinationId;
  private String containsId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FareRule(FareAttribute aAttribute)
  {
    attribute = aAttribute;
    originId = null;
    destinationId = null;
    containsId = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAttribute(FareAttribute aAttribute)
  {
    boolean wasSet = false;
    attribute = aAttribute;
    wasSet = true;
    return wasSet;
  }

  public boolean setOriginId(String aOriginId)
  {
    boolean wasSet = false;
    originId = aOriginId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDestinationId(String aDestinationId)
  {
    boolean wasSet = false;
    destinationId = aDestinationId;
    wasSet = true;
    return wasSet;
  }

  public boolean setContainsId(String aContainsId)
  {
    boolean wasSet = false;
    containsId = aContainsId;
    wasSet = true;
    return wasSet;
  }

  public FareAttribute getAttribute()
  {
    return attribute;
  }

  public String getOriginId()
  {
    return originId;
  }

  public String getDestinationId()
  {
    return destinationId;
  }

  public String getContainsId()
  {
    return containsId;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "originId" + ":" + getOriginId()+ "," +
            "destinationId" + ":" + getDestinationId()+ "," +
            "containsId" + ":" + getContainsId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "attribute" + "=" + (getAttribute() != null ? !getAttribute().equals(this)  ? getAttribute().toString().replaceAll("  ","    ") : "this" : "null");
  }
}