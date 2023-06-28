import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    JTextField nameField, mailField;

    JRadioButton male, female;

    JCheckBox check;
    public ContactForm(){
        super("Контактная форма");
        super.setBounds(200,100,300,250);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5,2,2,10));

        JLabel name = new JLabel("Введите имя:");
        nameField = new JTextField("",1);
        JLabel mail = new JLabel("Введите email:");
        mailField = new JTextField("@",1);

        container.add(name);
        container.add(nameField);
        container.add(mail);
        container.add(mailField);

         male = new JRadioButton("Мужской");
         female = new JRadioButton("Женский");
        check = new JCheckBox("Согласен", false);
        JButton sendButtom = new JButton("Отправить");

        male.setSelected(true);
        container.add(male);
        container.add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(check);
        container.add(sendButtom);

        sendButtom.addActionListener(new ButtonEventManager());
    }

    class ButtonEventManager implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String mail = mailField.getText();

            String isMale = "Мужской";
            if(!male.isSelected())
                isMale = "Женский";

            boolean checkbox = check.isSelected();

            JOptionPane.showMessageDialog(null,"Ваша почта: " + mail +
                    "\nВаш пол: " + isMale + "\nВы согласны? " + checkbox,"Привет, " +
                    name, JOptionPane.PLAIN_MESSAGE);
        }
    }
}
