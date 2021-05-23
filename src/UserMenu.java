import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;


public class UserMenu {
JFrame frame = new JFrame();

JTextField textFirstName = null;//field to write first name 
 JTextField textLastName = null;//field to write last name
JTextField textAddress = null;//field to write  address 
JTextField textContact = null;//field to wri contact
    JTextField textRollno = null;//field to write rollno    
JTextField textJava = null;//field to write marks of java 
    JTextField textMath = null;//field to write marks of math
 JTextField textEnglish = null;//field to write marks of english 
    JTextField textMacro = null;//field to write marks of Macroeconomics


    JRadioButton btnMale = null;
    JRadioButton btnFemale = null;
    ButtonGroup btnGender = null;
    JComboBox comboProgram = null;


    JButton btnAdd = null;//add data    
    JButton btnDisplay = null;//display data
    JButton btnReset = null;//reset data
    JButton btnCancel = null;//cancel

    UserMenu() {

        frame = new JFrame("User Menu");
        // panels
        JPanel panelTop = new JPanel();
        JPanel panelGender = new JPanel();
        // JPanel panelProgram = new JPanel();
        JPanel panelMain = new JPanel();
        JPanel panelButton = new JPanel();

        // labels
        JLabel lblFirstName = new JLabel("First Name :");
        JLabel lblLastName = new JLabel("Last Name :");
        JLabel lblGender = new JLabel("Gender :");

        JLabel lblAddress = new JLabel("Address :");
        JLabel lblContact = new JLabel("Contact :");
        JLabel lblRollno = new JLabel("Rollno :");
        JLabel lblProgram = new JLabel("Program :");

        // Marks
        JLabel lblJava = new JLabel("Java Mark :");
        JLabel lblMath = new JLabel("Math Mark :");
        JLabel lblEnglish = new JLabel("English Mark :");
        JLabel lblMacro = new JLabel("Macro Mark :");

        // text fields
        textFirstName = new JTextField(10);
        textLastName = new JTextField(10);
        textRollno = new JTextField(10);
        textAddress = new JTextField(10);
        textContact = new JTextField(10);
        // text for programs
        textJava = new JTextField(5);
        textMath = new JTextField(5);
        textEnglish = new JTextField(5);
        textMacro = new JTextField(5);

        // Gender
        btnGender = new ButtonGroup();
        btnMale = new JRadioButton("Male");
        btnFemale = new JRadioButton("Female");
        btnGender.add(btnMale);
        btnGender.add(btnFemale);


        String[] programs = {  "BIT", "BCIS","BSCIT", "BCA", "BIM" };

        comboProgram = new JComboBox(programs);

        panelGender.add(btnMale);
        panelGender.add(btnFemale);
        panelTop.setLayout(new GridLayout(12, 3, 12, 12));
        panelButton.setLayout(new FlowLayout());

btnAdd = new JButton("Add");
btnReset = new JButton("Reset");
btnDisplay = new JButton("Display");
btnCancel = new JButton("Cancel");


        panelTop.add(lblFirstName);
        panelTop.add(textFirstName);

        panelTop.add(lblLastName);
        panelTop.add(textLastName);

        panelTop.add(lblGender);
        panelTop.add(panelGender);

        panelTop.add(lblAddress);
        panelTop.add(textAddress);

        panelTop.add(lblContact);
        panelTop.add(textContact);

        panelTop.add(lblRollno);
        panelTop.add(textRollno);

        panelTop.add(lblProgram);
        comboProgram.setBackground(Color.white);
        panelTop.add(comboProgram);

panelTop.add(lblJava);
panelTop.add(textJava);
panelTop.add(lblMath);
panelTop.add(textMath);

panelTop.add(lblEnglish);
panelTop.add(textEnglish);

panelTop.add(lblMacro);
panelTop.add(textMacro);

    panelMain.add(panelTop);

panelButton.add(btnAdd);
panelButton.add(btnReset);
panelButton.add(btnDisplay);
        panelButton.add(btnCancel);

        panelMain.add(panelButton);
        frame.add(panelMain);
        frame.setSize(500, 700);
        frame.setVisible(true);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


        User user = new User();
        FileOperation fo = new FileOperation();

        String firstName = textFirstName.getText().toString().trim();
        String lastName = textLastName.getText().toString().trim();
                String gender = "";
                String address = textAddress.getText().toString().trim();
                String contact = textContact.getText().toString().trim();
        String rollNo = textRollno.getText().toString().trim();
        String program = comboProgram.getSelectedItem().toString().trim();


                String javaMarks = textJava.getText().toString().trim();
                String mathMarks = textMath.getText().toString().trim();
                String englishMarks = textEnglish.getText().toString().trim();
                String macroMarks = textMacro.getText().toString().trim();
             
if (btnMale.isSelected()) {
gender = "Male";} 
else if (btnFemale.isSelected()) {
gender = "Female";
} else {
gender = "";
                }
if (firstName.length() == 0 || lastName.length()==0 || gender.length() == 0 
        || address.length() == 0 || contact.length() == 0 || rollNo.length() == 0 
                        || program.length() == 0 || javaMarks.length() == 0 || mathMarks.length() == 0 
                        || englishMarks.length() == 0 || macroMarks.length() == 0) {

JOptionPane.showMessageDialog(frame, "Fields mustnot be empty.", "Input Error", JOptionPane.INFORMATION_MESSAGE);
                } else {


user.setFirstName(firstName);//adding provided data  to main optput dashbor
    user.setLastName(lastName);
        user.setGender(gender);
            user.setAddress(address);
                user.setContact(contact);
                    user.setRollno(rollNo);
                    user.setProgram(program);

                    user.setJavaMarks(javaMarks);
                    user.setMathMarks(mathMarks);
                    user.setEnglishMarks(englishMarks);
                    user.setMacroMarks(macroMarks);
                    try {
                        fo.writeFile(user);
                    } catch (Exception io) {
                        io.printStackTrace();
                    } finally {
                        JOptionPane.showMessageDialog(frame, "Added to the file", "Add",
                                JOptionPane.INFORMATION_MESSAGE);

                    }
                }

            }
        });

        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Display display = new Display();
                try {
                    // display.display();
                    display.Display();
                } catch (Exception ie) {
                    ie.printStackTrace();
                }

            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFirstName.setText("");
                textLastName.setText("");
                textRollno.setText("");
                textAddress.setText("");
                textContact.setText("");
                // text for programs
                textJava.setText("");
                textMath.setText("");
                textEnglish.setText("");
                textMacro.setText("");
                btnGender.clearSelection();
                comboProgram.setSelectedIndex(0);

            }
        });

btnCancel.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
JOptionPane.showMessageDialog(frame, "Your unsaved data will be gone are you sure want to cancel ?", "Cancel",
    JOptionPane.OK_CANCEL_OPTION);
new Login();
}
}
);
}
}
