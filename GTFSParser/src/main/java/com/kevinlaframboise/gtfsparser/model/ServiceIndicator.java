/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package com.kevinlaframboise.gtfsparser.model;

// line 133 "../../../../GTFSModel.ump"
public class ServiceIndicator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ServiceIndicator Attributes
  private String id;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ServiceIndicator(String aId)
  {
    id = aId;
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

  public String getId()
  {
    return id;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]";
  }
}