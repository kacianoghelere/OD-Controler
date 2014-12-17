package br.com.urcontroler.main.view.race;

import br.com.gmp.comps.data.GenericDAO;
import br.com.urcontroler.data.db.dao.DaoBuilder;
import br.com.urcontroler.data.entity.ArmorType;
import br.com.urcontroler.data.entity.LanguageType;
import br.com.urcontroler.data.entity.Perk;
import br.com.urcontroler.data.entity.Race;
import br.com.urcontroler.data.entity.Skill;
import br.com.urcontroler.data.entity.WeaponType;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import java.util.List;

/**
 * Bean de controle da lista de raças
 *
 * @author kaciano
 */
public class RaceListBean extends ViewBean<RaceListView> {

    private GenericDAO<Race> raceDAO;
    private GenericDAO<ArmorType> armorDAO;
    private GenericDAO<WeaponType> weaponDAO;
    private GenericDAO<Skill> skillDAO;
    private GenericDAO<Perk> perkDAO;
    private GenericDAO<LanguageType> langDAO;

    /**
     * Cria nova instancia de RaceListBean
     *
     * @param view {@code RaceListView} Tela edição de raças
     */
    public RaceListBean(RaceListView view) {
        super(view);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.raceDAO = DaoBuilder.get(Race.class);
        this.armorDAO = DaoBuilder.get(ArmorType.class);
        this.weaponDAO = DaoBuilder.get(WeaponType.class);
        this.skillDAO = DaoBuilder.get(Skill.class);
        this.perkDAO = DaoBuilder.get(Perk.class);
        this.langDAO = DaoBuilder.get(LanguageType.class);
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        this.raceDAO.replaceAll(getView().getModel().getData());
    }

    /**
     * Retorna a lista de registros de raças
     *
     * @return {@code List(Race)} Lista de registros de raças
     */
    public List<Race> getRaceList() {
        return this.raceDAO.getList();
    }

    /**
     * Retorna a lista de registros de tipos de armaduras
     *
     * @return {@code List(ArmorType)} Lista de registros de tipos de armaduras
     */
    public List<ArmorType> getArmorTpList() {
        return this.armorDAO.getList();
    }

    /**
     * Retorna a lista de registros de tipos de armas
     *
     * @return {@code List(WeaponType)} Lista de registros de tipos de armas
     */
    public List<WeaponType> getWeaponTpList() {
        return this.weaponDAO.getList();
    }

    /**
     * Retorna a lista de registros de habilidades
     *
     * @return {@code List(Skill)} Lista de registros de habilidades
     */
    public List<Skill> getSkillList() {
        return this.skillDAO.getList();
    }

    /**
     * Retorna a lista de registros de vantagens
     *
     * @return {@code List(Perk)} Lista de registros de vantagens
     */
    public List<Perk> getPerkList() {
        return this.perkDAO.getList();
    }

    /**
     * Retorna a lista de registros de idiomas
     *
     * @return {@code List(LanguageType)} Lista de registros de idiomas
     */
    public List<LanguageType> getLangTpList() {
        return this.langDAO.getList();
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        if (getView().getModel().getData() != null || getView().getModel().getData().isEmpty()) {
            return (id + 1);
        }
        for (Race race : getView().getModel().getData()) {
            if (race.getId() == null) {
                id = 1L;
            } else if (race.getId() > id) {
                id = race.getId();
            }
        }
        return (id + 1);
    }
}
