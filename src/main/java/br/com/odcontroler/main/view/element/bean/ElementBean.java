package br.com.odcontroler.main.view.element.bean;

import br.com.gmp.utils.image.ImageUtil;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.ElementDAO;
import br.com.odcontroler.data.entity.Element;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.element.ElementView;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Bean para a View de elementos
 *
 * @author kaciano
 */
public class ElementBean extends ViewBean<ElementView> {

    private ElementDAO dao;
    private ElementView elementView;

    /**
     * Cria nova instancia de ElementBean
     *
     * @param elementView <code>ElementView</code> View
     */
    public ElementBean(ElementView elementView) {
        super(elementView);
        dao = new ElementDAO();
        this.elementView = elementView;
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        List<Element> list = dao.getList();
        if (list.isEmpty()) {
            dao.replaceAll(getDefaultElements());
            list = dao.getList();
        }
        getView().getModel().setData(list);
    }

    @Override
    public void add(BeanEvent evt) {
        try {
            ObjectWrapper vw = evt.getWrapper();
            String title = (String) vw.getValue("title");
            int symbol = (int) vw.getValue("symbol");
            Element bonus = (Element) vw.getValue("bonus");
            Element weak = (Element) vw.getValue("weak");
            add(title, symbol, bonus, weak);
        } catch (Exception ex) {
            Logger.getLogger(ElementBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adiciona novo elemento na tabela
     *
     * @param title <code>String[]</code> Nome do elemento
     * @param symbol <code>int</code> Index do simbolo
     * @param bonus <code>Element</code> Bonûs
     * @param weak <code>Element</code> Fraqueza
     */
    public void add(String title, int symbol, Element bonus, Element weak) {
        Long id = getNextID();
        for (Element element : elementView.getModel().getData()) {
            id = element.getId() > id ? element.getId() : id;
        }
        getView().getModel().add(new Element(id, title, getImagePaths()[symbol]));
    }

    /**
     * Retorna os caminhos para os icones de elementos
     *
     * @return <code>String[]</code> Caminhos
     */
    public String[] getImagePaths() {
        return new String[]{"/RpgIcons/fire.png",
            "/RpgIcons/water.png",
            "/RpgIcons/wind.png",
            "/RpgIcons/earth.png",
            "/RpgIcons/light.png",
            "/RpgIcons/dark.png",
            "/RpgIcons/lightning.png"};
    }

    /**
     * Retorna o array de ImageIcons contendo os simbolos dos elementos
     *
     * @return <code>ImageIcon[]</code> Simbolos
     */
    public ImageIcon[] getElementsIcons() {
        ImageIcon[] icons = new ImageIcon[getImagePaths().length];
        for (int i = 0; i < getImagePaths().length; i++) {
            icons[i] = new ImageIcon(getClass().getResource(getImagePaths()[i]));
            icons[i].setImage(new ImageUtil().getScaledImage(icons[i].getImage(), 16, 16));
        }
        return icons;
    }

    /**
     * Retorna o próximo ID dos elementos
     *
     * @return <code>Long</code> Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Element element : getView().getModel().getData()) {
            if (element.getId() > id) {
                id = element.getId();
            }
        }
        return (id + 1);
    }

    /**
     * Retorna uma lista de elementos padrão para evitar ter de carregar toda
     * santa vez...
     *
     * @return <code>List(Element)</code> Lista de elementos
     */
    public List<Element> getDefaultElements() {
        List<Element> elements = new ArrayList<>();
        elements.add(new Element((long) 1, "Fogo", "/RpgIcons/fire.png"));
        elements.add(new Element((long) 2, "Água", "/RpgIcons/water.png"));
        elements.add(new Element((long) 3, "Eletrecidade", "/RpgIcons/lightning.png"));
        elements.add(new Element((long) 4, "Terra", "/RpgIcons/earth.png"));
        elements.add(new Element((long) 5, "Ar", "/RpgIcons/wind.png"));
        elements.add(new Element((long) 6, "Luz", "/RpgIcons/light.png"));
        elements.add(new Element((long) 7, "Sombra", "/RpgIcons/dark.png"));
        Element[] el = elements.toArray(new Element[]{});
        elements.get(0).setWeakness(el[1]);
        elements.get(0).setBonus(el[4]);
        elements.get(1).setWeakness(el[2]);
        elements.get(1).setBonus(el[0]);
        elements.get(2).setWeakness(el[3]);
        elements.get(2).setBonus(el[1]);
        elements.get(3).setWeakness(el[4]);
        elements.get(3).setBonus(el[2]);
        elements.get(4).setWeakness(el[0]);
        elements.get(4).setBonus(el[3]);
        elements.get(5).setWeakness(el[6]);
        elements.get(5).setBonus(el[1]);
        elements.get(6).setWeakness(el[5]);
        elements.get(6).setBonus(el[0]);
        return elements;
    }

}
