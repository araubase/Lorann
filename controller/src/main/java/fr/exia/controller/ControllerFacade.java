package fr.exia.controller;

import java.sql.SQLException;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Yoan BIQUET yoan.biquet@viacesi.fr 
 * @version 2.0
 */

public class ControllerFacade implements IController {

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
    
    public Move (Loran.x, Loran.y, move) {
    	switch
    	
    	case move = "RIGHT"
    		Loran.x += 32;
    	case move = "LEFT"
    		Loran.x -= 32;
    	case move = "UP"
    		Loran.y += 32;
    	case move = "DOWN";
    		Loran.y -= 32;
    	if Loran.x = Enemy.x || Loran.y = enemy.y {
    		move = "DEATH";
    		System.out.println("Vous êtes mort");
    		//lives -=1;
    	} else if Loran.x = Wall.x || Loran.y = Wall.y {
    		move = false;
    	} else if Loran.x = Bourse.x || Loran.y = Bourse.y {
    		move = true;
    		score += bourse.value;
    	}else{
    		move = true;
    		return move;
    		}
      
    }
}

