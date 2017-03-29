package Mohamed.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mash4 on 3/23/2017.
 */
public class CCValidator extends JFrame {
    private JTextField cridtCardNumberTextField;
    private JButton validatbutton;
    private JLabel validMessageLabel;
    private JButton quitbutton;
    private JPanel rootPanel;
    public CCValidator(){
        super("Credit Card  Validator ");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        validatbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ccNumber = cridtCardNumberTextField.getText();
                boolean valid = isVisaCreditCardNumberValid(ccNumber);

                if(valid){
                    validMessageLabel.setText("Credit Card is Valid");
                }
                else{
                    validMessageLabel.setText(("Credit card number is NOT valid"));
                }
            }


        });
        quitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(CCValidator.this, "Are you sure to quit",
                        "Quit ", JOptionPane.OK_CANCEL_OPTION);
                if(quit == JOptionPane.OK_OPTION){
                    System.exit(0);
                }

            }
        });
    }

    private  static  boolean isVisaCreditCardNumberValid(String ccNumber) {


        if (!ccNumber.startsWith("4") || (ccNumber.length() != 16)) {
            System.out.println("Doesnt start with 4 or length wrong");
            return false;
        }

        int sum = 0;

        for (int i = 0; i < 16; i++) {
            int thisDigit = Integer.parseInt((ccNumber.substring(i, i + 1)));
            if (i % 2 == 1) {
                sum = sum + thisDigit;
            } else {
                int doubled = thisDigit * 2;
                if (doubled > 9) {
                    int toAdd = 1 + (doubled % 10);
                    sum = sum + toAdd;
                } else {
                    sum = sum + (thisDigit * 2);
                }
            }
        }

        if (sum % 10 == 0) {
            return true;
        }

        return false;
    }
}
