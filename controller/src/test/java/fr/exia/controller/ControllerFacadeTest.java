/**
 * 
 */
package fr.exia.controller;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Biquet Yoan
 *
 */
public class ControllerFacadeTest {
	
	private ControllerFacadeTest controller;
	private IView view;
	private IModel model;
	/**
	 * Test method for {@link fr.exia.controller.ControllerFacade#ControllerFacade(IView, IModel)}.
	 */
	@Test
	public void testBuildViewAndModel() {
		assertTrue(this.controller.view(true) instanceof IView && this.controller.model(true) instanceof IModel); // TODO
	}

	/**
	 * Test method for {@link fr.exia.controller.ControllerFacade#start()}.
	 */
	/*@Test
	public void testStart() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link fr.exia.controller.ControllerFacade#getView()}.
	 */
	@Test
	public void testGetView() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link fr.exia.controller.ControllerFacade#setView()}.
	 */
	@Test
	public void testSetView() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link fr.exia.controller.ControllerFacade#getModel()}.
	 */
	@Test
	public void testGetModel() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link fr.exia.controller.ControllerFacade#setModel()}.
	 */
	@Test
	public void testSetModel() {
		fail("Not yet implemented"); // TODO
	}*/

	/**
	 * Test method for {@link fr.exia.controller.ControllerFacade#Check_type(pawn)}.
	 */
	@Test
	public void testCheck_type() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link fr.exia.controller.ControllerFacade#Move(java.lang.String)}.
	 */
	@Test
	public void testMove() {
		fail("Not yet implemented"); // TODO
	}

}
