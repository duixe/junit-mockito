package com.akomanin.mockitobeginner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.security.RunAs;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockAnnotationTest {
    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl businessImpl;

    @Test
    void testFindTheGreatestFromAllData() {
        when(dataServiceMock.retrieveData()).thenReturn(new int[] {23, 12, 9});
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

