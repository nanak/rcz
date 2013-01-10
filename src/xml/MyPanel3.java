package xml;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyPanel3 extends JPanel implements ActionListener{
	private JProgressBar p;
	private JTextArea ta;
	private JButton end;
	
	public MyPanel3(){
		this.setLayout(new BorderLayout());
		
		p = new JProgressBar(0,100);
		ta = new JTextArea();
		end = new JButton("Abbrechen");
		end.addActionListener(this);
		p.setValue(0);
		ta.setText("Programm Start! \n");
		p.setStringPainted(true);
		
		this.add(p, BorderLayout.NORTH);
		this.add(new JScrollPane(ta));
		this.add(end,BorderLayout.SOUTH);
	}
	public void setProcess(int wert){
		p.setValue(wert);
	}
	public void log(String txt){
		ta.setText(ta.getText() + txt + "\n");
	}
	public void setMinMax(int min, int max){
		p.setMaximum(max);
		p.setMinimum(min);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == end){
			System.exit(0);
		}
	}
}
