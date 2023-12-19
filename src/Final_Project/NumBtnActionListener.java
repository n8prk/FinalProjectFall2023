package Final_Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/* NOTE: initially, I had individual ActionListeners manually added to all six number buttons. This way, I can use
a loop to optimize instantiation*/
public class NumBtnActionListener implements ActionListener
{
    final int index; // Must be final, I tried implementing it in the main class but it said I need a final index.
    public NumBtnActionListener(int index) // Class constructor
    {
        this.index = index;
    }

    @Override // Class ActionListener Method
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button pressed: " + Digit.btnArr[index].getText());
        System.out.println("Associated int " + Digit.numArr[index]);
        Digit.doMath(index);
    }
}
