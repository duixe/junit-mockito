package com.akomanin.mockitobeginner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SomeBusinessTest {
    @Test
    void testFindTheGreatestFromAllData() {
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());
        int result = businessImpl.findTheGreatestFromAllData();

        Assertions.assertEquals(24, result);

    }
}

class DataServiceStub implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[] {24, 6, 15};
    }
}
