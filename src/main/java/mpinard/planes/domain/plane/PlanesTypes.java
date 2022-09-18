package mpinard.planes.domain.plane;

import lombok.experimental.UtilityClass;
import mpinard.planes.domain.airport.AirportClass;

import java.math.BigDecimal;
import java.util.List;

@UtilityClass
public class PlanesTypes {
    public static final PlaneType BEARCLAW_P = PlaneType.of(
        PlaneTypeId.of(), "Bearclaw-P", 1, 0, 126, 500, new BigDecimal("1.0"), AirportClass.ONE, 1, 3);
    public static final PlaneType BEARCLAW_C = PlaneType.of(
        PlaneTypeId.of(), "Bearclaw-C", 0, 1, 126, 500, new BigDecimal("1.0"), AirportClass.ONE, 1, 3);
    public static final PlaneType GRIFFON_P = PlaneType.of(
        PlaneTypeId.of(), "Griffon-P", 1, 0, 140, 800, new BigDecimal("1.1"), AirportClass.ONE, 1, 3);
    public static final PlaneType GRIFFON_C = PlaneType.of(
        PlaneTypeId.of(), "Griffon-C", 0, 1, 140, 800, new BigDecimal("1.1"), AirportClass.ONE, 1, 3);
    public static final PlaneType NAVIGATOR_P = PlaneType.of(
        PlaneTypeId.of(), "Navigator-P", 2, 0, 165, 600, new BigDecimal("2.0"), AirportClass.ONE, 1, 3);
    public static final PlaneType NAVIGATOR_C = PlaneType.of(
        PlaneTypeId.of(), "Navigator-C", 0, 2, 165, 600, new BigDecimal("2.0"), AirportClass.ONE, 1, 3);
    public static final PlaneType NAVIGATOR_M = PlaneType.of(
        PlaneTypeId.of(), "Navigator-M", 1, 1, 165, 600, new BigDecimal("2.0"), AirportClass.ONE, 1, 3);
    public static final PlaneType WALLABY_P = PlaneType.of(
        PlaneTypeId.of(), "Wallaby-P", 2, 0, 143, 700, new BigDecimal("2.2"), AirportClass.ONE, 1, 3);
    public static final PlaneType WALLABY_C = PlaneType.of(
        PlaneTypeId.of(), "Wallaby-C", 0, 2, 143, 700, new BigDecimal("2.2"), AirportClass.ONE, 1, 3);
    public static final PlaneType WALLABY_M = PlaneType.of(
        PlaneTypeId.of(), "Wallaby-M", 1, 1, 143, 700, new BigDecimal("2.2"), AirportClass.ONE, 1, 3);
    public static List<PlaneType> ALL = List.of(
        PlanesTypes.BEARCLAW_P,
        PlanesTypes.BEARCLAW_C,
        PlanesTypes.GRIFFON_P,
        PlanesTypes.GRIFFON_C,
        PlanesTypes.NAVIGATOR_P,
        PlanesTypes.NAVIGATOR_C,
        PlanesTypes.NAVIGATOR_M,
        PlanesTypes.WALLABY_P,
        PlanesTypes.WALLABY_C,
        PlanesTypes.WALLABY_M);
}
