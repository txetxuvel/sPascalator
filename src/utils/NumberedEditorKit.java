package utils;

//import javax.swing.text.StyledEditorKit;
import javax.swing.text.ViewFactory;

class NumberedEditorKit extends NoWrapEditorKit {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewFactory getViewFactory() {
    return new NumberedViewFactory();
    }
}