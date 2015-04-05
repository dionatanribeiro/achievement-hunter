package br.com.achievehunter.core.steam.webapi;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.base.Strings;

public class SteamWebApiArgsTest {
	
	@Test
	public void verificaQuandoMontaParametrosDaUrl() {
		//Act
		String parametros = SteamWebApiArgs.createParam().addSteamId(76561198003170021L).addApiKey().addAppId(12345).addFormatJson().getArgs();
		
		//Assert
		assertThat("Parametros retornados não devem ser nulos ou vazios", !Strings.isNullOrEmpty(parametros), is(true));
	}
	
}
