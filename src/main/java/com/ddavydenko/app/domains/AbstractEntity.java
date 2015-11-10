/**
 * 
 */
package com.ddavydenko.app.domains;

import java.io.Serializable;

/**
 * @author ddavydenko
 *
 */
public abstract class AbstractEntity implements Serializable{


    abstract public Long getId();

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        AbstractEntity entity = (AbstractEntity) o;

        return getId() != null &&
            getId().equals(entity.getId());
        

    }
}
