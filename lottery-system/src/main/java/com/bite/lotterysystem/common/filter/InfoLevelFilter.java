package com.bite.lotterysystem.common.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.classic.Level;
/**
 * @Shootingmemory
 * @create 2025-03-14-17:36
 */
public class InfoLevelFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent iLoggingEvent) {
        if (iLoggingEvent.getLevel().toInt() == Level.INFO.toInt()){
            return FilterReply.ACCEPT;
        }
        return FilterReply.DENY;
    }
}