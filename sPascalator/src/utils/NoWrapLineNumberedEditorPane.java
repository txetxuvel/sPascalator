package utils;

import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.text.EditorKit;

public class NoWrapLineNumberedEditorPane extends JEditorPane {
   public boolean getScrollableTracksViewportWidth() {
      //should not allow text to be wrapped
      return false;
   }

   public void setSize(Dimension d) {
      //dont let the Textpane get sized smaller than its parent
      Dimension pSize = getParent().getSize();
      if (d.width < pSize.width) {
         super.setSize(pSize.width, d.height);
      }
      else {
         super.setSize(d);
      }
   }

   protected EditorKit createDefaultEditorKit() {
      return new NumberedEditorKit();
   }

}