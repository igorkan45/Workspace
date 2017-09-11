package by.htp.citygame.test;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import by.htp.citygame.Player;

public class NewTest {

	Player plr1 = new Player();
	Player plr2 = new Player();

	@Test
	public void testTheWordIsNotNull() {
		assertNotNull(plr1.sayWord());
		assertNotNull(plr2.sayWord());
	}
}
