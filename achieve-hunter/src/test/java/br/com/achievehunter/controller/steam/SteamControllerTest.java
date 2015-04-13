package br.com.achievehunter.controller.steam;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.achievehunter.core.steam.steamcompenser.SteamCompenserFacade;
import br.com.achievehunter.core.steam.webapi.SteamWebApiService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/applicationContext.xml"})
@WebAppConfiguration
public class SteamControllerTest {

	private MockMvc mvc;
	private SteamController controller;
	private SteamCompenserFacade steamFacade;
	private SteamWebApiService steamService;
	
	@Before
	public void setUp() {
		controller = new SteamController();
		steamFacade = mock(SteamCompenserFacade.class);
		steamService = mock(SteamWebApiService.class);
		ReflectionTestUtils.setField(controller, "steamService", steamService);
		ReflectionTestUtils.setField(controller, "steamFacade", steamFacade);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void quandoBuscaPerfil() throws Exception {
		mvc.perform(get(SteamController.BASE_URL + "/load-profile/{steamId}", 1L))
			.andExpect(status().isOk());
		
		verify(steamFacade, times(1)).findSteamProfileBySteamId64(Mockito.anyLong());
	}
	
	@Test
	public void quandoBuscaJogo() throws Exception {
		mvc.perform(get(SteamController.BASE_URL + "/load-game/{steamId}/{appId}", Mockito.anyLong(), Mockito.anyInt()))
			.andExpect(status().isOk());
		
		verify(steamFacade, times(1)).findGameByUserIdAndGameId(Mockito.anyLong(), Mockito.anyInt());
	}
	
	@Test
	public void quandoBuscaAmigos() throws Exception {
		mvc.perform(get(SteamController.BASE_URL + "/load-friends/{steamId}", Mockito.anyLong()))
			.andExpect(status().isOk());
		
		verify(steamService, times(1)).findFriendsBySteamId(Mockito.anyLong());
	}
	
}
