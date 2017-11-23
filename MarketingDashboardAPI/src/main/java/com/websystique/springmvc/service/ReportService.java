package com.websystique.springmvc.service;



import java.util.List;

import com.websystique.springmvc.model.CampaignChannelData;
import com.websystique.springmvc.model.CampaignData;
import com.websystique.springmvc.model.DMPTag;
import com.websystique.springmvc.model.Reports;



public interface ReportService {
	
	List<Reports> extractReports(long id, String dateRange, String campaignId);
	 
	List<String> extractCampaignIds(long id,String dateRange);

    CampaignChannelData getcampaignChannelData(String campaignId,String channelType,String accessToken);
	
	DMPTag getcampaignChannelDMPTag(String campaignId);
	
    CampaignData getChannelCampaignId(String channelType,String accessToken);


}
