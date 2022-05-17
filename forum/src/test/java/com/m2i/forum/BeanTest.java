package com.m2i.forum;

import org.junit.Test;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.*;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.Validator;

public class BeanTest {
    private ValidatorBuilder createValidatorBuilder() {
        return ValidatorBuilder.create()
                .with(new SetterTester())
                .with(new GetterTester())

                .with(new EqualsAndHashCodeMatchRule())
                .with(new NoStaticExceptFinalRule())
                .with(new SerializableMustHaveSerialVersionUIDRule())

                .with(new NoFieldShadowingRule())
                .with(new NoPublicFieldsExceptStaticFinalRule());
    }

    private void validate(Validator validator, String packageName) {
        validator.validate(PojoClassFactory.getPojoClassesRecursively(
                packageName,
                clazz -> !clazz.getSourcePath().contains("/test-classes/")
        ));
    }
    @Test
    public void testModels() {
        Validator validator = createValidatorBuilder().build();
        validate(validator, "com.m2i.forum.models");
    }
    @Test
    public void testDto() {
        Validator validator = createValidatorBuilder().build();
        validate(validator, "com.m2i.forum.dto");
    }
}