package com.websystique.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springmvc.model.CampaignChannelData;
import com.websystique.springmvc.model.CampaignData;
import com.websystique.springmvc.model.DMPTag;
import com.websystique.springmvc.service.ReportService;

//Application code - b7

@RestController
public class ReportRestController {

	
	//Controller receives data from Service API and generates a JSON feed to feed into visualisation component.
	//API format <Report/Reportcode/Daterange/CampaignId, as campaignId is specified after daterange, selected campaign is picked and campaign report is shown channel wise.	
	
	
	@Autowired
	ReportService reportService;  //Service which will do all data retrieval/manipulation work

	//-------------------Retrieve Report with Id--------------------------------------------------------
	@CrossOrigin
	@RequestMapping(value = "/campaignChannelDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value = "/campaignChannelDetails/{campaign_id}/{channel_type}/{access_token}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<CampaignChannelData> getReport(@PathVariable("campaign_id") String campaignId,@PathVariable("channel_type") String channelType,@PathVariable("access_token") String accessToken) {
		//System.out.println("Fetching Report with id " + id);
	public ResponseEntity<CampaignChannelData> getCampaignChannelDetails(@RequestParam("campaign_id") String campaignId,@RequestParam("channel_type") String channelType,@RequestParam("access_token") String accessToken) {	
		
		CampaignChannelData obj = reportService.getcampaignChannelData(campaignId,channelType,accessToken);
		if (obj == null) {
		//	System.out.println("Report with id " + id + " not found");
			return new ResponseEntity<CampaignChannelData>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CampaignChannelData>(obj, HttpStatus.OK);
	}

	//This API gives list of campaignIds active in that date range.
	@CrossOrigin
	@RequestMapping(value = "/getdmpTag", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DMPTag> getDmpTagdata(@RequestParam("campaign_id") String campaignId) {
		
		DMPTag dmpTag = reportService.getcampaignChannelDMPTag(campaignId);
		if (dmpTag == null){
		   
			return new ResponseEntity<DMPTag>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DMPTag>(dmpTag, HttpStatus.OK);
}
	
	@CrossOrigin
	@RequestMapping(value = "/getChannelCampaignId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CampaignData> getChannelCampaignId(@RequestParam("channel_type") String channelType,@RequestParam("access_token") String accessToken) {
		
		CampaignData campaigndata = reportService.getChannelCampaignId(channelType,accessToken);
		if (campaigndata  == null){
		   
			return new ResponseEntity<CampaignData>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CampaignData>(campaigndata, HttpStatus.OK);
}
	
	
	

}
