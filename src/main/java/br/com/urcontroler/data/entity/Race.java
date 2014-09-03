package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.urcontroler.data.enums.Dice;
import java.util.List;
import java.util.Objects;
import javax.swing.GroupLayout.Alignment;

/**
 * Entidade das raças
 *
 * @author kaciano
 * @version 1.0
 */
public class Race {

    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;
    @Editable
    @ColumnName(name = "Tendencia")
    private Alignment tendecy;
    @Editable
    @ColumnName(name = "Altura Min.")
    private double minHeight;
    @Editable
    @ColumnName(name = "Altura Max.")
    private double maxHeight;
    @Editable
    @ColumnName(name = "Peso Min.")
    private double minWeight;
    @Editable
    @ColumnName(name = "Peso Max.")
    private double maxWeight;
    @Editable
    @ColumnName(name = "Maturidade")
    private int maturity;
    @Editable
    @ColumnName(name = "Expec. Vida")
    private int maxAge;
    @Editable
    @ColumnName(name = "Dado de Vida")
    private Dice lifeDice;
    @Ignore
    @ColumnName(name = "Modificadores")
    private Modifier modifier;
    @Ignore
    @ColumnName(name = "Idiomas Possiveis")
    private List<LanguageType> languages;
    @Ignore
    @ColumnName(name = "Habilidades Raciais")
    private List<Skill> skills;
    @Ignore
    @ColumnName(name = "Armaduras Permitidas")
    private List<ArmorType> allowedArmors;
    @Ignore
    @ColumnName(name = "Armas Permitidas")
    private List<WeaponType> allowedWeapons;

    /**
     * Cria nova instancia de Race
     */
    public Race() {
    }

    /**
     * Cria nova instancia de Race
     *
     * @param id {@code Long} Código da raça
     * @param name {@code String} Nome da raça
     * @param tendecy {@code Alignment} Tendencia da raça
     * @param minHeight {@code double} Altura minima da raça
     * @param maxHeight {@code double} Altura maxima da raça
     * @param minWeight {@code double} Peso minimo da raça
     * @param maxWeight {@code double} Peso maximo da raça
     * @param maturity {@code int} Idade de maturidade na raça
     * @param maxAge {@code int} Expectativa de vida da raça
     * @param lifeDice {@code Dice} Dado de vida da raça
     * @param modifier {@code Modifier} Modificadores da raça
     * @param languages {@code List(LanguageType)} Idiomas permitidos na raça
     * @param skills {@code List(Skill)} Habilidades singulares da raça
     * @param allowedArmors {@code List(ArmorType)} Armas permitidas na raça
     * @param allowedWeapons {@code List(WeaponType)} Armas permitidas na raça
     */
    public Race(Long id, String name, Alignment tendecy, double minHeight,
            double maxHeight, double minWeight, double maxWeight, int maturity,
            int maxAge, Dice lifeDice, Modifier modifier,
            List<LanguageType> languages, List<Skill> skills,
            List<ArmorType> allowedArmors, List<WeaponType> allowedWeapons) {
        this.id = id;
        this.name = name;
        this.tendecy = tendecy;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.maturity = maturity;
        this.maxAge = maxAge;
        this.lifeDice = lifeDice;
        this.modifier = modifier;
        this.languages = languages;
        this.skills = skills;
        this.allowedArmors = allowedArmors;
        this.allowedWeapons = allowedWeapons;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Race other = (Race) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Retorna o Código da raça
     *
     * @return {@code Long} Código da raça
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código da raça
     *
     * @param id {@code Long} Código da raça
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome da raça
     *
     * @return {@code String} Nome da raça
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome da raça
     *
     * @param name {@code String} Nome da raça
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o Tendencia da raça
     *
     * @return {@code Alignment} Tendencia da raça
     */
    public Alignment getTendecy() {
        return tendecy;
    }

    /**
     * Modifica o Tendencia da raça
     *
     * @param tendecy {@code Alignment} Tendencia da raça
     */
    public void setTendecy(Alignment tendecy) {
        this.tendecy = tendecy;
    }

    /**
     * Retorna a Altura minima da raça
     *
     * @return {@code double} Altura minima da raça
     */
    public double getMinHeight() {
        return minHeight;
    }

    /**
     * Modifica a Altura minima da raça
     *
     * @param minHeight {@code double} Altura minima da raça
     */
    public void setMinHeight(double minHeight) {
        this.minHeight = minHeight;
    }

    /**
     * Retorna a Altura maxima da raça
     *
     * @return {@code double} Altura maxima da raça
     */
    public double getMaxHeight() {
        return maxHeight;
    }

    /**
     * Modifica a Altura maxima da raça
     *
     * @param maxHeight {@code double} Altura maxima da raça
     */
    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    /**
     * Retorna o Peso minimo da raça
     *
     * @return {@code double} Peso minimo da raça
     */
    public double getMinWeight() {
        return minWeight;
    }

    /**
     * Modifica o Peso minimo da raça
     *
     * @param minWeight {@code double} Peso minimo da raça
     */
    public void setMinWeight(double minWeight) {
        this.minWeight = minWeight;
    }

    /**
     * Retorna o Peso maximo da raça
     *
     * @return {@code double} Peso maximo da raça
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * Modifica o Peso maximo da raça
     *
     * @param maxWeight {@code double} Peso maximo da raça
     */
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Retorna a Idade de maturidade na raça
     *
     * @return {@code int} Idade de maturidade na raça
     */
    public int getMaturity() {
        return maturity;
    }

    /**
     * Modifica a Idade de maturidade na raça
     *
     * @param maturity {@code int} Idade de maturidade na raça
     */
    public void setMaturity(int maturity) {
        this.maturity = maturity;
    }

    /**
     * Retorna a Expectativa de vida da raça
     *
     * @return {@code int} Expectativa de vida da raça
     */
    public int getMaxAge() {
        return maxAge;
    }

    /**
     * Modifica a Expectativa de vida da raça
     *
     * @param maxAge {@code int} Expectativa de vida da raça
     */
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    /**
     * Retorna o Dado de vida da raça
     *
     * @return {@code Dice} Dado de vida da raça
     */
    public Dice getLifeDice() {
        return lifeDice;
    }

    /**
     * Modifica o Dado de vida da raça
     *
     * @param lifeDice {@code Dice} Dado de vida da raça
     */
    public void setLifeDice(Dice lifeDice) {
        this.lifeDice = lifeDice;
    }

    /**
     * Retorna os Modificadores da raça
     *
     * @return {@code Modifier} Modificadores da raça
     */
    public Modifier getModifier() {
        return modifier;
    }

    /**
     * Modifica os Modificadores da raça
     *
     * @param modifier {@code Modifier} Modificadores da raça
     */
    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }

