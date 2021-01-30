package io.github.mat3e;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloServiceTest {
    /**
     * SUT (System under test)
     */
    private HelloService SUT = new HelloService();

    @Test
    public void test_prepareGreeting_null_returnsGreetingWithFallBackValue() {
        //given + when
        var result = SUT.prepareGreeting(null);
        //then
        assertEquals("Hello " + HelloService.FALLBACK_NAME + "!", result);
    }
    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName() {
        //given
        var name = "test";
        // when
        var result = SUT.prepareGreeting(name);
        //then
        assertEquals("Hello " + name + "!", result);
    }
}