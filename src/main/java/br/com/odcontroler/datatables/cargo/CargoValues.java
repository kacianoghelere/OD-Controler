package br.com.odcontroler.datatables.cargo;

import java.util.ArrayList;
import java.util.List;

/**
 * Coleção com os valores por faixas de carga
 *
 * @author kaciano
 * @version 1.0
 */
public class CargoValues {

    private final List<CargoData> cargoValues;

    /**
     * Cria nova instancia de CargoValues
     */
    public CargoValues() {
        this.cargoValues = new ArrayList<>();
        this.cargoValues.add(new CargoData("0-1", 1, 2, 5));
        this.cargoValues.add(new CargoData("2-3", 3, 5, 15));
        this.cargoValues.add(new CargoData("4-5", 5, 8, 25));
        this.cargoValues.add(new CargoData("6-7", 12, 15, 35));
        this.cargoValues.add(new CargoData("8-9", 15, 25, 45));
        this.cargoValues.add(new CargoData("10-11", 19, 30, 58));
        this.cargoValues.add(new CargoData("12-13", 25, 40, 75));
        this.cargoValues.add(new CargoData("14-15", 33, 50, 100));
        this.cargoValues.add(new CargoData("16-17", 43, 70, 130));
        this.cargoValues.add(new CargoData("18-19", 58, 90, 175));
        this.cargoValues.add(new CargoData("20-21", 75, 120, 230));
        this.cargoValues.add(new CargoData("22-23", 100, 150, 300));
        this.cargoValues.add(new CargoData("24-25", 135, 200, 400));
        this.cargoValues.add(new CargoData("26-27", 175, 250, 520));
        this.cargoValues.add(new CargoData("28-29", 235, 350, 700));
    }

    /**
     * Retorna a lista de valores para carga
     *
     * @return {@code List(CargoData)} Lista de valores para carga
     */
    public List<CargoData> getCargoValues() {
        return cargoValues;
    }
}
