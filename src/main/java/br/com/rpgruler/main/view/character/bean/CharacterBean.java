package br.com.rpgruler.main.view.character.bean;

import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.character.CharacterView;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.character.object.CharacterSheet;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Bean de controle para a tela de personagens
 *
 * @author kaciano
 */
public class CharacterBean extends ViewBean<CharacterView> {

    /**
     * Cria nova instancia de CharacterBean
     *
     * @param view <code>CharacterView</code> View do Bean
     */
    public CharacterBean(CharacterView view) {
        super(view);
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        super.commit(evt); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void process(BeanEvent evt) throws Exception {
        try {
            List<CharacterSheet> list = new ArrayList<>();
            list.add(new CharacterSheet());
            String path = "/jasper/CharacterSheet.jasper";
            String sheet = "/home/kaciano/CharacterSheet.pdf";
            String file = getClass().getResource(path).getFile();            
            System.out.println(file);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream buffer = new BufferedInputStream(fis);
            JasperReport report = (JasperReport) JRLoader.loadObject(buffer);
            JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(list);                        
            JasperPrint prints = JasperFillManager.fillReport(report, null, source);
            JasperExportManager.exportReportToPdfFile(prints, sheet);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(sheet));
            }
        } catch (JRException | IOException e) {
            Logger.getLogger(CharacterBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
