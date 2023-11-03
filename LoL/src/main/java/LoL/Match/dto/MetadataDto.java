package LoL.Match.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor	
public class MetadataDto {

	private String dataVersion;
	private String matchId;
	private List<String> participants;
}
