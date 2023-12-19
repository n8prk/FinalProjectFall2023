package Final_Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OprnActionListener implements ActionListener
{
    char oprn; // operation being used
    String operation;

    public OprnActionListener(char oprn, String operation)
    {
        this.oprn = oprn;
        this.operation = operation;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(Digit.firstNum != -1) // Ensures that firstNum placeholder is not empty
        {
            System.out.println(operation);
            Digit.oprn = this.oprn; // Determines the operation being used
        }
        else
        {
            System.out.println("Still need to pick a number");
        }
    }
}
