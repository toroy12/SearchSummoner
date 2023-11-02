package LoL.Match.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectivesDto {
	
	private ObjectiveDto baron;
	private ObjectiveDto champion;
	private ObjectiveDto dragon;
	private ObjectiveDto inhibitor;
	private ObjectiveDto riftHerald;
	private ObjectiveDto tower;

}
