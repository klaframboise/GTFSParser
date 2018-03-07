/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package com.kevinlaframboise.gtfsparser.model;
import java.sql.Date;

// line 167 "../../../../GTFSModel.ump"
// line 242 "../../../../GTFSModel.ump"
public class FeedInfo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FeedInfo Attributes
  private String publisherName;
  private String publisherUrl;
  private String lang;
  private Date startDate;
  private Date endDate;
  private String version;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FeedInfo(String aPublisherName, String aPublisherUrl, String aLang)
  {
    publisherName = aPublisherName;
    publisherUrl = aPublisherUrl;
    lang = aLang;
    startDate = null;
    endDate = null;
    version = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPublisherName(String aPublisherName)
  {
    boolean wasSet = false;
    publisherName = aPublisherName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPublisherUrl(String aPublisherUrl)
  {
    boolean wasSet = false;
    publisherUrl = aPublisherUrl;
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

  public boolean setVersion(String aVersion)
  {
    boolean wasSet = false;
    version = aVersion;
    wasSet = true;
    return wasSet;
  }

  public String getPublisherName()
  {
    return publisherName;
  }

  public String getPublisherUrl()
  {
    return publisherUrl;
  }

  public String getLang()
  {
    return lang;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public Date getEndDate()
  {
    return endDate;
  }

  public String getVersion()
  {
    return version;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "publisherName" + ":" + getPublisherName()+ "," +
            "publisherUrl" + ":" + getPublisherUrl()+ "," +
            "lang" + ":" + getLang()+ "," +
            "version" + ":" + getVersion()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startDate" + "=" + (getStartDate() != null ? !getStartDate().equals(this)  ? getStartDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endDate" + "=" + (getEndDate() != null ? !getEndDate().equals(this)  ? getEndDate().toString().replaceAll("  ","    ") : "this" : "null");
  }
}