/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package com.kevinlaframboise.gtfsparser.model;
import java.util.*;

// line 127 "../../../../GTFSModel.ump"
public class Service
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Service Attributes
  private ServiceIndicator serviceIndicator;

  //Service Associations
  private List<Trip> trips;

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
    trips = new ArrayList<Trip>();
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

  public Trip getTrip(int index)
  {
    Trip aTrip = trips.get(index);
    return aTrip;
  }

  public List<Trip> getTrips()
  {
    List<Trip> newTrips = Collections.unmodifiableList(trips);
    return newTrips;
  }

  public int numberOfTrips()
  {
    int number = trips.size();
    return number;
  }

  public boolean hasTrips()
  {
    boolean has = trips.size() > 0;
    return has;
  }

  public int indexOfTrip(Trip aTrip)
  {
    int index = trips.indexOf(aTrip);
    return index;
  }

  public static int minimumNumberOfTrips()
  {
    return 0;
  }

  public boolean addTrip(Trip aTrip)
  {
    boolean wasAdded = false;
    if (trips.contains(aTrip)) { return false; }
    trips.add(aTrip);
    if (aTrip.indexOfService(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTrip.addService(this);
      if (!wasAdded)
      {
        trips.remove(aTrip);
      }
    }
    return wasAdded;
  }

  public boolean removeTrip(Trip aTrip)
  {
    boolean wasRemoved = false;
    if (!trips.contains(aTrip))
    {
      return wasRemoved;
    }

    int oldIndex = trips.indexOf(aTrip);
    trips.remove(oldIndex);
    if (aTrip.indexOfService(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTrip.removeService(this);
      if (!wasRemoved)
      {
        trips.add(oldIndex,aTrip);
      }
    }
    return wasRemoved;
  }

  public boolean addTripAt(Trip aTrip, int index)
  {  
    boolean wasAdded = false;
    if(addTrip(aTrip))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTrips()) { index = numberOfTrips() - 1; }
      trips.remove(aTrip);
      trips.add(index, aTrip);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTripAt(Trip aTrip, int index)
  {
    boolean wasAdded = false;
    if(trips.contains(aTrip))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTrips()) { index = numberOfTrips() - 1; }
      trips.remove(aTrip);
      trips.add(index, aTrip);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTripAt(aTrip, index);
    }
    return wasAdded;
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
  {
    ArrayList<Trip> copyOfTrips = new ArrayList<Trip>(trips);
    trips.clear();
    for(Trip aTrip : copyOfTrips)
    {
      aTrip.removeService(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "serviceIndicator" + "=" + (getServiceIndicator() != null ? !getServiceIndicator().equals(this)  ? getServiceIndicator().toString().replaceAll("  ","    ") : "this" : "null");
  }
}