package com.blog.demo.entity;

import javassist.bytecode.stackmap.TypeData;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class AbstractEntityId<H extends Serializable> implements Serializable, EntityId<H>
{

    private H id;
    @ArtifactForFramework
    protected AbstractEntityId() {
        super();
    }

    protected AbstractEntityId(H id) {
        this.id = Objects.requireNonNull(id);
    }

    @Override
    public H getId(){
        return id;
    }

    @Override
    public String asString(){
        return id.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {

        boolean result = false;

        if(this == obj){
            result = true;
        } else if (obj instanceof AbstractEntityId){
            AbstractEntityId other = (AbstractEntityId) obj;
            result = Objects.equals(id, other.id);
        }
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return new StringJoiner(",", TypeData.ClassName.class.getSimpleName() +"[","]")
                .add("id" + id)
                .toString();

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}

/***
 * Interface for Primary keys of entities.
 * @param <H> the underlying type of entity id
 */
interface EntityId<H> extends Serializable{

    H getId();
    String asString();

}

@Retention(value = RetentionPolicy.SOURCE)
@interface ArtifactForFramework{

}