/*
 * Created on 22-mar-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package utils;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import javax.swing.text.*;

public class NoWrapEditorKit extends StyledEditorKit {
private static final ViewFactory defaultFactory = new MyViewFactory();
public ViewFactory getViewFactory() {
return defaultFactory;
}


public static class MyViewFactory implements ViewFactory {
public View create(Element elem) {
String kind = elem.getName();
if (kind != null) {
if (kind.equals(AbstractDocument.ContentElementName)) {
return new MyView(elem);
} else if (kind.equals(AbstractDocument.ParagraphElementName)) {
return new ParagraphView(elem);
} else if (kind.equals(AbstractDocument.SectionElementName)) {
return new BoxView(elem, View.Y_AXIS);
} else if (kind.equals(StyleConstants.ComponentElementName)) {
return new ComponentView(elem);
} else if (kind.equals(StyleConstants.IconElementName)) {
return new IconView(elem);
}
}

// default to text display
return new MyView(elem);
}
}


public static class MyView extends LabelView {
public MyView(Element e) {
super(e);
}

public float getTabbedSpan(float x, TabExpander e) {
float result = super.getTabbedSpan(x, e);
this.preferenceChanged(this, true, false);
return result;
}

}
}

