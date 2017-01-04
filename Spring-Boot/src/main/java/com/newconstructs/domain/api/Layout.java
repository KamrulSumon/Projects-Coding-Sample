package com.newconstructs.domain.api;

import java.lang.annotation.*;


@Target({
        ElementType.METHOD, ElementType.TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Layout {
    public String name() default "default";        // name of the layout to be used

    public String title();

    public String description();

    public String selectedNav() default "";
}

