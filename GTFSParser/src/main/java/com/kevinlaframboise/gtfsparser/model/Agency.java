/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package com.kevinlaframboise.gtfsparser.model;
import java.util.*;

// line 9 "../../../../GTFSModel.ump"
// line 184 "../../../../GTFSModel.ump"
public class Agency
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Agency Attributes
  private String id;
  private String name;
  private String url;
  private String timezone;
  private String lang;
  private String phone;
  private String fareUrl;
  private String email;

  //Agency Associations
  private List<Route> routes;
  private List<FareAttribute> fareAttributes;
  private List<Service> services;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Agency(String aName, String aUrl, String aTimezone)
  {
    id = null;
    name = aName;
    url = aUrl;
    timezone = aTimezone;
    lang = null;
    phone = null;
    fareUrl = null;
    email = null;
    routes = new ArrayList<Route>();
    fareAttributes = new ArrayList<FareAttribute>();
    services = new ArrayList<Service>();
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

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setUrl(String aUrl)
  {
    boolean wasSet = false;
    url = aUrl;
    wasSet = true;
    return wasSet;
  }

  public boolean setTimezone(String aTimezone)
  {
    boolean wasSet = false;
    timezone = aTimezone;
    wasSet = true;
    return wasSet;
  }

  public boolean setLang(String aLang)
  {
    boolean wasSet = false;
    lang = aLang;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhone(String aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

  public boolean setFareUrl(String aFareUrl)
  {
    boolean wasSet = false;
    fareUrl = aFareUrl;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getUrl()
  {
    return url;
  }

  public String getTimezone()
  {
    return timezone;
  }

  public String getLang()
  {
    return lang;
  }

  public String getPhone()
  {
    return phone;
  }

  public String getFareUrl()
  {
    return fareUrl;
  }

  public String getEmail()
  {
    return email;
  }

  public Route getRoute(int index)
  {
    Route aRoute = routes.get(index);
    return aRoute;
  }

  public List<Route> getRoutes()
  {
    List<Route> newRoutes = Collections.unmodifiableList(routes);
    return newRoutes;
  }

  public int numberOfRoutes()
  {
    int number = routes.size();
    return number;
  }

  public boolean hasRoutes()
  {
    boolean has = routes.size() > 0;
    return has;
  }

  public int indexOfRoute(Route aRoute)
  {
    int index = routes.indexOf(aRoute);
    return index;
  }

  public FareAttribute getFareAttribute(int index)
  {
    FareAttribute aFareAttribute = fareAttributes.get(index);
    return aFareAttribute;
  }

  public List<FareAttribute> getFareAttributes()
  {
    List<FareAttribute> newFareAttributes = Collections.unmodifiableList(fareAttributes);
    return newFareAttributes;
  }

  public int numberOfFareAttributes()
  {
    int number = fareAttributes.size();
    return number;
  }

  public boolean hasFareAttributes()
  {
    boolean has = fareAttributes.size() > 0;
    return has;
  }

  public int indexOfFareAttribute(FareAttribute aFareAttribute)
  {
    int index = fareAttributes.indexOf(aFareAttribute);
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

  public static int minimumNumberOfRoutes()
  {
    return 0;
  }

  public boolean addRoute(Route aRoute)
  {
    boolean wasAdded = false;
    if (routes.contains(aRoute)) { return false; }
    routes.add(aRoute);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRoute(Route aRoute)
  {
    boolean wasRemoved = false;
    if (routes.contains(aRoute))
    {
      routes.remove(aRoute);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRouteAt(Route aRoute, int index)
  {  
    boolean wasAdded = false;
    if(addRoute(aRoute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoutes()) { index = numberOfRoutes() - 1; }
      routes.remove(aRoute);
      routes.add(index, aRoute);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRouteAt(Route aRoute, int index)
  {
    boolean wasAdded = false;
    if(routes.contains(aRoute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoutes()) { index = numberOfRoutes() - 1; }
      routes.remove(aRoute);
      routes.add(index, aRoute);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRouteAt(aRoute, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfFareAttributes()
  {
    return 0;
  }

  public boolean addFareAttribute(FareAttribute aFareAttribute)
  {
    boolean wasAdded = false;
    if (fareAttributes.contains(aFareAttribute)) { return false; }
    fareAttributes.add(aFareAttribute);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeFareAttribute(FareAttribute aFareAttribute)
  {
    boolean wasRemoved = false;
    if (fareAttributes.contains(aFareAttribute))
    {
      fareAttributes.remove(aFareAttribute);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addFareAttributeAt(FareAttribute aFareAttribute, int index)
  {  
    boolean wasAdded = false;
    if(addFareAttribute(aFareAttribute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFareAttributes()) { index = numberOfFareAttributes() - 1; }
      fareAttributes.remove(aFareAttribute);
      fareAttributes.add(index, aFareAttribute);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFareAttributeAt(FareAttribute aFareAttribute, int index)
  {
    boolean wasAdded = false;
    if(fareAttributes.contains(aFareAttribute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFareAttributes()) { index = numberOfFareAttributes() - 1; }
      fareAttributes.remove(aFareAttribute);
      fareAttributes.add(index, aFareAttribute);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFareAttributeAt(aFareAttribute, index);
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
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeService(Service aService)
  {
    boolean wasRemoved = false;
    if (services.contains(aService))
    {
      services.remove(aService);
      wasRemoved = true;
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

  public void delete()
  {
    routes.clear();
    fareAttributes.clear();
    services.clear();
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "," +
            "url" + ":" + getUrl()+ "," +
            "timezone" + ":" + getTimezone()+ "," +
            "lang" + ":" + getLang()+ "," +
            "phone" + ":" + getPhone()+ "," +
            "fareUrl" + ":" + getFareUrl()+ "," +
            "email" + ":" + getEmail()+ "]";
  }
}