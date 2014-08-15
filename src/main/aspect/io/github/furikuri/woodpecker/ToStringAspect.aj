package io.github.furikuri.woodpecker;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public aspect ToStringAspect {
    private interface ReflectiveToString {}

    declare parents: (@io.github.furikuri.woodpecker.annotation.ToString *) implements ReflectiveToString;

    public String ReflectiveToString.toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
