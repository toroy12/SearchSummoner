package LoL.Summoner.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import LoL.Search.service.UriBuilderService;
import LoL.Summoner.dto.SummonerDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SummonerService {
	
	private final RestTemplate restTemplate;
	private final UriBuilderService uriBuilderService;

	@Value("${RIOT.API.KEY}")
	private String riotApiKey;

	public SummonerDTO requestPuuidSearch(String name) {

		if (ObjectUtils.isEmpty(name))
			return null;

		URI uri = uriBuilderService.buildUriByNameSearch(name);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Riot-Token", riotApiKey);
		HttpEntity httpEntity = new HttpEntity<>(headers);

		return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, SummonerDTO.class).getBody();

	}
}
