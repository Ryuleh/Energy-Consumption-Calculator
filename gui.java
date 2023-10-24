import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Energy Consumption Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(6, 2, 10, 10));

    JLabel appliancesLabel = new JLabel("Select Appliances:");
    panel.add(appliancesLabel);

    JCheckBox[] checkBoxes = {
        new JCheckBox("Refrigerator"),
        new JCheckBox("Television"),
        new JCheckBox("Washing Machine"),
        new JCheckBox("Air Conditioner"),
        new JCheckBox("Microwave"),
        new JCheckBox("Dishwasher")
    };
    for (JCheckBox checkBox : checkBoxes) {
      panel.add(checkBox);
    }
    JLabel hoursLabel = new JLabel("Hours per day:");
    panel.add(hoursLabel);

    JTextField hoursField = new JTextField();
    panel.add(hoursField);

    JLabel daysLabel = new JLabel("Days per month:");
    panel.add(daysLabel);

    JTextField daysField = new JTextField();
    panel.add(daysField);

    JLabel costLabel = new JLabel("Cost per kWh:");
    panel.add(costLabel);

    JTextField costField = new JTextField();
    panel.add(costField);

    JButton calculateButton = new JButton("Calculate");
    panel.add(calculateButton);

    JLabel resultLabel = new JLabel();
    panel.add(resultLabel);

    calculateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        double total = 0;
        for (JCheckBox checkBox : checkBoxes) {
          if (checkBox.isSelected()) {
            total += Double.parseDouble(hoursField.getText()) * Double.parseDouble(daysField.getText())
                * Double.parseDouble(costField.getText());
          }
        }
        resultLabel.setText("Total cost: " + total);
      }
    });
    frame.add(panel);
    frame.setVisible(true);
  }
}
