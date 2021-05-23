import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Login {
        String defalutUsername = "abcd";
        String defaultPassword = "123456789";
        JFrame frame = null;
        JTextField textUsername = null; //field for user to input their registered username    
        JPasswordField pwPassword = null; //field for user to input registered password
        JButton buttonLogin = null;
        JButton buttonSignup = null;

Login() {
        JPanel panelMain = new JPanel();
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel();

    JLabel labelUsername = new JLabel();
    JLabel labelPassword = new JLabel();

frame = new JFrame("Login");

labelUsername = new JLabel("Username :");//label beside the input feild     
labelPassword = new JLabel("Password :");//label beside the password field

textUsername = new JTextField(12);//alloctaiong the size of username which cannott exceed 12
pwPassword = new JPasswordField(9);//zllocating size of password which cannot exceed 9

buttonLogin = new JButton("Login");//login button
panelTop.add(labelUsername);
panelTop.add(textUsername);

    panelTop.add(labelPassword);
    panelTop.add(pwPassword);
    panelBottom.add(buttonLogin);

    panelTop.setLayout(new GridLayout(3, 3, 8, 8));

        panelMain.add(panelTop);
panelMain.add(panelBottom);

        frame.setSize(400, 200);
            frame.add(panelMain);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                        frame.setVisible(true);

buttonLogin.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent AE) {
        String username = textUsername.getText().toString().trim();
        
        String password = new String(pwPassword.getPassword()).toString().trim();
        
if (username.length() == 0 || password.length() == 0) 
{
        JOptionPane.showMessageDialog(frame, "Login details are not filled properly.",
 "Login", JOptionPane.INFORMATION_MESSAGE);

} 
else 
{
    if ((defalutUsername.equals(username)) && (defaultPassword.equals(password)))
 {
        UserMenu userMenu = new UserMenu();
 } else {
        JOptionPane.showMessageDialog(frame, "Your Login credentials were not recognized by system !", "Login",
            JOptionPane.ERROR_MESSAGE);
}
}               
}
}
);
}
}