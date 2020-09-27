package endlesshorizon;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.swing.JTextArea;

public class Display extends OutputStream{
	private JTextArea textArea;
     
    public Display(JTextArea textArea) {
        this.textArea = textArea;
    }
     
    // @Override
    public void write(int b) throws IOException {
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
        textArea.append(String.valueOf((char)b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
