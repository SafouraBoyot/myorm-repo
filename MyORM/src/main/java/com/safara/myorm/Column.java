package com.safara.myorm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author safoura
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    
    public String name() default "";
    
}
