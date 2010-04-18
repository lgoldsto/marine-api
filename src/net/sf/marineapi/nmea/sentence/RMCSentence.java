/* 
 * RMCSentence.java
 * Copyright (C) 2010 Kimmo Tuukkanen
 * 
 * This file is part of Java Marine API.
 * <http://sourceforge.net/projects/marineapi/>
 * 
 * Java Marine API is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Java Marine API is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Java Marine API. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.marineapi.nmea.sentence;

import net.sf.marineapi.nmea.util.DataStatus;
import net.sf.marineapi.nmea.util.Direction;
import net.sf.marineapi.nmea.util.GpsMode;

/**
 * Interface for RMC sentence type. Recommended minimum navigation information;
 * date/time, current location, speed over ground, true course over ground and
 * magnetic variation.
 * <p>
 * Example:<br>
 * <code>$GPRMC,120044,A,6011.552,N,02501.941,E,000.0,360.0,160705,006.1,E*7C</code>
 * 
 * @author Kimmo Tuukkanen
 * @version $Revision$
 */
/**
 * @author Kimmo Tuukkanen
 * @version $Revision$
 */
public interface RMCSentence extends PositionSentence, TimeSentence,
        DateSentence {

    /**
     * Get the corrected course over ground. Correction is done by subtracting
     * or adding the magnetic variation from true course (easterly variation
     * subtracted and westerly added).
     * 
     * @return Corrected true course
     * @see #getCourse()
     * @see #getVariation()
     */
    double getCorrectedCourse();

    /**
     * Get true course over ground (COG).
     * 
     * @return True course in degrees.
     */
    double getCourse();

    /**
     * Set true course over ground (COG).
     * 
     * @param course True course in degrees.
     */
    void setCourse(double cog);

    /**
     * Gets the data status, valid or invalid.
     * 
     * @return DataStatus.VALID or DataStatus.INVALID
     */
    DataStatus getDataStatus();

    /**
     * Set the data status, valid or invalid.
     * 
     * @param status DataStatus.VALID or DataStatus.INVALID
     */
    void setDataStatus(DataStatus status);

    /**
     * Get the direction of magnetic variation; east or west.
     * 
     * @return Direction.EAST or Direction.WEST
     */
    Direction getDirectionOfVariation();

    /**
     * Set the direction of magnetic variation, east or west.
     * 
     * @param dir Direction.EAST or Direction.WEST
     * @throws IllegalArgumentException If specified Direction is other than
     *             defined as valid for param <code>dir</code>.
     */
    void setDirectionOfVariation(Direction dir);

    /**
     * Get the GPS operating mode.
     * 
     * @return GpsMode enum
     */
    GpsMode getGpsMode();

    /**
     * Set the GPS operation mode.
     * 
     * @param mode Mode to set
     */
    void setGpsMode(GpsMode mode);

    /**
     * Get current speed over ground (SOG).
     * 
     * @return Speed in knots (nautical miles per hour).
     */
    double getSpeed();

    /**
     * Set current speed over ground (SOG).
     * 
     * @param sog Speed in knots (nautical miles per hour).
     */
    void setSpeed(double sog);

    /**
     * Get the magnetic variation. Easterly variation subtracts from true
     * course, and is thus returned as negative value. Otherwise, the value is
     * positive.
     * 
     * @return Magnetic variation in degrees
     */
    double getVariation();

    /**
     * Set the magnetic variation.
     * 
     * @param var Magnetic variation in degrees
     */
    void setVariation(double var);
}
