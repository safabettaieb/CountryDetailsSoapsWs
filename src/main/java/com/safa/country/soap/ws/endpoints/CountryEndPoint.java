package com.safa.country.soap.ws.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.safa.country.soap.ws.countrydetails.CountryDetailsRequest;
import com.safa.country.soap.ws.countrydetails.GetCountryResponse;
import com.safa.country.soap.ws.services.CountryService;

@Endpoint
public class CountryEndPoint {
	
	public final String NAMESPACE="http://www.safa.com/country/soap/ws/countryDetails" ;
	
	@Autowired
	private CountryService service;
	
	@PayloadRoot(namespace = NAMESPACE , localPart = "countryDetailsRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload CountryDetailsRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(service.findCountry(request.getCountryName()));
		return response;
		
	}
	
	
	

}
