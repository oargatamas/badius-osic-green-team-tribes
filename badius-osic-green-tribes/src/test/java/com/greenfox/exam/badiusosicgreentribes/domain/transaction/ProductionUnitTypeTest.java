package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ProductionUnitTypeTest {

    @ParameterizedTest
    @ArgumentsSource(ProductionUnitTypeArgumentsProvider.class)
    public void testGetCategory(ProductionUnitType unitType, ProductionUnitType expectedCategory) {
        assertEquals(expectedCategory, unitType.getCategory());
    }

    public static class ProductionUnitTypeArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(ProductionUnitType.BUILDING, ProductionUnitType.BUILDING),
                    Arguments.of(ProductionUnitType.RESOURCE, ProductionUnitType.RESOURCE),
                    Arguments.of(ProductionUnitType.UNIT, ProductionUnitType.UNIT),
                    Arguments.of(ProductionUnitType.TOWNHALL, ProductionUnitType.BUILDING),
                    Arguments.of(ProductionUnitType.MINE, ProductionUnitType.BUILDING),
                    Arguments.of(ProductionUnitType.FARM, ProductionUnitType.BUILDING),
                    Arguments.of(ProductionUnitType.BARRACK, ProductionUnitType.BUILDING),
                    Arguments.of(ProductionUnitType.ACADEMY, ProductionUnitType.BUILDING),
                    Arguments.of(ProductionUnitType.KNIGHT, ProductionUnitType.UNIT),
                    Arguments.of(ProductionUnitType.ROGUE, ProductionUnitType.UNIT),
                    Arguments.of(ProductionUnitType.MAGE, ProductionUnitType.UNIT),
                    Arguments.of(ProductionUnitType.ARCHER, ProductionUnitType.UNIT),
                    Arguments.of(ProductionUnitType.SQUIRE, ProductionUnitType.UNIT),
                    Arguments.of(ProductionUnitType.DIPLOMAT, ProductionUnitType.UNIT),
                    Arguments.of(ProductionUnitType.GOLD, ProductionUnitType.GOLD),
                    Arguments.of(ProductionUnitType.FOOD, ProductionUnitType.FOOD)
            );
        }
    }

}