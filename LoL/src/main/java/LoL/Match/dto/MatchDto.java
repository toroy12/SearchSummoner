package LoL.Match.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor	
public class MatchDto {
	
	private MetadataDto metadata;
	private InfoDto info;

}
