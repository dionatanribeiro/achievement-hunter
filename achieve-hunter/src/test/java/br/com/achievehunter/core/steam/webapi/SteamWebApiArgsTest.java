package br.com.achievehunter.core.steam.webapi;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

import com.google.common.base.Strings;

public class SteamWebApiArgsTest {
	
	@Test
	public void verificaQuandoMontaParametrosDaUrl() {
		//Act
		String parametros = SteamWebApiArgs.createParam().addSteamId(76561198003170021L).addApiKey().addAppId(12345).addFormatJson().getArgs();
		
		//Assert
		assertThat("Parametros retornados n�o devem ser nulos ou vazios", !Strings.isNullOrEmpty(parametros), is(true));
	}
	
	@Test
	public void verificaQuandoMontaParametrosComListaDeSteamIds() {
		//Act
		String parametros = SteamWebApiArgs.createParam().addSteamIds(Arrays.asList(123L, 456L, 789L)).getArgs();
		
		//Assert
		assertThat("Parametro deve conter v�rgula", parametros.contains(","), is(true));
	}
	
}
