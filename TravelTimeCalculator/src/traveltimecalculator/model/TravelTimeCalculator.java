package traveltimecalculator.model;

import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class TravelTimeCalculator {

    /**
     * the map from road types to speed limits.
     */
    // public static Map<String, Double> speedLimits;
    public static ArrayList<Mapa> speedLimits;

    public TravelTimeCalculator() {
        speedLimits = new ArrayList<Mapa>();
        Defaultspeed();
    }

    public ArrayList<Mapa> getSpeedLimit() {
        return speedLimits;
    }

    public void getSpeedLimit(ArrayList<Mapa> speedLimits) {
        TravelTimeCalculator.speedLimits = speedLimits;
    }

    //Methods to calculate
    public void Defaultspeed() {
        speedLimits.add(new Mapa("urban", 50.0));
        speedLimits.add(new Mapa("motorway", 100.0));
        speedLimits.add(new Mapa("highway", 120.0));

    }

    //METHODS
    public static double CalculateSpeed(double distance, double speed) {
        return Math.round(distance / speed);
    }

//    /**
//     * calculates estimated time of travel.
//     *
//     * @param distance the distance to travel, in km.
//     * @param roadType the type of the road.
//     * @return the estiimated time of travelling, in hours.
//     */
//    public Double calculateTime(Double distance, String roadType) {
//        Double speed = this.getSpeedLimit(roadType);
//        Double time = distance / speed;
//        return time;
//    }
//    /**
//     * gets speed limit of the given road type.
//     *
//     * @param roadType the type of the road.
//     * @return its speed limit, if found, null otherwise,
//     */
//    public Double getSpeedLimit(String roadType) {
//        return speedLimits.get(roadType);
//    }
//
//    /**
//     * sets the speed limit of the given road type, only if it exists.
//     *
//     * @param roadType the type of the road.
//     * @param speed the speed of the road.
//     * @return true if set, false otherwise.
//     */
//    public boolean setSpeedLimit(String roadType, Double speed) {
//        if (this.getSpeedLimit(roadType) == null) {
//            return false;
//        }
//        speedLimits.put(roadType, speed);
//        return true;
//    }
    /**
     * // * gets the names of the road types. // * // * @return the types of
     * the roads. //
     */
//    public String[] getRoadTypes() {
//        String[] types = speedLimits.keySet().stream().toArray(String[]::new);
//        return types;
//    }
}
