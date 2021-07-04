/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveltimecalculator.model;

/**
 *
 * @author Jimen
 */
public class Mapa {

    private String Road;
    private double Speed;

    public Mapa(String Road, double Speed) {
        this.Road = Road;
        this.Speed = Speed;
    }

    public String getRoad() {
        return Road;
    }

    public void setRoad(String Road) {
        this.Road = Road;
    }

    public double getSpeed() {
        return Speed;
    }

    public void setSpeed(double Speed) {
        this.Speed = Speed;
    }

    @Override
    public String toString() {
        return "Map{" + "tipo=" + Road + ", price=" + Speed + '}';
    }

}
