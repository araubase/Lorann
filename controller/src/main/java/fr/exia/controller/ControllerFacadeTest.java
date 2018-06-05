/**
 * 
 */
package fr.exia.game.controller;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.exia.game.model.Spell;
import fr.exia.game.model.enums.Direction;

/**
 * @author Yoan BIQUET yoan.biquet@viacesi.fr
 */
public class ControllerFacadeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link fr.exia.game.controller.ControllerFacade#getView()}.
	 */
	@Test
	public void testGetView() {
		ControllerFacade controller = new ControllerFacade();
		assertEquals(null, controller.getView());
	}

	/**
	 * Test method for {@link fr.exia.game.controller.ControllerFacade#getModel()}.
	 */
	@Test
	public void testGetModel() {
		ControllerFacade controller = new ControllerFacade();
		asse(null, controller.getModel());
	}

	/**
	 * Test method for {@link fr.exia.game.controller.ControllerFacade#changeDirection(fr.exia.game.model.Spell)}.
	 */
	@Test
	public void testChangeDirection() {
		Spell s = new Spell(0, 0, Direction.H_LEFT);
		ControllerFacade controller = new ControllerFacade();
		controller.changeDirection(s);
		assertEquals(Direction.H_RIGHT, s.getDirection());
	}

	/**
	 * Test method for {@link fr.exia.game.controller.ControllerFacade#getScore()}.
	 */
	@Test
	public void testGetScore() {
		ControllerFacade controller = new ControllerFacade();
		assertEquals(0, controller.getScore());
	}

	/**
	 * Test method for {@link fr.exia.game.controller.ControllerFacade#addScore(int)}.
	 */
	@Test
	public void testAddScore() {
		ControllerFacade controller = new ControllerFacade();
		controller.addScore(10);
		assertEquals(10, controller.getScore());
	}

	/**
	 * Test method for {@link fr.exia.game.controller.ControllerFacade#hasShot()}.
	 */
	@Test
	public void testHasShot() {
		ControllerFacade controller = new ControllerFacade();
		assertEquals(false, controller.hasShot());
	}

	/**
	 * Test method for {@link fr.exia.game.controller.ControllerFacade#setShot(boolean)}.
	 */
	@Test
	public void testSetShot() {
		ControllerFacade controller = new ControllerFacade();
		controller.setShot(true);
		assertEquals(true, controller.hasShot());
	}

}
