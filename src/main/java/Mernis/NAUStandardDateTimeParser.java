
package Mernis;

//------------------------------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 9.0.1.0
//
// Created by Quasar Development 
//
// This class has been generated for test purposes only and cannot be used in any commercial project.
// To use it in commercial project, you need to generate this class again with Premium account.
// Check https://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
//
// Licence: F6DE6F68E7C2E9D469FD6E42E47BEE156C89DDB15949D72EAE7B3CE29072B54F8D795DCA91EF4B633C7A3C5B1472C7002BC560A3F2A00E698EBD7262800355C1
//------------------------------------------------------------------------
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;


public class NAUStandardDateTimeParser implements NAUDateTimeParser
{

    public String getStringFromDate(java.time.LocalDate date)
    {
        if(date==null)
        {
            return null;
        }
        return java.time.format.DateTimeFormatter.ISO_DATE.format(date);
    }

    public String getStringFromTime(java.time.LocalTime date)
    {
        if (date == null)
        {
            return null;
        }
        return java.time.format.DateTimeFormatter.ISO_LOCAL_TIME.format(date);
    }

    public String getStringFromDuration(java.time.Duration date)
    {
        if (date == null)
        {
            return null;
        }
        return date.toString();
    }

    public String getStringFromDateTime(java.time.ZonedDateTime date)
    {
        if (date == null) {
            return null;
        }
        return java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(date);
    }

    public java.time.ZonedDateTime parse(String value)
    {
        if (value == null)
        {
            return null;
        }
        java.time.format.DateTimeFormatterBuilder builder = new java.time.format.DateTimeFormatterBuilder();
        DateTimeFormatter formatter = builder
            .parseCaseInsensitive()
            .append(java.time.format.DateTimeFormatter.ISO_DATE_TIME)
            .optionalStart().appendZoneOrOffsetId().optionalEnd()
            .toFormatter();

        TemporalAccessor parsed = formatter.parseBest(value,new TemporalQuery[]{
                temporalAccessor -> java.time.ZonedDateTime.from(temporalAccessor),
                temporal -> java.time.LocalDateTime.from(temporal)
        });

        if (parsed instanceof java.time.ZonedDateTime) {
            return (java.time.ZonedDateTime)parsed;
        }
        java.time.LocalDateTime local =(java.time.LocalDateTime) parsed;
        return local.atZone( java.time.ZoneOffset.UTC);
    }

    public java.time.LocalDate parseLocal(String value)
    {
        if (value == null)
        {
            return null;
        }
        return java.time.LocalDate.parse(value);
    }

    public java.time.Duration parseDuration(String value)
    {
        if (value == null) {
            return null;
        }
        return java.time.Duration.parse(value);
    }

    public java.time.LocalTime parseTime(String value) {
        if (value == null)
        {
            return null;
        }
        return java.time.LocalTime.parse(value, java.time.format.DateTimeFormatter.ISO_TIME);
    }

}