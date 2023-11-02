package LoL.Summoner.service;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import LoL.Summoner.dto.SummonerDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SummonerService {
	
	private final RestTemplate restTemplate;
	private final UriBuilderService uriBuilderService;

	private static final String riotApiKey = "RGAPI-08a13a44-4603-4f4a-8eee-a7bfe578c24d";

	public SummonerDTO requestPuuidSearch(String name) {

		if (ObjectUtils.isEmpty(name))
			return null;

		URI uri = uriBuilderService.buildUriByNameSearch(name);
		
		if(uri == null) {
			return null;
		}

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Riot-Token", riotApiKey);
		HttpEntity httpEntity = new HttpEntity<>(headers);

		return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, SummonerDTO.class).getBody();

	}
}
