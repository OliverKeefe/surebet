package org.surebet.racesim.simulator.cars;

public class F1DamageModel22 implements DamageModel{
    public enum DamagedArea {
        WING_FRONT,
        WING_REAR,
        NOSE,
        WHEEL_FRONT_LEFT,
        WHEEL_FRONT_RIGHT,
        WHEEL_REAR_LEFT,
        WHEEL_REAR_RIGHT,
        TIRE_FRONT_LEFT,
        TIRE_FRONT_RIGHT,
        TIRE_REAR_LEFT,
        TIRE_REAR_RIGHT,
        BRAKE_DUCT_FRONT_RIGHT,
        BRAKE_DUCT_FRONT_LEFT,
        BRAKE_DUCT_REAR_RIGHT,
        BRAKE_DUCT_READ_LEFT,
        FLOOR_FENCE_LEFT,
        FLOOR_FENCE_RIGHT,
        SIDE_POD_LEFT,
        SIDE_POD_RIGHT,
        APERTURE_ZONE_LEFT,
        APERTURE_ZONE_RIGHT,
        COKE_PANEL_LEFT,
        COKE_PANEL_RIGHT,
        HALO,
        ENGINE_COVER_LEFT,
        ENGINE_COVER_RIGHT,
        FLOOR,
        REAR_DIFFUSER
    }

    public F1DamageModel22(){}
}
