package br.com.urcontroler.main.view.renderers;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author kaciano
 */
public class ArmorListRenderer implements ListCellRenderer<Object> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = new JLabel(value.toString());
        label.setIcon(new ImageIcon(getClass().getResource("/Mixed/P_2.png")));
        return label;
    }

}
