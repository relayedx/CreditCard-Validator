import javax.swing.*;

public class CCvalidator  {
    public static void main(String[] args){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel cclabel = new JLabel("Credit Card:");
        cclabel.setBounds(10, 20, 80, 25);
        panel.add(cclabel);
        JTextField usertext = new JTextField();
        usertext.setBounds(80, 20, 165, 25);
        panel.add(usertext);

        JButton check = new JButton("Check");
        check.setBounds(75, 80, 80, 25);
        panel.add(check);
        JLabel valid = new JLabel();
        valid.setBounds(10, 110, 300, 25);
        panel.add(valid);

        JButton reset = new JButton("Reset");
        reset.setBounds(200, 80, 80, 25);
        panel.add(reset);

        reset.addActionListener( (e) -> {
            usertext.setText("");
            valid.setText("");
        });

        check.addActionListener( (e) -> {
            String user = usertext.getText();
            if(!(
                    user.startsWith("4") ||
                            user.startsWith("6") ||
                            user.startsWith("37")||
                            user.startsWith("5"))
            ){
                valid.setText("not a credit card number.");
                return; }
            if(user.length() < 13) {
                valid.setText("credit card number is too short.");
                return;
            }
            else if(user.length() > 16) {
                valid.setText("credit card number is too long.");
                return;
            }
            long ccnumber = Long.parseLong(user);
            long ccnumber2 = Long.parseLong(user);
            long sum = 0;
            ccnumber /= 10;
            while (ccnumber > 0){
                long digit = (ccnumber%10) * 2; // grabbing digit
                if (digit > 9){ // if the multiplied digit is greater than 9
                    long digit2 = (digit%10); // grabs the most right digit of the two digits
                    digit /= 10; // grabs the most left digit of the two digits
                    digit += digit2; // adds the most right digit to the left digit
                }
                sum+= digit; // adds final digit to sum
                ccnumber /= 100;
            }
            while (ccnumber2 > 0){
                long digit = (ccnumber2%10);
                sum+= digit;
                ccnumber2 /= 100;
            }
            if (sum % 10 == 0){
                valid.setText("credit card number is valid.");
            } else{
                valid.setText("credit card number is invalid.");
            }
        });

        frame.setVisible(true);


    }
}