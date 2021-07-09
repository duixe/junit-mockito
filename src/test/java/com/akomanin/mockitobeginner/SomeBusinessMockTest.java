package com.akomanin.mockitobeginner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {
    @Test
    void testFindTheGreatestFromAllData() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveData()).thenReturn(new int[] {23, 12, 9});

        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();

        Assertions.assertEquals(23, result);

    }

    @Test
    void testFindTheGreatestFromAllData_forSingleValue() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveData()).thenReturn(new int[] {23});

        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();

        Assertions.assertEquals(23, result);
    }
}