    /**
     * Retorna os Idiomas permitidos na raça
     *
     * @return {@code List(LanguageType)} Idiomas permitidos na raça
     */
    public List<LanguageType> getLanguages() {
        return languages;
    }

    /**
     * Modifica os Idiomas permitidos na raça
     *
     * @param languages {@code List(LanguageType)} Idiomas permitidos na raça
     */
    public void setLanguages(List<LanguageType> languages) {
        this.languages = languages;
    }

    /**
     * Retorna as Habilidades singulares da raça
     *
     * @return {@code List(Skill)} Habilidades singulares da raça
     */
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * Modifica as Habilidades singulares da raça
     *
     * @param skills {@code List(Skill)} Habilidades singulares da raça
     */
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    /**
     * Retorna as Armas permitidas na raça
     *
     * @return {@code List(ArmorType)} Armas permitidas na raça
     */
    public List<ArmorType> getAllowedArmors() {
        return allowedArmors;
    }

    /**
     * Modifica as Armas permitidas na raça
     *
     * @param allowedArmors {@code List(ArmorType)} Armas permitidas na raça
     */
    public void setAllowedArmors(List<ArmorType> allowedArmors) {
        this.allowedArmors = allowedArmors;
    }

    /**
     * Retorna as Armas permitidas na raça
     *
     * @return {@code List(WeaponType)} Armas permitidas na raça
     */
    public List<WeaponType> getAllowedWeapons() {
        return allowedWeapons;
    }

    /**
     * Modifica as Armas permitidas na raça
     *
     * @param allowedWeapons {@code List(WeaponType)} Armas permitidas na raça
     */
    public void setAllowedWeapons(List<WeaponType> allowedWeapons) {
        this.allowedWeapons = allowedWeapons;
    }

}
