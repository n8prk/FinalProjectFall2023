package Final_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Digit implements ActionListener
{
    public static int firstNum = -1; // placeholder variables for calculations
    public static int secondNum = -1;
    public static char oprn = ' '; // the operation for the calculations
    public static int target = (int)(1 + (Math.random() * 20)); // random target goal
    public static int[] numArr = new int[6]; // instantiates array of ints
    public static JButton[] btnArr = new JButton[6]; // instantiates array of associated buttons
    public static JButton firstBtn; // Auxiliary button as placeholder
    public static JPanel bigPanel; // the panel on which components will be added

    public static void main(String[] args)
    {

        JFrame window = new JFrame(); // Instantiates a JFrame

        window.setSize(500, 500); // setting frame dimensions
        window.setTitle("Digit Numbers");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bigPanel = new JPanel(); // Instantiates a JPanel

        bigPanel.setLayout(new GridBagLayout()); // Sets layout for panel
        GridBagConstraints r = new GridBagConstraints(); // Sets constraints for layout

        window.add(bigPanel); // Adds the panel

        r.anchor = GridBagConstraints.CENTER; // centers the components

        JLabel numTarget = new JLabel("Target Number: " + String.valueOf(target)); // display target
        constrictLayout(0,3,numTarget,r);

        for(int i = 0; i<6; i++)
        {
            numArr[i] = (int)(Math.random() * (3*i)) + (2*(i+1)); // Creates six random values
            btnArr[i] = new JButton(String.valueOf(numArr[i])); // Instantiates six associated buttons
            btnArr[i].addActionListener(new NumBtnActionListener(i)); // Using new action listener class
            constrictLayout(i % 3,i/3,btnArr[i],r);
        }

        // INSTANTIATE ALL OPERATOR BUTTONS
        // all operator buttons are the same except for the operation setters and references
        JButton adder = new JButton("+"); // Instantiates adder button
        adder.addActionListener(new OprnActionListener('+', "Adding"));
        constrictLayout(0,2,adder,r);

        // Subtract button
        JButton subtract = new JButton("-");
        subtract.addActionListener(new OprnActionListener('-', "Subtract"));
        constrictLayout(1,2,subtract,r);

        // Multiplication button
        JButton multi = new JButton("*");
        multi.addActionListener(new OprnActionListener('*', "Multiplying"));
        constrictLayout(2,2,multi,r);

        // Dividing Button
        JButton div = new JButton("/");
        div.addActionListener(new OprnActionListener('/',"Dividing"));
        constrictLayout(3,2,div,r);

        JButton clr = new JButton("CE");
        clr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nullAllVals();
                System.out.println("Selections cleared");
            }
        });
        constrictLayout(3,0,clr,r);

        JButton rst = new JButton("Reset");
        rst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i<6; i++)
                {
                    numArr[i] = (int)(Math.random() * (3*i)) + (2*(i+1)); // Creates six random values
                    btnArr[i].setText(String.valueOf(numArr[i])); // Changes button text
                    btnArr[i].setVisible(true); // Instantiates six associated buttons

                }
            }
        });
        constrictLayout(3,1,rst,r);

        window.setVisible(true);
    }
    // Method for calculations
    public static void doMath(int index)
    {
        if(firstBtn == null) // If placeholder is empty, then first number hasn't been selected
        {
            firstNum = numArr[index]; // Designates chosen value to firstNum
            firstBtn = btnArr[index]; // Designates associated button to firstBtn
            System.out.println("First number is " + firstNum);
            return; // returns so that the rest of the code doesn't mess with calculations
        }
        else if (btnArr[index] == firstBtn) // makes sure that the second button is not the first button as well
        {
            System.out.println("Same Button");
            return; // returns so that the rest of the code doesn't mess with calculation
        }
        else if(oprn == ' ')
        {
            firstNum = numArr[index]; // Designates chosen value to firstNum
            firstBtn = btnArr[index]; // Designates associated button to firstBtn
            System.out.println("First number is " + firstNum);
            return;
        }
        else if (oprn == '+') // if operation is addition
        {
            secondNum = numArr[index]; // confirm second number in operation is the second value chosen
            numArr[index] = firstNum + secondNum; // add
        }
        else if(oprn == '-') // if operation is subtraction
        {
            secondNum = numArr[index]; // confirm second number in operation is the second value chosen
            if(secondNum>firstNum) // makes sure that the second value is not less than the first
            {
                System.out.println("Cannot produce negative number");
                nullAllVals(); // nullify all values so player may start over
                return; // do not continue calculation
            }
            else
            {
                numArr[index] = firstNum - secondNum; // subtract
            }
        }
        else if(oprn == '*')
        {
            secondNum = numArr[index]; // confirm second number in operation is the second value chosen
            numArr[index] = firstNum * secondNum; // multiplication
        }
        else if(oprn == '/') // if operation is division
        {
            secondNum = numArr[index]; // confirm second number in operation is the second value chosen
            if((secondNum>firstNum) || (firstNum % secondNum != 0)) // checks if evenly divisible
            {
                nullAllVals();
                System.out.println("Does not divide evenly");
                return;
            }
            else
            {
                numArr[index] = firstNum / secondNum; // division
            }
        }
        // code below should only be executed if an operation is performed
        btnArr[index].setText(String.valueOf(numArr[index])); // changes text of the second button
        System.out.println("Button Text changed");

        for(JButton btn : btnArr) // searches for the first button
        {
            if (firstBtn == btn)
            {
                btn.setVisible(false); // makes first button invisible
            }
        }
        nullAllVals(); // Nullify all values so calculations may continue
    }

    public static void constrictLayout(int gx, int gy, JComponent comp, GridBagConstraints gbc)
    {
        gbc.gridx = gx; // designates cell coordinate of Component
        gbc.gridy = gy;
        gbc.insets = new Insets(5,5,5,5); // determines cell padding
        bigPanel.add(comp,gbc); // add component to panel with constraint
    }

    public static void nullAllVals() // Method nullifies all values involved in calculation
    {
        oprn = ' ';
        firstBtn = null;
        firstNum = -1;
        secondNum = -1;
        System.out.println("All vals nulled");
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}

