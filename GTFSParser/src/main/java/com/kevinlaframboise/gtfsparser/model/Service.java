/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package com.kevinlaframboise.gtfsparser.model;

// line 122 "../../../../GTFSModel.ump"
public class Service
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Service Attributes
  private ServiceIndicator serviceIndicator;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetServiceIndicator;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Service(ServiceIndicator aServiceIndicator)
  {
    cachedHashCode = -1;
    canSetServiceIndicator = true;
    serviceIndicator = aServiceIndicator;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setServiceIndicator(ServiceIndicator aServiceIndicator)
  {
    boolean wasSet = false;
    if (!canSetServiceIndicator) { return false; }
    serviceIndicator = aServiceIndicator;
    wasSet = true;
    return wasSet;
  }

  public ServiceIndicator getServiceIndicator()
  {
    return serviceIndicator;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Service compareTo = (Service)obj;
  
    if (getServiceIndicator() == null && compareTo.getServiceIndicator() != null)
    {
      return false;
    }
    else if (getServiceIndicator() != null && !getServiceIndicator().equals(compareTo.getServiceIndicator()))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (getServiceIndicator() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getServiceIndicator().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetServiceIndicator = false;
    return cachedHashCode;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "serviceIndicator" + "=" + (getServiceIndicator() != null ? !getServiceIndicator().equals(this)  ? getServiceIndicator().toString().replaceAll("  ","    ") : "this" : "null");
  }
}