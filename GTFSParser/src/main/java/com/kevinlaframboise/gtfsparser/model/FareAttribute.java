/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package com.kevinlaframboise.gtfsparser.model;
import java.util.*;

// line 89 "../../../../GTFSModel.ump"
// line 217 "../../../../GTFSModel.ump"
public class FareAttribute
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FareAttribute Attributes
  private String agencyId;
  private String id;
  private float price;
  private String currency;
  private int paymentMethod;
  private int transfers;
  private int transferDuration;

  //FareAttribute Associations
  private List<FareRule> fareRules;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetAgencyId;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FareAttribute(String aAgencyId, String aId, float aPrice, String aCurrency, int aPaymentMethod)
  {
    cachedHashCode = -1;
    canSetAgencyId = true;
    canSetId = true;
    agencyId = aAgencyId;
    id = aId;
    price = aPrice;
    currency = aCurrency;
    paymentMethod = aPaymentMethod;
    resetTransfers();
    transferDuration = 0;
    fareRules = new ArrayList<FareRule>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAgencyId(String aAgencyId)
  {
    boolean wasSet = false;
    if (!canSetAgencyId) { return false; }
    agencyId = aAgencyId;
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

  public boolean setPrice(float aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrency(String aCurrency)
  {
    boolean wasSet = false;
    currency = aCurrency;
    wasSet = true;
    return wasSet;
  }

  public boolean setPaymentMethod(int aPaymentMethod)
  {
    boolean wasSet = false;
    paymentMethod = aPaymentMethod;
    wasSet = true;
    return wasSet;
  }

  public boolean setTransfers(int aTransfers)
  {
    boolean wasSet = false;
    transfers = aTransfers;
    wasSet = true;
    return wasSet;
  }

  public boolean resetTransfers()
  {
    boolean wasReset = false;
    transfers = getDefaultTransfers();
    wasReset = true;
    return wasReset;
  }

  public boolean setTransferDuration(int aTransferDuration)
  {
    boolean wasSet = false;
    transferDuration = aTransferDuration;
    wasSet = true;
    return wasSet;
  }

  public String getAgencyId()
  {
    return agencyId;
  }

  public String getId()
  {
    return id;
  }

  public float getPrice()
  {
    return price;
  }

  public String getCurrency()
  {
    return currency;
  }

  public int getPaymentMethod()
  {
    return paymentMethod;
  }

  public int getTransfers()
  {
    return transfers;
  }

  public int getDefaultTransfers()
  {
    return 3;
  }

  public int getTransferDuration()
  {
    return transferDuration;
  }

  public FareRule getFareRule(int index)
  {
    FareRule aFareRule = fareRules.get(index);
    return aFareRule;
  }

  public List<FareRule> getFareRules()
  {
    List<FareRule> newFareRules = Collections.unmodifiableList(fareRules);
    return newFareRules;
  }

  public int numberOfFareRules()
  {
    int number = fareRules.size();
    return number;
  }

  public boolean hasFareRules()
  {
    boolean has = fareRules.size() > 0;
    return has;
  }

  public int indexOfFareRule(FareRule aFareRule)
  {
    int index = fareRules.indexOf(aFareRule);
    return index;
  }

  public static int minimumNumberOfFareRules()
  {
    return 0;
  }

  public boolean addFareRule(FareRule aFareRule)
  {
    boolean wasAdded = false;
    if (fareRules.contains(aFareRule)) { return false; }
    fareRules.add(aFareRule);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeFareRule(FareRule aFareRule)
  {
    boolean wasRemoved = false;
    if (fareRules.contains(aFareRule))
    {
      fareRules.remove(aFareRule);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addFareRuleAt(FareRule aFareRule, int index)
  {  
    boolean wasAdded = false;
    if(addFareRule(aFareRule))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFareRules()) { index = numberOfFareRules() - 1; }
      fareRules.remove(aFareRule);
      fareRules.add(index, aFareRule);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFareRuleAt(FareRule aFareRule, int index)
  {
    boolean wasAdded = false;
    if(fareRules.contains(aFareRule))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFareRules()) { index = numberOfFareRules() - 1; }
      fareRules.remove(aFareRule);
      fareRules.add(index, aFareRule);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFareRuleAt(aFareRule, index);
    }
    return wasAdded;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    FareAttribute compareTo = (FareAttribute)obj;
  
    if (getAgencyId() == null && compareTo.getAgencyId() != null)
    {
      return false;
    }
    else if (getAgencyId() != null && !getAgencyId().equals(compareTo.getAgencyId()))
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
    if (getAgencyId() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getAgencyId().hashCode();
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

    canSetAgencyId = false;
    canSetId = false;
    return cachedHashCode;
  }

  public void delete()
  {
    fareRules.clear();
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "agencyId" + ":" + getAgencyId()+ "," +
            "price" + ":" + getPrice()+ "," +
            "currency" + ":" + getCurrency()+ "," +
            "paymentMethod" + ":" + getPaymentMethod()+ "," +
            "transfers" + ":" + getTransfers()+ "," +
            "transferDuration" + ":" + getTransferDuration()+ "]";
  }
}