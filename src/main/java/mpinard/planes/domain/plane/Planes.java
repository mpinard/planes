package mpinard.planes.domain.plane;

import lombok.experimental.UtilityClass;
import mpinard.planes.domain.airport.Airports;

import java.util.List;

@UtilityClass
public class Planes {

    public static final Plane BEARCLAW_P = Plane.create(PlaneId.of(), "PL001", Airports.BERLIN.getId(), PlaneTypes.BEARCLAW_P);
    public static final Plane GRIFFON_C = Plane.create(PlaneId.of(), "PL002", Airports.BERLIN.getId(), PlaneTypes.GRIFFON_C);
    public static final Plane NAVIGATOR_C = Plane.create(PlaneId.of(), "PL003", Airports.BRUSSELS.getId(), PlaneTypes.NAVIGATOR_C);
    public static final Plane WALLABY_P = Plane.create(PlaneId.of(), "PL004", Airports.MUNICH.getId(), PlaneTypes.WALLABY_P);

    public static final List<Plane> STARTING_PLANES = List.of(BEARCLAW_P, GRIFFON_C, NAVIGATOR_C, WALLABY_P);

}
