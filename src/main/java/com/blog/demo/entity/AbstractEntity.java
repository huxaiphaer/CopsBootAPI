package com.blog.demo.entity;

import javassist.bytecode.stackmap.TypeData;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@MappedSuperclass
public abstract class AbstractEntity <T extends EntityId> implements EntityId<T> {

    @EmbeddedId
    private T id;

    @ArtifactForFramework
    protected AbstractEntity(){
    }

    public AbstractEntity(T id){
//        this.id = Preconditions.checkNotNull(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else if (obj instanceof AbstractEntity) {
            AbstractEntity other = (AbstractEntity) obj;
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

    @Override
    public T getId() {
        return id;
    }

    @Override
    public String asString() {
        return null;
    }
}

