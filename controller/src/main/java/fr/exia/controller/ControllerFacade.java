package fr.exia.controller;

import java.util.ArrayList;

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
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 * 
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @author Yoan BIQUET yoan.biquet@viacesi.fr 
 * @version 1.0
 */

public class ControllerFacade {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final ModelFacade model;

    /** Last action performed. */
    private Action lastAction = Action.MOVE_UP;
    
    /** The hasShot attribute. */
    private boolean shot = false;
    
    
    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
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
    	new SplashWindow(model, this); // Launch SplashWindow which launch the Dialog and the GameWindow
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
    	
    	for (Pawn obstacle : map.getPawns())){
    		if (obstacle.getX() == x && obstacle.getY() == y && !(obstacle instanceof Player)) {
    			isAPawn = true;
    			pawn = obstacle;
    		}
    	}
    	
    	if (isAPawn== true) {
    		if (pawn instanceof Wall || pawn instanceof Corner) {
    			if (pl instance of Spell) {
    				changeDirection((Spell) pl);
    			}
    		} else if (pawn instanceof Monster) {
    			if (pl instanceof Spell) {
    				setShot(false);
    				pickup(pawn);
    				pickup(pl);
    			} else if (pl instanceof Player) {
    				System.out.println("Game over: you died !");
    				die();
    			}
    		} else if (pawn instanceof Door) {
    			if (pl instanceof Spell) {
    				changeDirection((Spell) pl);
    			} else {
    				Door door = (Door) pawn;
    				
    				if (door.getState().equals(State.CLOSED)) {
    					System.out.println("Game over: you died !");
    					die();
    				} else {
    					System.out.println("Congrats you won the level !");
    					die();
    				}
    			}
    		} else if (pawn instanceof Energy) {
    			if (pl instanceof Player) {
    				pickup(pawn);
    				move(pl, x, y);
    				for (Pawn pwns: map.getPawns()) {
    					if (pwns instanceof Door) {
    						Door d = (Door) pwns;
    						d.setState(State.OPENED);
    					}
    				}
    			}
    			if (pl instanceof Spell) {
    				changeDirection((Spell) pl);
    			}
    		}  else if (pawn instanceof Loot) {
    			if (pl instanceof Player) {
    				pickup(pawn);
    				move(pl, x, y);
    			}
    			if (pl instanceof Spell) {
    				changeDirection((Spell) pl);
    			}
    		} else if (pawn instanceof Player) {
                if(pl instanceof Spell) {
                    pickup(pl);
                    setShot(false);
                }
    	}
    }
    
    
    public IModel setModel(IModel) {
    	return this.model = model;
    }
    
    public void Check_type(pawn test) {
    	if (test == instanceof Wall) {
    		Undo(move);
    	}
    	
    	if (test == instanceof Monster) {
    		Death();
    	}
    	
    	if (test == instanceof Spell) {
    		PickSpell();
    	}
    	
    	if (test == instanceof Door) {
    		Death();
    	}
    	
    	if (test == instanceof Energy) {
    		Key();
    	}
    	
    	if (test == instanceof Loot) {
    		Loot();
    	}
    	
    	if (test == instanceof Corner) {
    		Undo(move);
    	}
    }
    public void Move(String Direction) {
    	this.move = Direction;
    }	/* loop for map.x =! lorann.x, case pour les hitbox, if map = instance of [object_name]	*/
    		for (Pawn test : Pawn_receive)
    			if (move = "LEFT") {
    	    		Lorann.x -= 32;
    	    	} else if (move = "RIGHT") {
    	    		Lorann.x += 32;
    	    	} else if (move = "UP") {
    	    		Lorann.y += 32;
    	    	} else (move = "DOWN") {
    	    		Lorann.y -= 32;
    	    	}
    	    		if (test.x == Lorann.x) {
    				Check_type(test, move);
    			}

    			
    	
    public void Undo(move) {
    	if (move = "LEFT") {
    		Lorann.x += 32;
    	} else if (move = "RIGHT") {
    		Lorann.x -= 32;
    	} else if (move = "UP") {
    		Lorann.y -= 32;
    	} else (move = "DOWN") {
    		Lorann.y += 32;
    }
    	/* Check Lorann_pos() {
    		if (lorann.x == bourse.x){ 
			return score;
    		}
    	}
    	
    	if (lorann.x == Monster.x || lorann.y == Monster.y) {
    		move = "DEATH"; //false ?
    		System.out.println("Vous êtes mort");
    		
    	} else if (lorann.x == Wall.x || lorann.y == Wall.y) {
    		move = false;
    	} else if (lorann.x == bourse.x || lorann.y == bourse.y) { 
    		move = true;
    		score += bourse.value;
    	}else{
    		move = true;
    		//return move;
    		}
		return move;	*/