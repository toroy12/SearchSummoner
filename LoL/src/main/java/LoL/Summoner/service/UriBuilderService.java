package LoL.Summoner.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UriBuilderService {

	private static final String LOL_SUMMONER_SEARCH_URL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";

	public URI buildUriByNameSearch(String name) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(LOL_SUMMONER_SEARCH_URL);

		uriBuilder.path(name);

		URI uri = uriBuilder.build().encode().toUri();
		log.info("[UriBuilderService buildUriByNameSearch] name: {}, uri: {}", name, uri);

		return uri;
	}
}
