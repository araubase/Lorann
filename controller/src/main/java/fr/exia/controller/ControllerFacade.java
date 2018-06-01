package fr.exia.controller;

import java.sql.SQLException;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Yoan BIQUET yoan.biquet@viacesi.fr 
 * @version 2.0
 */

public class ControllerFacade implements IController {

	String move;
    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;

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
        this.model = model;
    }
    
    /**
     * Start the game.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
        this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());
        
        //splashWindow
        // lancer la vue qui demande le niveau
    }
    
    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }
    
    public IView setView(IView) {
    	return this.view= view;
    }
    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
    
    public IModel setModel(IModel) {
    	return this.model = model;
    }
    
    public void Check_type(pawn test) {
    	if (test == instanceof Wall) {
    		
    	}
    	
    	if (test == instanceof Monster) {
    		
    	}
    	
    	if (test == instanceof Spell) {
    		
    	}
    	
    	if (test == instanceof Door) {
    		
    	}
    	
    	if (test == instanceof Energy) {
    		
    	}
    	
    	if (test == instanceof Loot) {
    		
    	}
    	
    	if (test == instanceof Corner) {
    		
    	}
    }
    public void Move(String Direction) {
    	this.move = Direction;
    }	/* loop for map.x =! lorann.x, case pour les hitbox, if map = instance of [object_name]	*/
    		for (Pawn test : Pawn_receive)
    			
    			if (test.x == Lorann.x) {
    				Check_type(test);
    			}
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