package fr.exia.game.controller;

import java.util.ArrayList;

import fr.exia.game.contract.IController;
import fr.exia.game.contract.IModel;
import fr.exia.game.contract.IView;
import fr.exia.game.model.Corner;
import fr.exia.game.model.Door;
import fr.exia.game.model.Energy;
import fr.exia.game.model.Loot;
import fr.exia.game.model.Map;
import fr.exia.game.model.ModelFacade;
import fr.exia.game.model.Monster;
import fr.exia.game.model.Pawn;
import fr.exia.game.model.Player;
import fr.exia.game.model.Spell;
import fr.exia.game.model.Wall;
import fr.exia.game.model.enums.Action;
import fr.exia.game.model.enums.Direction;
import fr.exia.game.model.enums.State;
import fr.exia.game.view.SplashWindow;

/**
 * <h1>The Class ControllerFacade.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @author Yoan BIQUET yoan.biquet@viacesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private final ModelFacade model;
	
	/** Last action performed. */
	private Action lastAction = Action.MOVE_UP;
	
	/** The hasShot attribute. */
	private boolean shot = false;
	
	/** The score. */
	private int score;

	/**
	 * Instantiates a new controller facade.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	public ControllerFacade(final IModel model) {
		super();
		this.model = (ModelFacade) model;
		start();
	}
	
	/**
	 * Instantiates a new controller facade.
	 */
	public ControllerFacade() {
		view = null;
		model = null;
	}

	/**
	 * Start the game.
	 */
	public void start() {
		new SplashWindow(model, this); // Launch SplashWindow wich launch the Dialog and the GameWindow
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public IView getView() {
		return this.view;
	}
	
	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public IModel getModel() {
		return this.model;
	}

	/**
	 * Check if the move is possible and what occurs.
	 * 
	 * @param map
	 * 			the level map
	 * @param pl
	 * 			the pawn that interact
	 * @param x
	 * 			the x coordinate
	 * @param y
	 * 			the y coordinate
	 */
	public void checkForMove(Map map, Pawn pl, int x, int y) {
		boolean isAPawn = false;
		Pawn pawn = null;

		for (Pawn obstacle : map.getPawns()) {
			if (obstacle.getX() == x && obstacle.getY() == y && !(obstacle instanceof Player)) {
				isAPawn = true;
				pawn = obstacle;
			}
		}

		if (isAPawn == true) {
			if (pawn instanceof Wall || pawn instanceof Corner) {
				if(pl instanceof Spell) {
					changeDirection((Spell) pl);
				}
			} else if (pawn instanceof Monster) {
				if(pl instanceof Spell) {
					setShot(false);
					pickup(pawn);
					pickup(pl);
				} else if(pl instanceof Player) {
					System.out.println("Game over: you died!");
					die();
				}
			} else if (pawn instanceof Door) {
				if(pl instanceof Spell) {
					changeDirection((Spell) pl);
				} else {
					Door door = (Door) pawn;

					if (door.getState().equals(State.CLOSED)) {
						System.out.println("Game over: you died!");
						die();
					} else {
						System.out.println("Congrats you won the level!");
						die();
					}
				}
			} else if (pawn instanceof Energy) {
				if(pl instanceof Player) {
					pickup(pawn);
					move(pl, x, y);
					addScore(80000);
					for (Pawn pwns : map.getPawns()) {
						if(pwns instanceof Door) {
							Door d = (Door) pwns;
							d.setState(State.OPENED);
						}
					}
				}
				if(pl instanceof Spell) {
					changeDirection((Spell) pl);
				}
			} else if (pawn instanceof Loot) {
				if(pl instanceof Player) {
					pickup(pawn);
					move(pl, x, y);
					addScore(25000);
				}
				if(pl instanceof Spell) {
					changeDirection((Spell) pl);
				}
			} else if (pawn instanceof Player) {
				if(pl instanceof Spell) {
					pickup(pl);
					setShot(false);
				}
			} else if (pawn instanceof Spell) {
				if(pl instanceof Player) {
					pickup(pawn);
					move(pl, x, y);
					setShot(false);
				} else {
					pickup(pl);
					setShot(false);
				}
			}
		} else {
			move(pl, x, y);
		}
	}
	
	/**
	 * Inverts the spell direction.
	 * 
	 * @param s
	 * 			the spell
	 */
	public void changeDirection(Spell s) {
		if(s.getDirection().equals(Direction.H_LEFT)) {
			s.setDirection(Direction.H_RIGHT);
		} else if(s.getDirection().equals(Direction.H_RIGHT)) {
			s.setDirection(Direction.H_LEFT);
		} else if(s.getDirection().equals(Direction.V_DOWN)) {
			s.setDirection(Direction.V_UP);
		} else if(s.getDirection().equals(Direction.V_UP)) {
			s.setDirection(Direction.V_DOWN);
		}
	}

	/**
	 * Changes pawn coordinates.
	 * 
	 * @param p
	 * 			the pawn
	 * @param x
	 * 			the new x coordinate
	 * @param y
	 * 			the new y coordinate
	 */
	public void move(Pawn p, int x, int y) {
		p.setX(x);
		p.setY(y);
	}

	/**
	 * Remove a pawn from the map.
	 * 
	 * @param p
	 * 			the pawn
	 */
	public void pickup(Pawn p) {
		p.destroy();
		setShot(false);
	}
	
	/**
	 * Kills the program.
	 */
	public void die() {
		System.exit(0);
	}
	
	/**
	 * Gets the score.
	 * 
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Adds to the score.
	 * 
	 * @param score
	 * 			the amount to add
	 */
	public void addScore(int score) {
		this.score += score;
	}

	/**
	 * Controls the game by performing actions.
	 * 
	 * @param act
	 * 			the action
	 * @param map
	 * 			the map
	 */
	public void play(Action act, Map map) {
		ArrayList<Pawn> pawnsToAdd = new ArrayList<Pawn>();
		
		for (Pawn pawn : map.getPawns()) {
			if (pawn instanceof Player) {
				Player pl = (Player) pawn;

				if (act == Action.MOVE_LEFT) {
					checkForMove(map, pl, pl.getX() - 32, pl.getY());
					lastAction = Action.MOVE_LEFT;
				} else if (act == Action.MOVE_RIGHT) {
					checkForMove(map, pl, pl.getX() + 32, pl.getY());
					lastAction = Action.MOVE_RIGHT;
				} else if (act == Action.MOVE_UP) {
					checkForMove(map, pl, pl.getX(), pl.getY() - 32);
					lastAction = Action.MOVE_UP;
				} else if (act == Action.MOVE_DOWN) {
					checkForMove(map, pl, pl.getX(), pl.getY() + 32);
					lastAction = Action.MOVE_DOWN;
				} else if (act == Action.SHOOT) {
					//if(hasShot == true) return;
					if(lastAction.equals(Action.MOVE_LEFT)) {
						pawnsToAdd.add(new Spell(pl.getX()-32, pl.getY(), Direction.H_LEFT));
					} else if(lastAction.equals(Action.MOVE_RIGHT)) {
						pawnsToAdd.add(new Spell(pl.getX()-32, pl.getY(), Direction.H_RIGHT));
					} else if(lastAction.equals(Action.MOVE_UP)) {
						pawnsToAdd.add(new Spell(pl.getX(), pl.getY()-32, Direction.V_UP));
					} else if(lastAction.equals(Action.MOVE_DOWN)) {
						pawnsToAdd.add(new Spell(pl.getX(), pl.getY()+32, Direction.V_DOWN));
					}
					setShot(true);
				}
			}
		}
		map.getPawns().addAll(pawnsToAdd);
	}

	/**
	 * Gets the shot attribute.
	 * 
	 * @return the hasShot
	 */
	public boolean hasShot() {
		return shot;
	}

	/**
	 * Sets the shot attribute.
	 * 
	 * @param hasShot
	 * 			the hasShot to set
	 */
	public void setShot(boolean shot) {
		this.shot = shot;
	}
}
