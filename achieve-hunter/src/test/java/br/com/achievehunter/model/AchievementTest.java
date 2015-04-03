package br.com.achievehunter.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.achievehunter.model.steam.Achievement;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AchievementTest {
	
	private Achievement achievement;
	
	@Before
	public void setUp() {
		achievement = new Achievement();
	}
	
	@Test
	public void verificaCamposIgnoradosAoSerializarAchievementParaJson() throws JsonParseException, IOException {
	    ObjectMapper mapper = new ObjectMapper();
	    
	    String modelAsString = mapper.writeValueAsString(achievement);
	    
	    assertThat(modelAsString, not(containsString("iconUnlockedUrl")));
	    assertThat(modelAsString, not(containsString("iconLockedUrl")));
	    assertThat(modelAsString, not(containsString("dateUnlocked")));
	    assertThat(modelAsString, containsString("icon"));
	    assertThat(modelAsString, containsString("date"));
	}
	
	
}
