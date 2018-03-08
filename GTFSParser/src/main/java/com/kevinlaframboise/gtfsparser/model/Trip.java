/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package com.kevinlaframboise.gtfsparser.model;
import java.util.*;

// line 43 "../../../../GTFSModel.ump"
// line 203 "../../../../GTFSModel.ump"
public class Trip
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Trip Attributes
  private Route route;
  private String id;
  private String headsign;
  private String shortName;
  private int direction;
  private String block;
  private int wheelchairAccessible;
  private int bikesAllowed;

  //Trip Associations
  private List<StopTime> stopTimes;
  private List<Frequency> frequencies;
  private List<Service> services;
  private Shape shape;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetRoute;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Trip(Route aRoute, String aId)
  {
    cachedHashCode = -1;
    canSetRoute = true;
    canSetId = true;
    route = aRoute;
    id = aId;
    headsign = null;
    shortName = null;
    direction = 0;
    block = null;
    resetWheelchairAccessible();
    resetBikesAllowed();
    stopTimes = new ArrayList<StopTime>();
    frequencies = new ArrayList<Frequency>();
    services = new ArrayList<Service>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRoute(Route aRoute)
  {
    boolean wasSet = false;
    if (!canSetRoute) { return false; }
    route = aRoute;
    wasSet = true;
    return wasSet;
  }

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    if (!canSetId) { return false; }
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setHeadsign(String aHeadsign)
  {
    boolean wasSet = false;
    headsign = aHeadsign;
    wasSet = true;
    return wasSet;
  }

  public boolean setShortName(String aShortName)
  {
    boolean wasSet = false;
    shortName = aShortName;
    wasSet = true;
    return wasSet;
  }

  public boolean setDirection(int aDirection)
  {
    boolean wasSet = false;
    direction = aDirection;
    wasSet = true;
    return wasSet;
  }

  public boolean setBlock(String aBlock)
  {
    boolean wasSet = false;
    block = aBlock;
    wasSet = true;
    return wasSet;
  }

  public boolean setWheelchairAccessible(int aWheelchairAccessible)
  {
    boolean wasSet = false;
    wheelchairAccessible = aWheelchairAccessible;
    wasSet = true;
    return wasSet;
  }

  public boolean resetWheelchairAccessible()
  {
    boolean wasReset = false;
    wheelchairAccessible = getDefaultWheelchairAccessible();
    wasReset = true;
    return wasReset;
  }

  public boolean setBikesAllowed(int aBikesAllowed)
  {
    boolean wasSet = false;
    bikesAllowed = aBikesAllowed;
    wasSet = true;
    return wasSet;
  }

  public boolean resetBikesAllowed()
  {
    boolean wasReset = false;
    bikesAllowed = getDefaultBikesAllowed();
    wasReset = true;
    return wasReset;
  }

  public Route getRoute()
  {
    return route;
  }

  public String getId()
  {
    return id;
  }

  public String getHeadsign()
  {
    return headsign;
  }

  public String getShortName()
  {
    return shortName;
  }

  public int getDirection()
  {
    return direction;
  }

  public String getBlock()
  {
    return block;
  }

  public int getWheelchairAccessible()
  {
    return wheelchairAccessible;
  }

  public int getDefaultWheelchairAccessible()
  {
    return 0;
  }

  public int getBikesAllowed()
  {
    return bikesAllowed;
  }

  public int getDefaultBikesAllowed()
  {
    return 0;
  }

  public StopTime getStopTime(int index)
  {
    StopTime aStopTime = stopTimes.get(index);
    return aStopTime;
  }

  public List<StopTime> getStopTimes()
  {
    List<StopTime> newStopTimes = Collections.unmodifiableList(stopTimes);
    return newStopTimes;
  }

  public int numberOfStopTimes()
  {
    int number = stopTimes.size();
    return number;
  }

  public boolean hasStopTimes()
  {
    boolean has = stopTimes.size() > 0;
    return has;
  }

  public int indexOfStopTime(StopTime aStopTime)
  {
    int index = stopTimes.indexOf(aStopTime);
    return index;
  }

  public Frequency getFrequency(int index)
  {
    Frequency aFrequency = frequencies.get(index);
    return aFrequency;
  }

  public List<Frequency> getFrequencies()
  {
    List<Frequency> newFrequencies = Collections.unmodifiableList(frequencies);
    return newFrequencies;
  }

  public int numberOfFrequencies()
  {
    int number = frequencies.size();
    return number;
  }

  public boolean hasFrequencies()
  {
    boolean has = frequencies.size() > 0;
    return has;
  }

  public int indexOfFrequency(Frequency aFrequency)
  {
    int index = frequencies.indexOf(aFrequency);
    return index;
  }

  public Service getService(int index)
  {
    Service aService = services.get(index);
    return aService;
  }

  public List<Service> getServices()
  {
    List<Service> newServices = Collections.unmodifiableList(services);
    return newServices;
  }

  public int numberOfServices()
  {
    int number = services.size();
    return number;
  }

  public boolean hasServices()
  {
    boolean has = services.size() > 0;
    return has;
  }

  public int indexOfService(Service aService)
  {
    int index = services.indexOf(aService);
    return index;
  }

  public Shape getShape()
  {
    return shape;
  }

  public boolean hasShape()
  {
    boolean has = shape != null;
    return has;
  }

  public static int minimumNumberOfStopTimes()
  {
    return 0;
  }

  public boolean addStopTime(StopTime aStopTime)
  {
    boolean wasAdded = false;
    if (stopTimes.contains(aStopTime)) { return false; }
    if (stopTimes.contains(aStopTime)) { return false; }
    stopTimes.add(aStopTime);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStopTime(StopTime aStopTime)
  {
    boolean wasRemoved = false;
    if (stopTimes.contains(aStopTime))
    {
      stopTimes.remove(aStopTime);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addStopTimeAt(StopTime aStopTime, int index)
  {  
    boolean wasAdded = false;
    if(addStopTime(aStopTime))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStopTimes()) { index = numberOfStopTimes() - 1; }
      stopTimes.remove(aStopTime);
      stopTimes.add(index, aStopTime);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStopTimeAt(StopTime aStopTime, int index)
  {
    boolean wasAdded = false;
    if(stopTimes.contains(aStopTime))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStopTimes()) { index = numberOfStopTimes() - 1; }
      stopTimes.remove(aStopTime);
      stopTimes.add(index, aStopTime);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStopTimeAt(aStopTime, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfFrequencies()
  {
    return 0;
  }

  public boolean addFrequency(Frequency aFrequency)
  {
    boolean wasAdded = false;
    if (frequencies.contains(aFrequency)) { return false; }
    if (frequencies.contains(aFrequency)) { return false; }
    frequencies.add(aFrequency);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeFrequency(Frequency aFrequency)
  {
    boolean wasRemoved = false;
    if (frequencies.contains(aFrequency))
    {
      frequencies.remove(aFrequency);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addFrequencyAt(Frequency aFrequency, int index)
  {  
    boolean wasAdded = false;
    if(addFrequency(aFrequency))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFrequencies()) { index = numberOfFrequencies() - 1; }
      frequencies.remove(aFrequency);
      frequencies.add(index, aFrequency);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFrequencyAt(Frequency aFrequency, int index)
  {
    boolean wasAdded = false;
    if(frequencies.contains(aFrequency))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFrequencies()) { index = numberOfFrequencies() - 1; }
      frequencies.remove(aFrequency);
      frequencies.add(index, aFrequency);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFrequencyAt(aFrequency, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfServices()
  {
    return 0;
  }

  public boolean addService(Service aService)
  {
    boolean wasAdded = false;
    if (services.contains(aService)) { return false; }
    services.add(aService);
    if (aService.indexOfTrip(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aService.addTrip(this);
      if (!wasAdded)
      {
        services.remove(aService);
      }
    }
    return wasAdded;
  }

  public boolean removeService(Service aService)
  {
    boolean wasRemoved = false;
    if (!services.contains(aService))
    {
      return wasRemoved;
    }

    int oldIndex = services.indexOf(aService);
    services.remove(oldIndex);
    if (aService.indexOfTrip(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aService.removeTrip(this);
      if (!wasRemoved)
      {
        services.add(oldIndex,aService);
      }
    }
    return wasRemoved;
  }

  public boolean addServiceAt(Service aService, int index)
  {  
    boolean wasAdded = false;
    if(addService(aService))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfServices()) { index = numberOfServices() - 1; }
      services.remove(aService);
      services.add(index, aService);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveServiceAt(Service aService, int index)
  {
    boolean wasAdded = false;
    if(services.contains(aService))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfServices()) { index = numberOfServices() - 1; }
      services.remove(aService);
      services.add(index, aService);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addServiceAt(aService, index);
    }
    return wasAdded;
  }

  public boolean setShape(Shape aNewShape)
  {
    boolean wasSet = false;
    shape = aNewShape;
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Trip compareTo = (Trip)obj;
  
    if (getRoute() == null && compareTo.getRoute() != null)
    {
      return false;
    }
    else if (getRoute() != null && !getRoute().equals(compareTo.getRoute()))
    {
      return false;
    }

    if (getId() == null && compareTo.getId() != null)
    {
      return false;
    }
    else if (getId() != null && !getId().equals(compareTo.getId()))
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
    if (getRoute() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getRoute().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    if (getId() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getId().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetRoute = false;
    canSetId = false;
    return cachedHashCode;
  }

  public void delete()
  {
    stopTimes.clear();
    frequencies.clear();
    ArrayList<Service> copyOfServices = new ArrayList<Service>(services);
    services.clear();
    for(Service aService : copyOfServices)
    {
      aService.removeTrip(this);
    }
    shape = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "headsign" + ":" + getHeadsign()+ "," +
            "shortName" + ":" + getShortName()+ "," +
            "direction" + ":" + getDirection()+ "," +
            "block" + ":" + getBlock()+ "," +
            "wheelchairAccessible" + ":" + getWheelchairAccessible()+ "," +
            "bikesAllowed" + ":" + getBikesAllowed()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "route" + "=" + (getRoute() != null ? !getRoute().equals(this)  ? getRoute().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "shape = "+(getShape()!=null?Integer.toHexString(System.identityHashCode(getShape())):"null");
  }
}