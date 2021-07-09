package com.akomanin.mockitobeginner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



import java.util.List;

public class ListTest {
    @Test
    void test() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10);
        Assertions.assertEquals(10, listMock.size());
    }

    @Test
    void test_multipleReturns() {
        //testing for multiple returns - testing multiple answers at the same time
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10).thenReturn(34);
        Assertions.assertEquals(10, listMock.size());
        Assertions.assertEquals(34, listMock.size());
    }

    @Test
    void testGet() {
        //testing for an instance where a parameter is passed
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("The first Element is a dog");
        Assertions.assertEquals("The first Element is a dog", listMock.get(0));
        Assertions.assertEquals(null, listMock.get(1));
    }

    @Test
    void testGet_GenericParameter() {
        //testing for an instance where a any parameter is passed
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("The first Element is a dog");
        Assertions.assertEquals("The first Element is a dog", listMock.get(0));
    }
}
