package hirondelle.movies.exit;

import hirondelle.movies.edit.MovieDAO;
import hirondelle.movies.util.Util;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

/** 
  Save changes and close the application.
  
  <ul>   <li>persist the changes the user has made during this session   <li>close the main window
   <li>shut down the JVM   </ul>
*/
public final class ExitAction extends AbstractAction {
  
  /** Constructor. */
  public ExitAction(){
    super("Exit", null);
    putValue(SHORT_DESCRIPTION, "Exit the application"); 
    putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
    //mnemonic activates only when alt is pressed and held down
    putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_X) );    
  }
  
  /** Save all edits and exit the app. */
  @Override public void actionPerformed(ActionEvent aActionEvent) {
    fLogger.config("Persisting data.");
    MovieDAO dao = new MovieDAO();
    dao.shutdown();
    fLogger.config("Exiting the application.");
    System.exit(0);
  }
  
  private static final Logger fLogger = Util.getLogger(ExitAction.class);
}
