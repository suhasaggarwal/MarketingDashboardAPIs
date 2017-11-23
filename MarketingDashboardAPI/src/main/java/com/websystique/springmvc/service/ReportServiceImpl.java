package com.websystique.springmvc.service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.CampaignChannelData;
import com.websystique.springmvc.model.CampaignData;
import com.websystique.springmvc.model.DMPTag;
import com.websystique.springmvc.model.Reports;


//Benchmarking data for channel wise performance corresponding to specific campaignId 



@Service("reportService")
@Transactional
public class ReportServiceImpl implements ReportService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	ReportDAOImpl repDAO = ReportDAOImpl.getInstance();
	
	List<Reports> report= new ArrayList<Reports>();
	
	List<String> campaignIds = new ArrayList<String>();
	
    String campaignId = null;
	
    public List<Reports> extractReports(long id,String dateRange,String campaignId){
	
        String [] dateInterval = dateRange.split(",");
    	
    	
    	if(id == 1){
    	 	report=repDAO.FetchImpressionsData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 2){
    	 	report=repDAO.FetchClicksData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 3){
    	 	report=repDAO.FetchConversionsData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 4){
    	 	report=repDAO.FetchCostData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 5){
    	 	
    		report=repDAO.FetchAudienceSegmentImpData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 6){
    	 	report=repDAO.FetchCityImpData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 7){
    	 	report=repDAO.FetchDeviceImpData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
        
    	if(id == 8){
    	 	report=repDAO.FetchOSImpData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
       
    

    	if(id == 17){
    	 	report=repDAO.FetchReachData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	
    	
    	if(id == 19){
    	 	report=repDAO.FetchAgeImpData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
        
    	if(id == 20){
    	 	report=repDAO.FetchGenderImpData(dateInterval[0], dateInterval[1], campaignId);
		    return report;
    	}
    	  	
    	
    	
    	return report;
    

    }
		
//Give List of campaignIds corresponding to date range
    
    public List<String> extractCampaignIds(long id,String dateRange){
      
    	  String [] dateInterval = dateRange.split(",");

          if( id == 16){
           campaignIds = repDAO.extractCampaignIds(dateInterval[0], dateInterval[1]);
           return campaignIds;
           
          }
    
          return campaignIds;
    
    
    }

    
    
    public CampaignChannelData getcampaignChannelData(String campaignId,String channelType,String accessToken) {

    	CampaignChannelData ccdData = new CampaignChannelData();
	    
    	
    	
    	if(channelType.toLowerCase().equals("facebook")){
    		
    		String advertype = "NewsFeed";
    		String startDate = "2017-11-01"; 
    	    String endDate = "2017-12-15";
    	    String kpi = "";
    	    String target = "";
    	    String bid_min = "1000";
    	    String bid_max = "200000";
    	    String channel_budget = "500000";
    	    String channel_status = "true";
    	    
    	   
    	    ccdData.setAdvertType(advertype);
    		ccdData.setStartDate(startDate);
    		ccdData.setEndDate(endDate);
    	    ccdData.setkPI(kpi);
    	    ccdData.setTarget(target);
    	    ccdData.setBidmin(bid_min);
    	    ccdData.setBidmax(bid_max);
    	    ccdData.setChannelBudget(channel_budget);
    	    ccdData.setChannelStatus(channel_status);
    	
    	}
    	
        if(channelType.toLowerCase().equals("dbm")){
    		
        	String advertype = "LineItem";
    		String startDate = "2017-11-02"; 
    	    String endDate = "2017-12-17";
    	    String kpi = "";
    	    String target = "";
    	    String bid_min = "2000";
    	    String bid_max = "300000";
    	    String channel_budget = "700000";
    	    String channel_status = "true";
    	    
    	   
    	    ccdData.setAdvertType(advertype);
    		ccdData.setStartDate(startDate);
    		ccdData.setEndDate(endDate);
    	    ccdData.setkPI(kpi);
    	    ccdData.setTarget(target);
    	    ccdData.setBidmin(bid_min);
    	    ccdData.setBidmax(bid_max);
    	    ccdData.setChannelBudget(channel_budget);
    	    ccdData.setChannelStatus(channel_status);
        	
        	
        	
        	
    	}
    	
        if(channelType.toLowerCase().equals("adwords")){
    		
        	String advertype = "Adwords";
    		String startDate = "2017-11-05"; 
    	    String endDate = "2017-12-22";
    	    String kpi = "";
    	    String target = "";
    	    String bid_min = "3000";
    	    String bid_max = "500000";
    	    String channel_budget = "900000";
    	    String channel_status = "true";
    	    
    	  
    	    
    	    ccdData.setAdvertType(advertype);
    		ccdData.setStartDate(startDate);
    		ccdData.setEndDate(endDate);
    	    ccdData.setkPI(kpi);
    	    ccdData.setTarget(target);
    	    ccdData.setBidmin(bid_min);
    	    ccdData.setBidmax(bid_max);
    	    ccdData.setChannelBudget(channel_budget);
    	    ccdData.setChannelStatus(channel_status);
        	
        	
        	
    	}
    	
        if(channelType.toLowerCase().equals("lightning")){
    		
    		
        	String advertype = "Lightning";
    		String startDate = "2017-11-07"; 
    	    String endDate = "2017-12-27";
    	    String kpi = "";
    	    String target = "";
    	    String bid_min = "6000";
    	    String bid_max = "600000";
    	    String channel_budget = "600000";
    	    String channel_status = "true";
    	    
    	    
    	    ccdData.setAdvertType(advertype);
    		ccdData.setStartDate(startDate);
    		ccdData.setEndDate(endDate);
    	    ccdData.setkPI(kpi);
    	    ccdData.setTarget(target);
    	    ccdData.setBidmin(bid_min);
    	    ccdData.setBidmax(bid_max);
    	    ccdData.setChannelBudget(channel_budget);
    	    ccdData.setChannelStatus(channel_status);
        	
        	
        	
    	}
    
          return ccdData;
    
    }

    
    
    
    
    public DMPTag getcampaignChannelDMPTag(String campaignId) {

    	DMPTag tag = new DMPTag();
    	
    //	String startTag  = "------------------------Start of Tag---------------------------------------------------------------\n\n";
        String middleScript = "<script language=\"JavaScript\"> var STD=\"101\"; var ISD=\"102\"; var pn=\"NS\"; var cn=\""+campaignId+"\""+";var tagparameters = \"ReplaceValue\" </script>"+ "<script src=\"https://dcpub.cuberoot.co/dcode2/dmpbasedc.js\"></script>";
    //    String endTag  = "\n\n------------------------End of Tag---------------------------------------------------------------\n\n";
               
                
        tag.setTag(middleScript);       
       
        return tag; 
    
    }

    public CampaignData getChannelCampaignId(String channelType,String accessToken) {

    	
    	CampaignData data = new CampaignData();
    	
    	if(channelType.toLowerCase().equals("facebook"))
    			{
    		
    		     data.setCampaignId("61001");
    		
    			}

        if(channelType.toLowerCase().equals("adwords"))
        		{
        	      data.setCampaignId("78001");
        	 	}
        		
        if(channelType.toLowerCase().equals("dbm"))		
        		{
        	
        	      data.setCampaignId("89001");
        		}
        
        if(channelType.toLowerCase().equals("lightning"))		
		{
	
	      data.setCampaignId("99001");
		}
        
        
        
          return data;
    
    
    
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
