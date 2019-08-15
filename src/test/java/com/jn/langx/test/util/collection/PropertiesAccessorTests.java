package com.jn.langx.test.util.collection;

import com.jn.langx.util.collection.PropertiesAccessor;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

public class PropertiesAccessorTests {
    @Test
    public void test() {
        Properties props = new Properties();
        props.setProperty("a", "3");
        props.setProperty("b", "false");
        props.setProperty("c", "cccc");

        PropertiesAccessor accessor = new PropertiesAccessor(props);
        Assert.assertFalse(accessor.getBoolean("b"));
        Assert.assertTrue(accessor.getInteger("a") == 3);
        Assert.assertTrue(accessor.get("c").equals("cccc"));
    }
}