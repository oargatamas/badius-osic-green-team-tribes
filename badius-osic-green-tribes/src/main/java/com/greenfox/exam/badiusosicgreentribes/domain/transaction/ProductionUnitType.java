package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

public enum ProductionUnitType {

    BUILDING {
        @Override
        public ProductionUnitType getCategory() {
            return BUILDING;
        }
    },
    RESOURCE {
        @Override
        public ProductionUnitType getCategory() {
            return RESOURCE;
        }
    },
    UNIT {
        @Override
        public ProductionUnitType getCategory() {
            return UNIT;
        }
    },

    TOWNHALL {
        @Override
        public ProductionUnitType getCategory() {
            return BUILDING;
        }
    },
    MINE {
        @Override
        public ProductionUnitType getCategory() {
            return BUILDING;
        }
    },
    FARM {
        @Override
        public ProductionUnitType getCategory() {
            return BUILDING;
        }
    },
    BARRACK {
        @Override
        public ProductionUnitType getCategory() {
            return BUILDING;
        }
    },
    ACADEMY {
        @Override
        public ProductionUnitType getCategory() {
            return BUILDING;
        }
    },
    KNIGHT {
        @Override
        public ProductionUnitType getCategory() {
            return UNIT;
        }
    },
    ROGUE {
        @Override
        public ProductionUnitType getCategory() {
            return UNIT;
        }
    },
    MAGE {
        @Override
        public ProductionUnitType getCategory() {
            return UNIT;
        }
    },
    ARCHER {
        @Override
        public ProductionUnitType getCategory() {
            return UNIT;
        }
    },
    SQUIRE {
        @Override
        public ProductionUnitType getCategory() {
            return UNIT;
        }
    },
    DIPLOMAT {
        @Override
        public ProductionUnitType getCategory() {
            return UNIT;
        }
    },
    GOLD {
        @Override
        public ProductionUnitType getCategory() {
            return GOLD;
        }
    },

    FOOD {
        @Override
        public ProductionUnitType getCategory() {
            return FOOD;
        }
    };


    public abstract ProductionUnitType getCategory();
}
