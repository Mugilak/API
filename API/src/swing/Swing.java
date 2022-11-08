package swing;

import javax.swing.*;
import javax.swing.event.*;

import model.Data;
import model.Details;

public class Swing extends JFrame implements ListSelectionListener {
	private JList a, b;
	private JLabel label1, ans;
	private Details detail;
	private Swing swing;
	private JFrame frame;
	private JPanel panel;
	private String answer;

	public Swing(Details details) {
		detail = details;
	}

	public void addInJList(Swing swing) {
		answer = "";
		frame = new JFrame();
		panel = new JPanel();
		frame.setSize(600, 600);
		label1 = new JLabel("Select field : ");
		int i = 0;
		String[] array = { "page", "per page", "total", "total pages", "Data", "Support" };
		a = new JList(array);
		ans = new JLabel();
		String[] data = new String[detail.getData().size()];
		for (Data d : detail.getData()) {
			answer =d.getId() + " \n" + d.getName() + " " + d.getColor() + " " + d.getYear() + " "
					+ d.getPantone_value();
			data[i++] = answer;
		}
		b=new JList(data);
		b.setVisible(false);
		a.setSelectedIndex(0);
		a.addListSelectionListener(swing);
		panel.add(label1);
		panel.add(a);
		panel.add(b);
		panel.add(ans);

		frame.add(panel);

		frame.setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		switch (a.getSelectedValue().toString()) {
		case "page":
			b.setVisible(false);
			ans.setVisible(true);
			ans.setText(((Integer) detail.getPage()).toString());
			break;
		case "per page":
			b.setVisible(false);
			ans.setVisible(true);
			ans.setText(((Integer) detail.getPer_page()).toString());
			break;
		case "total":
			b.setVisible(false);
			ans.setVisible(true);
			ans.setText(((Integer) detail.getTotal()).toString());
			break;
		case "total pages":
			b.setVisible(false);
			ans.setVisible(true);
			ans.setText(((Integer) detail.getTotal_pages()).toString());
			break;
		case "Data":
			ans.setVisible(false);
			b.setVisible(true);
			break;
		case "Support":
			b.setVisible(false);
			ans.setVisible(true);
			ans.setText(detail.getSupport().getText() + " \n" + detail.getSupport().getUrl());
			break;
		}

	}
}
